package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import za.ac.cput.recipesearcher.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //setting up firebase authentication
        mAuth = FirebaseAuth.getInstance();

        //Initialize button
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        //Button onclicks
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login user from google firebase previous json records

                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }
}