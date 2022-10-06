package za.ac.cput.recipesearcher.Repository.Impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.Repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {
    private FirebaseDatabase db;
    private DatabaseReference reciperepo;

    public RecipeRepositoryImpl(){
        db = FirebaseDatabase.getInstance();
        reciperepo = db.getReference("recipe");
    }

    @Override
    public RVSubCategoryModel save(RVSubCategoryModel recipe) {
        if(!recipe.equals(null)){
            reciperepo.child(recipe.getRecipeName()).setValue(recipe);
        }

        return recipe;
    }

    @Override
    public RVSubCategoryModel read(RVSubCategoryModel recipe) {
        RVSubCategoryModel dbRecipe;

        //if there is a recipe with the specific searched for, return task object using onComplete method
        Task<DataSnapshot> snap = reciperepo.child(recipe.getRecipeName()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>(){
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isComplete()){
                    Log.i("RecipeRepositoryImpl", String.valueOf(task.getResult().getValue(RVSubCategoryModel.class)));
                }
            }
        });

        return snap.getResult().getValue(RVSubCategoryModel.class);
    }

    @Override
    public List<RVSubCategoryModel> readAll() {
        List<RVSubCategoryModel> recipeList = new ArrayList<>();

        Task<DataSnapshot> snap = reciperepo.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>(){
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isComplete()){
                    Log.i("RecipeRepositoryImpl", String.valueOf(task.getResult().getValue(RVSubCategoryModel.class)));
                }
            }
        });

        while(snap.isSuccessful()){
            recipeList.add(snap.getResult().getValue(RVSubCategoryModel.class));
        }

        return recipeList;
    }
}
