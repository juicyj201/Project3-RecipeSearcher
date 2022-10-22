package za.ac.cput.recipesearcher.Repository.Impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import za.ac.cput.recipesearcher.Entities.Profile;
import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.Repository.ProfileRepository;

public class ProfileRepositoryImpl implements ProfileRepository {
    //private FirebaseDatabase db;
    //private DatabaseReference profilerepo;
    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    private static List<Profile> profileList;
    private static List<String> emailList = new ArrayList<>();

    public ProfileRepositoryImpl(){
//        this.db = db;
//        this.profilerepo = profilerepo;
    }

    @Override
    public Profile save(Profile profile) {
        if(!profile.equals(null)){
            //ref.child("recipe").child(recipe.getRecipeName()).setValue(recipe);
            ref.child("user").child(profile.getName()).setValue(profile);
            if(ref.child("user").child(profile.getName()).get().isSuccessful())
                ref.child("user").child(profile.getName()).get().getResult();
        }

        return null;
    }

    @Override
    public Profile read(Profile profile) {
        return ref.child("user").child(profile.getName()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Log.i("ProfileRepositoryImpl", String.valueOf(task.getResult().getValue(Profile.class)));
            }
        }).getResult().getValue(Profile.class);
    }

    @Override
    public List<Profile> readAll() {
        return null;
    }

    //extra functionality
    public List<String> readEmail(){
        ref.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                emailList.addAll(getEmails((HashMap<String, Profile>) snapshot.getValue()));

                //emailList.add(snapshot.getValue(Profile.class).getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if(!emailList.equals(null))
            return emailList;
        else
            return null;
    }

    private List<String> getEmails(HashMap<String, Profile> profiles){
        List<String> emails = new ArrayList<>();
        for (Map.Entry<String, Profile> p: profiles.entrySet()) {
            emails.add(p.getValue().getEmail());
        }

        return emails;
    }
}
