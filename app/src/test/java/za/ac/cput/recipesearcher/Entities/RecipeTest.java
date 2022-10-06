package za.ac.cput.recipesearcher.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecipeTest {
    private final RVSubCategoryModel recipe = new RVSubCategoryModel.RVSubCategoryModelBuilder()
            .createName("French Toast")
            .createBio("(filler text)")
            .createEstimatedTime("15min")
            .createAmountOfCalories("200cal")
            .build();

    @Test
    void getRecipeName() {
        Assertions.assertFalse(recipe.getRecipeName().equals(null));
    }

    @Test
    void getRecipeBio() {
        Assertions.assertFalse(recipe.getRecipeBio().equals(null));
    }

    @Test
    void getEstimatedTime() {
        Assertions.assertFalse(recipe.getRecipeEstimatedTime().equals(null));
    }

    @Test
    void getCalories() {
        Assertions.assertFalse(recipe.getRecipeAmountOfCalories().equals(null));
    }

    @Test
    void testEquals() {
    }
}