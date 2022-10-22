package za.ac.cput.recipesearcher.Activities;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import za.ac.cput.recipesearcher.Entities.Profile;
import za.ac.cput.recipesearcher.R;

public class EditProfile extends AppCompatActivity {

    private FirebaseUser user;
    private String userId, email, name;
    private Activity previousScreen;
    private TextView txtSaveData;
    private Button btnReset;
    private ImageButton btnBack;
    private EditText edtName, edtSurname, edtEmail;
    private ImageView profileImageView;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    DocumentReference documentReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        name = intent.getStringExtra("name");

        //Setting reference to profile image view
        profileImageView = (ImageView) findViewById(R.id.img_profilepic);

        //setting up firebase authentication
        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("user");

        //Setting user variables
        user = firebaseAuth.getCurrentUser();
        userId = firebaseAuth.getCurrentUser().getUid();

        //Setting reference for edit profile editviews
        edtName = (EditText) findViewById(R.id.edtName);
        edtSurname = (EditText) findViewById(R.id.edtSurname);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        txtSaveData = (TextView) findViewById(R.id.txtSaveData);
        btnBack = (ImageButton) findViewById(R.id.editprofile_back);
        btnReset = (Button) findViewById(R.id.btnResetPassword);

        //Saves and updates user information in firebase
        txtSaveData.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //Check if edit text fields isnt empty
                if (edtName.getText().toString().isEmpty() || edtSurname.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty()) {
                    Toast.makeText(EditProfile.this, "One or many fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                String email = edtEmail.getText().toString();
                //Updates email, if true then it updates the other information as well.
                user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //Retrieves user information from db
                        //DocumentReference documentReference = firestore.collection("user").document(user.getUid());

                        //Stores local data in map, making information unique
                        Map<String, Object> editedInformation = new HashMap<>();
                        editedInformation.put("email", email);
                        editedInformation.put("name", edtName.getText().toString());
                        editedInformation.put("surname", edtSurname.getText().toString());

                        //Profile profile = new Profile(email, edtSurname.getText().toString(), edtName.getText().toString());

                        databaseReference.child(name).updateChildren(editedInformation).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(EditProfile.this, "Profile has been successfully updated!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(EditProfile.this, Profile.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("tag", "Profile update unsuccessful!");
                            }
                        });
                    }
                    //Initiates when user information update failed.
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("tag", e.getMessage());
                    }
                });
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            String name, surname;
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (Objects.equals(ds.child("email").getValue(), email)) {
                        name = ds.child("name").getValue(String.class);
                        surname = ds.child("surname").getValue(String.class);
                        email = ds.child("email").getValue(String.class);
                        Log.d(TAG, "onDataChange: " + name + " " + surname);
                        break;
                    }
                }

                edtName.setText(name);
                edtSurname.setText(surname);
                edtEmail.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("tag", "User not found! " + error.getMessage());
            }
        });

        //Allows every user to have their own profile image
        StorageReference profileRef = storageReference.child("user/"+ firebaseAuth.getCurrentUser().getUid()+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Picasso.get().load(R.drawable.profile_pic);
                Log.e("tag","User doesn't have a profile picture yet. Loaded local image.");
            }
        });

        //Allows user to choose image from internal storage
        profileImageView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open gallery, return image user clicked on
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1000);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this, Settings.class);
                startActivity(intent);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create editText for entering new email
                EditText resetEmail = new EditText(v.getContext());
                Log.d("tag", "Button Clicked!");
                //Popup window
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
                passwordResetDialog.setView(resetEmail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the email and send reset link

                        String mail = resetEmail.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(EditProfile.this, "Reset Link Send to Your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(EditProfile.this, "Error! Reset Link Not Sent. " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
            }
        });
    }

    //Log user out of application
    public void logout(android.view.View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    //Initializes when gallery intent returns a result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            if( resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();

                uploadImageToFirebase(imageUri);
            }
        }
    }

    //Upload image to firebase when called
    private void uploadImageToFirebase(Uri imageUri) {
        //Creates file reference object where image will be stored
        StorageReference fileRef = storageReference.child("user/" + firebaseAuth.getCurrentUser().getUid() + "/profile.jpg");
        //Stores image in firebase file reference object
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //Toast.makeText(EditProfile.this, "Image uploaded.", Toast.LENGTH_SHORT).show();
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(profileImageView);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EditProfile.this, "Failed to upload image.", Toast.LENGTH_SHORT).show();
                Log.d("tag", e.getMessage());
            }
        });
    }
}
