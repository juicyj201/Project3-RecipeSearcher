package za.ac.cput.recipesearcher.Repository;

import java.util.List;

import za.ac.cput.recipesearcher.Entities.Recipe;

public interface RecipeRepository extends IRepository<Recipe, String>{
    public Recipe save(Recipe recipe);
    public Recipe read(Recipe recipe);
    public List<Recipe> readAll();
}
