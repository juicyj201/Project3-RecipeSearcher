package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import za.ac.cput.recipesearcher.R;

public class GetStartedWelcome2Activity extends AppCompatActivity {

    private TextView txtSkip;
    private TextView txtNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started_welcome2);

        //Initialize TextViews
        txtSkip = findViewById(R.id.txtSkip);
        txtNext = findViewById(R.id.txtNext);

        //Button Onclicks
        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetStartedWelcome2Activity.this, LoginActivity.class));
            }
        });

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetStartedWelcome2Activity.this, LoginActivity.class));
            }
        });
    }
}