package za.ac.cput.recipesearcher.Repository;

import java.util.List;

import za.ac.cput.recipesearcher.Entities.RecipeModel;

public interface RecipeRepository extends IRepository<RecipeModel, String>{
    public RecipeModel save(RecipeModel recipe);
    public RecipeModel read(RecipeModel recipe);
    public List<RecipeModel> readAll();
}
