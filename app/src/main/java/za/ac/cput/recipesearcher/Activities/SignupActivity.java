package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import za.ac.cput.recipesearcher.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

   private Button btnSignUp;
   private FirebaseAuth auth;
   private FirebaseUser user;
   private final String firstname = findViewById(R.id.edtName).toString();
   private final String surname = findViewById(R.id.edtSurname).toString();
   private final String email = findViewById(R.id.edtEmail).toString();
   private final String password = findViewById(R.id.edtPassword).toString();

   private static final String TAG = "RecipeActivity";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);

       //setting up authentication
       auth = FirebaseAuth.getInstance();

       //Initialize button
       btnSignUp = (Button) findViewById(R.id.btnSignIn);

       //Button onclicks
       btnSignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //create new user with google firebase in json storage
               //validation will use regex
               /**if(regexValidation(email, password)){signUp(email, password);}**/
               if(!email.equals(null) && !password.equals(null)){
                   signUp(email, password);
               }
           }
       });
   }

   private boolean regexValidation(String e, String pass){
       //not working yet :(
       boolean ematch = Pattern.matches("^[\\w+]@[\\w+][.][\\w+]$", e);
       if (ematch){
           return true;
       }else{
           return false;
       }
   }

   private void signUp(String email, String password) {
       //what are we going to do with the users' other information?
       auth.createUserWithEmailAndPassword(email, password)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Log.d(TAG, "createUserWithEmail:success");
                           user = auth.getCurrentUser();
                           startActivity(new Intent(SignupActivity.this, HomeActivity.class));
                       } else {
                           Log.w(TAG, "createUserWithEmail:failure", task.getException());
                           Toast.makeText(SignupActivity.this,
                                   "Authentication failed.",
                                   Toast.LENGTH_SHORT).show();

                           //TODO implement error activity or toast
                       }
                   }
               });
   }
}