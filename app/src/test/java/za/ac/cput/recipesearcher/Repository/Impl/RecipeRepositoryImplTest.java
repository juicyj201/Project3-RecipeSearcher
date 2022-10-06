package za.ac.cput.recipesearcher.Repository.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;

public class RecipeRepositoryImplTest {
    private RecipeRepositoryImpl repo = new RecipeRepositoryImpl();
    private RVSubCategoryModel emptyrecipe = null;
    private final RVSubCategoryModel recipe = new RVSubCategoryModel.RVSubCategoryModelBuilder()
            .createName("French Toast")
            .createBio("(filler text)")
            .createEstimatedTime("15min")
            .createAmountOfCalories("200cal")
            .build();

    @Test
    void saveRecipe() {
        Assertions.assertFalse(repo.save(recipe) == null);
    }

    @Test
    void readRecipe() {
        Assertions.assertFalse(repo.read(recipe) == null);
    }

    @Test
    void testEquals() {
    }
}
