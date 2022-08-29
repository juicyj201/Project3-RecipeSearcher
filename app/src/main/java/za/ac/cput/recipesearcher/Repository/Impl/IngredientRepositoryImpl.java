package za.ac.cput.recipesearcher.Repository.Impl;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.Ingredient;
import za.ac.cput.recipesearcher.Repository.IngredientRepository;

public class IngredientRepositoryImpl implements IngredientRepository {
    private FirebaseDatabase db;
    private DatabaseReference ingredientrepo;
    private Task<DataSnapshot> task;

    public IngredientRepositoryImpl(){
        db = FirebaseDatabase.getInstance();
        ingredientrepo = db.getReference("ingredients");
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if(!ingredient.equals(null)){
            ingredientrepo.child(ingredient.getIngredientName()).setValue(ingredient);
        }

        return ingredient;
    }

    @Override
    public Ingredient read(Ingredient ingredient) {
        Task<DataSnapshot> task = ingredientrepo.get();
        Ingredient dbIngre = null;
        while(task.getResult().exists()) {
            if (task.getResult().getValue(Ingredient.class).equals(ingredient)) {
                dbIngre = task.getResult().getValue(Ingredient.class);
            }
        }

        return dbIngre;
    }


    @Override
    public List<Ingredient> readAll() {
        Task<DataSnapshot> task = ingredientrepo.get();
        List<Ingredient> ingredientList = new ArrayList<>();
        while(task.getResult().exists()) {
            ingredientList.add(task.getResult().getValue(Ingredient.class));
        }

        return ingredientList;
    }
}
