package za.ac.cput.recipesearcher.Repository.Impl;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.Entities.RecipeModel;
import za.ac.cput.recipesearcher.Repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {
    private FirebaseDatabase db;
    private DatabaseReference reciperepo;
    private Task<DataSnapshot> task;

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
        task = reciperepo.get();
        RVSubCategoryModel dbRecipe = null;
        if(task.isSuccessful()) {
            if (task.getResult().getValue(RVSubCategoryModel.class).equals(recipe)) {
                dbRecipe = task.getResult().getValue(RVSubCategoryModel.class);
            }
        }

        return dbRecipe;
    }

    @Override
    public List<RVSubCategoryModel> readAll() {
        task = reciperepo.get();
        List<RVSubCategoryModel> recipeList = new ArrayList<>();
        if(task.isSuccessful()) {
            while(task.getResult().exists()){
                recipeList.add(task.getResult().getValue(RVSubCategoryModel.class));
            }
        }

        return recipeList;
    }
}
