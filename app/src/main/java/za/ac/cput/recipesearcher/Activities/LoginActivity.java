package za.ac.cput.recipesearcher.Activities;

import static java.lang.String.format;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import za.ac.cput.recipesearcher.Entities.Profile;
import za.ac.cput.recipesearcher.R;
import za.ac.cput.recipesearcher.Repository.Impl.ProfileRepositoryImpl;

@IgnoreExtraProperties
public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    private Button btnSignUp;
    private FirebaseAuth auth;
    private static final String TAG = "LoginActivity";
    private ProfileRepositoryImpl repo = new ProfileRepositoryImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //setting up firebase authentication
        auth = FirebaseAuth.getInstance();

        //Initialize button
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp2);

        Log.i(TAG, "Obtaining user information...");

        //Button onclick
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText em = (EditText) findViewById(R.id.edtEmailAddress);
                final EditText pass = (EditText) findViewById(R.id.editTextTextPassword);

                String email = em.getText().toString();
                String password = pass.getText().toString();

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("user");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot s : snapshot.getChildren()) {
                            Profile p = s.getValue(Profile.class);
                            System.out.println(s.getValue().toString());
                            Log.i(TAG, s.getValue().toString());
                            if (p.getEmail().equals(email)) {
                                Log.i(TAG, "Least the emails work");

                                if (regexValidation(email, password)) {
                                    signIn(email, password);
                                    break;
                                } else {
                                    Toast.makeText(LoginActivity.this, "The user input is not correct.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Log.i(TAG, "That email does not work.");
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
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

    private void signIn(String email, String password){
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Sign in with JONG CENA, success.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        } else {
                            String e = String.valueOf(task.getException());
                            Log.i(TAG, e);
                            Toast.makeText(LoginActivity.this, e, Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, "L + bozo + email = weak", Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //TODO error activity or toast will be implementted
                        }
                    }
                });
    }

    /**
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser == null){
            Toast.makeText(LoginActivity.this, "User is empty bruh \uD83D\uDC80", Toast.LENGTH_SHORT).show();
        }if(currentUser != null){
            EditText email = (EditText) findViewById(R.id.edtEmail);
            EditText pass = (EditText) findViewById(R.id.edtPassword);
            email.setText(currentUser.getEmail().toString());
            pass.findFocus();
        }
    }
    **/
}