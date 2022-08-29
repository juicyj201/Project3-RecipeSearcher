package za.ac.cput.recipesearcher.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import za.ac.cput.recipesearcher.R;

public class Settings extends AppCompatActivity {

    ImageButton imgButton_settingsBack;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//        //Initialize button
//        imgButton_settingsBack = findViewById(R.id.imgbtn_back);
//
//        //Button Onclicks
//        imgButton_settingsBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fragmentManager = getSupportFragmentManager();
//                ProfileFragment profileFragment = new ProfileFragment();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container, profileFragment)
//                        .commit();
//            }
//        });


    }
}