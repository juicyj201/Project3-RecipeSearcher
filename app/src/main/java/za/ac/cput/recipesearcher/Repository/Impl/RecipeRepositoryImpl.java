//package za.ac.cput.recipesearcher.Repository.Impl;
//
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import za.ac.cput.recipesearcher.Entities.Recipe;
//import za.ac.cput.recipesearcher.Repository.RecipeRepository;
//
//public class RecipeRepositoryImpl implements RecipeRepository {
//    private FirebaseDatabase db;
//    private DatabaseReference reciperepo;
//    private Task<DataSnapshot> task;
//
//    public RecipeRepositoryImpl(){
//        db = FirebaseDatabase.getInstance();
//        reciperepo = db.getReference("recipe");
//    }
//
//    @Override
//    public Recipe save(Recipe recipe) {
//        if(!recipe.equals(null)){
//            reciperepo.child(recipe.getRecipeName()).setValue(recipe);
//        }
//
//        return recipe;
//    }
//
//    @Override
//    public Recipe read(Recipe recipe) {
//        Task<DataSnapshot> task = reciperepo.get();
//        Recipe dbRecipe = null;
//        while(task.getResult().exists()) {
//            if (task.getResult().getValue(Recipe.class).equals(recipe)) {
//                dbRecipe = task.getResult().getValue(Recipe.class);
//            }
//        }
//
//        return dbRecipe;
//    }
//
//    @Override
//    public List<Recipe> readAll() {
//        Task<DataSnapshot> task = reciperepo.get();
//        List<Recipe> recipeList = new ArrayList<>();
//        while(task.getResult().exists()) {
//            recipeList.add(task.getResult().getValue(Recipe.class));
//        }
//
//        return recipeList;
//    }
//}
