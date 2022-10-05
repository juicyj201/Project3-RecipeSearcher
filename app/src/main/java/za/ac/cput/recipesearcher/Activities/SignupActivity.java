package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import za.ac.cput.recipesearcher.Entities.Profile;
import za.ac.cput.recipesearcher.R;
import za.ac.cput.recipesearcher.Repository.Impl.ProfileRepositoryImpl;
import za.ac.cput.recipesearcher.Repository.ProfileRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
   private Button btnSignUp;
   private CheckBox cbxNoties;
   private FirebaseAuth auth;

   //TODO - Create profile-type object that saves the first name and surname to the profile
   private ProfileRepositoryImpl profilerepo = new ProfileRepositoryImpl();

   private static final String TAG = "SignUpActivity";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_signup);

       //setting up authentication
       auth = FirebaseAuth.getInstance();

       //Initialize button
       //btnSignUp = (Button) findViewById(R.id.btnSignUp);
       btnSignUp = (Button) findViewById(R.id.testBtnSignUp);
       cbxNoties = (CheckBox) findViewById(R.id.cbxConfirmNotifications);

       //Button onclicks
       btnSignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String firstname = findViewById(R.id.edtName).toString();
               final String surname = findViewById(R.id.edtSurname).toString();
               final String email = findViewById(R.id.edtEmail).toString();
               final String password = findViewById(R.id.edtPassword).toString();

               //TODO - implement profile entity creation and saving the results of such object
               //final Profile user = new Profile.ProfileBuilder().createName(firstname).createSurname(surname).createEmail(email).build();
               //profilerepo.save(user);

               //create new user with google firebase in json storage
               //validation will use regex
               /**if(regexValidation(email)){
                   signUp(email, password);
               }**/
               if(!email.equals(null) && cbxNoties.isChecked()){
                   signUp(email, password);
               }else{
                   Toast.makeText(SignupActivity.this, "The user input is not correct and cboxNoties has not been checked.", Toast.LENGTH_SHORT).show();
               }
           }
       });
   }

   private boolean regexValidation(String e){
       Pattern reemail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]+$", Pattern.CASE_INSENSITIVE);
       Matcher emailm = reemail.matcher(e);
       //boolean ematch = Pattern.matches("^[a-zA-Z0-9_ ]+@[a-zA-Z]+\\.[a-zA-Z]+$", e);
       if (emailm.find()){
           return true;
       }else{
           return false;
       }
   }

   private void signUp(String email, String password) {
       auth.createUserWithEmailAndPassword(email, password)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       Toast.makeText(SignupActivity.this, "This message has been brought to you by JONG CENA.", Toast.LENGTH_SHORT).show();

                       if (task.isSuccessful()) {
                           //Log.d(TAG, "createUserWithEmail:success");
                           Toast.makeText(SignupActivity.this, "createUserWithEmail:success", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(SignupActivity.this, HomeActivity.class));
                       } else {
                           //Log.e(TAG, "createUserWithEmail:failure", task.getException());
                           Toast.makeText(SignupActivity.this, "createUserWithEmail:failure", Toast.LENGTH_SHORT).show();
                           Toast.makeText(SignupActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                       }
                   }
               });
   }
}