package za.ac.cput.recipesearcher.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import za.ac.cput.recipesearcher.R;

public class Settings extends AppCompatActivity {

    ImageButton imgButton_settingsBack;
    CardView cv_editprofile, cv_privacypolicy;
    String email, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        cv_editprofile = findViewById(R.id.cv_editprofile);
        cv_privacypolicy = findViewById(R.id.cv_privacypolicy);
        imgButton_settingsBack = findViewById(R.id.imgbtn_back);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        name = intent.getStringExtra("name");

        cv_editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, EditProfile.class);
                intent.putExtra("email", email);
                intent.putExtra("name", name);
                intent.putExtra("previousScreen", "Settings");
                startActivity(intent);
            }
        });

        cv_privacypolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, PrivacyPolicy.class);
                startActivity(intent);
            }
        });

        imgButton_settingsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, ProfileFragment.class);
                startActivity(intent);
            }
        });
    }
}