package za.ac.cput.recipesearcher.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecipeTest {
    //Apologies for the unprofessional user object :|
    private final Recipe recipe = new Recipe.RecipeBuilder()
            .createRecipeName("French Toast")
            .createRecipeBio("(filler text)")
            .createEstimateTime("15 minutes")
            .createCalories()
            .build();

    @Test
    void getRecipeName() {
        Assertions.assertFalse(user.getId().equals(null));
    }

    @Test
    void getRecipeBio() {
    }

    @Test
    void getEstimatedTime() {
    }

    @Test
    void getCalories() {
    }

    @Test
    void testEquals() {
    }
}