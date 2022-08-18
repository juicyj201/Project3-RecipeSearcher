package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import za.ac.cput.recipesearcher.R;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize button
        btnSignUp = (Button) findViewById(R.id.btnSignIn);

        //Button onclicks
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create new user with google firebase in json storage

                startActivity(new Intent(SignupActivity.this, HomeActivity.class));
            }
        });
    }

}