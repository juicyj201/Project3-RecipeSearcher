package za.ac.cput.recipesearcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import za.ac.cput.recipesearcher.Activities.GetStartedWelcome1Activity;

public class MainActivity extends AppCompatActivity {

    private Button btn_getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_getStarted = findViewById(R.id.btn_getStarted);

        btn_getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GetStartedWelcome1Activity.class));
            }
        });
    }
}