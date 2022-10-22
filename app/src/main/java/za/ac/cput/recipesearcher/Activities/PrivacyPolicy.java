package za.ac.cput.recipesearcher.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import za.ac.cput.recipesearcher.R;

public class PrivacyPolicy extends AppCompatActivity {

    ImageButton imgBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        imgBtnBack = (ImageButton) findViewById(R.id.imgbtn_back);

        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyPolicy.this, Settings.class);
                startActivity(intent);
            }
        });
    }
}