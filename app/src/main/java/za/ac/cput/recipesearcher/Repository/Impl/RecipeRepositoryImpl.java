package za.ac.cput.recipesearcher.Repository.Impl;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.Repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {
    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    private ValueEventListener listener;

    public RecipeRepositoryImpl(){
    }

    @Override
    public RVSubCategoryModel save(RVSubCategoryModel recipe) {
        if(!recipe.equals(null)){
            //ref.child("recipe").child(recipe.getRecipeName()).setValue(recipe);
            ref.child("recipe").child(recipe.getRecipeName()).setValue(recipe);
            if(ref.child("recipe").child(recipe.getRecipeName()).get().isSuccessful())
                ref.child("recipe").child(recipe.getRecipeName()).get().getResult();
        }

        return null;
    }

    @Override
    public RVSubCategoryModel read(RVSubCategoryModel recipe) {
        return ref.child("recipe").child(recipe.getRecipeName()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Log.i("RecipeRepositoryImpl", String.valueOf(task.getResult().getValue(RVSubCategoryModel.class)));
            }
        }).getResult().getValue(RVSubCategoryModel.class);
    }

    @Override
    public List<RVSubCategoryModel> readAll() {
        List<RVSubCategoryModel> recipeList = new ArrayList<>();

        while (ref.child("recipe").get().getResult().exists()) {
            RVSubCategoryModel mod = ref.child("recipe").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    Log.i("RecipeRepositoryImpl", String.valueOf(task.getResult().getValue(RVSubCategoryModel.class)));
                }
            }).getResult().getValue(RVSubCategoryModel.class);

            recipeList.add(mod);
        }

        return recipeList;
    }
}
