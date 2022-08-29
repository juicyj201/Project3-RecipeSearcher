package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import za.ac.cput.recipesearcher.R;
import za.ac.cput.recipesearcher.databinding.ActivityGetStartedWelcome1Binding;

public class GetStartedWelcome1Activity extends AppCompatActivity {

    private TextView txtSkip;
    private TextView txtNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started_welcome1);

//Initialize Buttons
        txtSkip = findViewById(R.id.txtSkip);
        txtNext = findViewById(R.id.txtNext);

//Button Onclicks
        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetStartedWelcome1Activity.this, LoginActivity.class));
            }
        });

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetStartedWelcome1Activity.this, GetStartedWelcome2Activity.class));
            }
        });
    }
}