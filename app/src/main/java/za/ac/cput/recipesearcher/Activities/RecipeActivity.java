package za.ac.cput.recipesearcher.Activities;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import za.ac.cput.recipesearcher.R;
import za.ac.cput.recipesearcher.databinding.ActivityRecipeScreenBinding;

import android.util.Log;

import za.ac.cput.recipesearcher.Repository.Impl.*;

public class RecipeActivity extends AppCompatActivity {

//	private static final String TAG = "RecipeActivity";
//	private RecipeRepositoryImpl repo = new RecipeRepositoryImpl();
//
//    private AppBarConfiguration appBarConfiguration;
//    private ActivityRecipeScreenBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityRecipeScreenBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_recipe_screen);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_recipe_screen);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}