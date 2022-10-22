package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

import za.ac.cput.recipesearcher.Entities.Profile;
import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.R;
import za.ac.cput.recipesearcher.Repository.Impl.ProfileRepositoryImpl;
import za.ac.cput.recipesearcher.adapters.RVSubCategoryAdapter;

public class ProfileFragment extends Fragment {
    //TODO - add functionality for calling the user objects from the database using repository
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fStore;
    FirebaseDatabase firebaseDatabase;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    private FirebaseUser user;
    private String userId, email, name;

    private static final String TAG = "ProfileFragment";

    RecyclerView rvSub1Category;
    List<RVSubCategoryModel> rvSubCategory1List;
    ImageView imgSettings, profileImg;
    TextView editProfile, txtName;
    Profile profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Intent intent = getActivity().getIntent();
        email = intent.getStringExtra("email");

        //Makes settings image clickable
        imgSettings = view.findViewById(R.id.img_settings);
        profileImg = view.findViewById(R.id.img_profilepic);
        //Makes edit profile text clickable
        editProfile = view.findViewById(R.id.txt_editprofile);
        //Name text
        txtName = view.findViewById(R.id.txt_name);

        //instantiate firebase user
        firebaseAuth = FirebaseAuth.getInstance();

        //Setting user variables
        user = firebaseAuth.getCurrentUser();
        userId = firebaseAuth.getCurrentUser().getUid();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("user");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (Objects.equals(ds.child("email").getValue(), email)) {

                        name = ds.child("name").getValue(String.class);
                        String surname = ds.child("surname").getValue(String.class);

                        txtName.setText(name + " " + surname);
                        editProfile.setText(email);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("tag", "User not found! " + error.getMessage());
            }
        });

        //instantiate firebase storage
        fStore = FirebaseFirestore.getInstance();
        //instantiate storage reference
        storageReference = FirebaseStorage.getInstance().getReference();

        //Settings onclick event
        imgSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Settings.class);
                intent.putExtra("email", email);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //Edit onclick event
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), EditProfile.class);
                intent.putExtra("email", email);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        //Allows every user to have their own profile image
        StorageReference profileRef = storageReference.child("user/"+ firebaseAuth.getCurrentUser().getUid()+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImg);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Picasso.get().load(R.drawable.profile_pic);
                Log.e("tag","User doesn't have a profile picture yet. Loaded local image.");
            }
        });



        //Sub Recipe Category 1
        rvSub1Category = view.findViewById(R.id.rv_sub_category1);

        rvSubCategory1List = new ArrayList<>();

        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Macaronni & Cheese", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Spaghetti", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Pizza", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Butter Chicken", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Cheese Burger", "This recipe has been passed on by through generations.", "10min", "200kcal"));

        rvSub1Category.setLayoutManager(new LinearLayoutManager(rvSub1Category.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvSub1Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategory1List));
        rvSub1Category.setHasFixedSize(true);
        rvSub1Category.setNestedScrollingEnabled(true);

        rvSub1Category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        return view;
    }
}