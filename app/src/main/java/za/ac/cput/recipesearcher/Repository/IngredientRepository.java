package za.ac.cput.recipesearcher.Repository;

import java.util.List;

import za.ac.cput.recipesearcher.Entities.Ingredient;

public interface IngredientRepository extends IRepository<Ingredient, String>{
    public Ingredient save(Ingredient ingredient);
    public Ingredient read(Ingredient ingredient);
    public List<Ingredient> readAll();
}
