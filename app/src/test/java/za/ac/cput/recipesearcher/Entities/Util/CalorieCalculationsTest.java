package za.ac.cput.recipesearcher.Entities.Util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import za.ac.cput.recipesearcher.Entities.Ingredient;

class CalorieCalculationsTest {
    private final CalorieCalculations calc = new CalorieCalculations(new Ingredient.IngredientBuilder("Flour",0,0,1,"Powder", new Macros(11, 107, 1, 2)).build());

    @Test
    void calculateCaloriesPerIngredient() {
        Assertions.assertNotNull(calc.calculateCaloriesPerIngredient());
    }

    @Test
    void getTotalCalories() {
        Assertions.assertNotNull(calc.getTotalCalories());
    }
}