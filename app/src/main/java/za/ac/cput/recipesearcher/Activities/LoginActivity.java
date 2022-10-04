package za.ac.cput.recipesearcher.Activities;

import static java.lang.String.format;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

import za.ac.cput.recipesearcher.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    private Button btnSignUp;
    private FirebaseAuth auth;
    private FirebaseUser userAlreadySignedIn;
    private FirebaseUser userSigningIn;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //setting up firebase authentication
        auth = FirebaseAuth.getInstance();

        //Initialize button
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp2);

        //Button onclick
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = findViewById(R.id.edtEmailAddress).toString();
                final String password = findViewById(R.id.editTextTextPassword).toString();

                if(regexValidation(email, password)){
                    String message = "Email: "+email+", Password: "+password;
                    Log.i(TAG, message);
                    signIn(email, password);
                }
            }
        });

        //Button onclicks
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }

    private boolean regexValidation(String e, String pass){
        boolean ematch = Pattern.matches("^[a-zA-Z0-9 ]+@[a-zA-Z]+\\.[a-zA-Z]+$", e);
        boolean pmatch = Pattern.matches("^[a-zA-Z0-9_ ]{0,10}$", pass);
        if (ematch && pmatch){
            return true;
        }else{
            return false;
        }
    }

    private void signIn(String email, String password){
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Log.d(TAG, "signInWithEmail:success");
                            userSigningIn = auth.getCurrentUser();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        } else {
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                            //TODO error activity or toast will be implementted
                        }
                    }
                });
    }

    /**
    @Override
    protected void onStart() {
        super.onStart();

        //get the user that is currently logging in
        userAlreadySignedIn = auth.getCurrentUser();

        //validate user
        if(!userAlreadySignedIn.equals(null)) {
            updateUserInfo(userAlreadySignedIn);
        }
    }

    private void updateUserInfo(FirebaseUser userAlreadySignedIn){
        final TextView emailUpdateText = (TextView) findViewById(R.id.edtEmailAddress);
        emailUpdateText.setText(userAlreadySignedIn.getEmail());
        emailUpdateText.findFocus();
        //TODO Cant seem to get this working properly - i will create a hotfix for this after sign in and signup attempts work
        //final TextView passwordUpdateText = (TextView) findViewById(R.id.editTextTextPassword);
        //passwordUpdateText.setText(user.getPassword());
    }
    **/
}