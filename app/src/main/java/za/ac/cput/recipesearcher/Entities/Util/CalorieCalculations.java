package za.ac.cput.recipesearcher.Entities.Util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.Ingredient;
import za.ac.cput.recipesearcher.Entities.Recipe;

public class CalorieCalculations {
    private final int caloriesPerGramProtein = 4;
    private final int caloriesPerGramCarbs = 4;
    private final int caloriesPerGramFat = 9;
    private final int caloriesPerGramFibre = 2;

    private int totalMacrosProtein;
    private int totalMacrosCarbs;
    private int totalMacrosFat;
    private int totalMacrosFibre;

    private int caloriesPerIngredient;
    private int calories;

    private List<Ingredient> ingredientList;

    public CalorieCalculations(Ingredient...ingredients){
        this.ingredientList = Arrays.asList(ingredients);
    }

    public int calculateCaloriesPerIngredient(){
        for(Ingredient ingred : ingredientList){
            totalMacrosProtein = ingred.getMacros().getTotalProtein();
            totalMacrosCarbs = ingred.getMacros().getTotalCarbs();
            totalMacrosFat = ingred.getMacros().getTotalFat();
            totalMacrosFibre = ingred.getMacros().getTotalFibre();

            caloriesPerIngredient += (totalMacrosProtein * caloriesPerGramProtein);
            caloriesPerIngredient += (totalMacrosCarbs * caloriesPerGramCarbs);
            caloriesPerIngredient += (totalMacrosFat * caloriesPerGramFat);
            caloriesPerIngredient += (totalMacrosFibre * caloriesPerGramFibre);

            calories += caloriesPerIngredient;
            return caloriesPerIngredient;
        }

        return 0;
    }

    public int getTotalCalories(){
        return calories;
    }
}
