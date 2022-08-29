package za.ac.cput.recipesearcher.Entities;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import za.ac.cput.recipesearcher.Entities.Util.CalorieCalculations;

public class Recipe {
    private String recipeName;
    private String recipeBio;
    private String estimatedTime;
    private List<Ingredient> ingredients;
    //entire segment for calorie calclulations
    private CalorieCalculations calorieCalc;
    private int calories;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Recipe(RecipeBuilder recipeBuilder){
        this.recipeName = recipeBuilder.recipeName;
        this.recipeBio = recipeBuilder.recipeBio;
        this.estimatedTime = recipeBuilder.estimatedTime;
        this.ingredients = recipeBuilder.ingredients;
        this.calories = recipeBuilder.calories;

        //creating an instance for calorie calculations and ingredient array occurence
        Ingredient[] array = ingredients.stream().toArray(Ingredient[]::new);
        //since there is a variable amount of ingredients in the ingredient list we have to enter an array, or one or multiple values
        this.calorieCalc = new CalorieCalculations(array);
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeBio() {
        return recipeBio;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public List<Ingredient> getIngredients(){
        return ingredients;
    }

    public int getCalories() {
        calories = calorieCalc.getTotalCalories();

        return calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return recipeName.equals(recipe.recipeName) && recipeBio.equals(recipe.recipeBio) && estimatedTime.equals(recipe.estimatedTime) && calories.equals(recipe.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName, recipeBio, estimatedTime, calorieCalc);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", recipeBio='" + recipeBio + '\'' +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", calories='" + calorieCalc + '\'' +
                '}';
    }

    public static class RecipeBuilder{
        private static String recipeName;
        private static String recipeBio;
        private static String estimatedTime;
        private static List<Ingredient> ingredients;
        private static int calories;

        public RecipeBuilder(){
            this.recipeName = recipeName;
            this.recipeBio = recipeBio;
            this.estimatedTime = estimatedTime;
            this.ingredients = ingredients;
            this.calories = calories;
        }

        public RecipeBuilder createRecipeName(String recipeName){
            this.recipeName = recipeName;
            return this;
        }

        public RecipeBuilder createRecipeBio(String recipeBio){
            this.recipeBio = recipeBio;
            return this;
        }

        public RecipeBuilder createEstimateTime(String estimatedTime){
            this.estimatedTime = estimatedTime;
            return this;
        }

        public RecipeBuilder createIngredients(Ingredient...ingredients){
            //create a list with all possible ingredients and set it as the new ingredient list for the recipe object
            List<Ingredient> ingredientList = new ArrayList<>();
            for(Ingredient ingredient : ingredients){
                ingredientList.add(ingredient);
            }

            this.ingredients = ingredientList;

            return this;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public Recipe Build(){
            return new Recipe(this);
        }
    }
}
