package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

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
       btnSignUp = (Button) findViewById(R.id.btnRegister);
       cbxNoties = (CheckBox) findViewById(R.id.cbxConfirmNotifications);

       //Button onclicks
       btnSignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final EditText fn = (EditText) findViewById(R.id.edtName);
               final EditText sn = (EditText) findViewById(R.id.edtSurname);
               final EditText em = (EditText) findViewById(R.id.edtEmail);
               final EditText pass = (EditText) findViewById(R.id.edtPassword);

               String email = em.getText().toString();
               String password = pass.getText().toString();
               String firstname = fn.getText().toString();
               String surname = sn.getText().toString();

               final Profile user = new Profile.ProfileBuilder().createName(firstname).createSurname(surname).createEmail(email).build();
               profilerepo.save(user);

               //create new user with google firebase in json storage
               //validation will use regex
               if(regexValidation(email, password) && cbxNoties.isChecked()){
                   signUp(email, password);
               }else{
                   Toast.makeText(SignupActivity.this, "The user input is not correct and cboxNoties has not been checked.", Toast.LENGTH_SHORT).show();
               }
           }
       });
   }

   private boolean regexValidation(String e, String pass){
       Pattern reemail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]+$", Pattern.CASE_INSENSITIVE);
       Pattern repass = Pattern.compile("^[A-Z0-9._%+-]{0,8}$", Pattern.CASE_INSENSITIVE);
       Matcher emailm = reemail.matcher(e);
       Matcher passm = repass.matcher(pass);
       if (emailm.find() && passm.find()){
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
                       if (task.isSuccessful()) {
                           Toast.makeText(SignupActivity.this, "Sign up with JONG CENA, success.", Toast.LENGTH_SHORT).show();
                           //Toast.makeText(SignupActivity.this, "createUserWithEmail:success", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(SignupActivity.this, HomeActivity.class));
                       } else {
                           String e = String.valueOf(task.getException());
                           Toast.makeText(SignupActivity.this, e, Toast.LENGTH_SHORT).show();
                           Toast.makeText(SignupActivity.this, "AMOGUS", Toast.LENGTH_SHORT).show();
                           Toast.makeText(SignupActivity.this, "SUS", Toast.LENGTH_SHORT).show();
                           Toast.makeText(SignupActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                       }
                   }
               });
   }
}