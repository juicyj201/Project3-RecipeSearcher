package za.ac.cput.recipesearcher.Entities.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.Ingredient;
import za.ac.cput.recipesearcher.Entities.Recipe;

public class CalorieCalculations {
    private final int macrosProtein = 4;
    private final int macrosCarbs = 4;
    private final int macrosFat = 9;
    private final int macrosFibre = 2;
    private int totalProtein;
    private int totalCarbs;
    private int totalFat;
    private int totalFibre;
    private int calories;

    private List<Ingredient> ingredientList;

    public CalorieCalculations(Ingredient...ingredients){
        this.ingredientList = Arrays.asList(ingredients);
    }

    public int calculateMacros(){

    }
}
