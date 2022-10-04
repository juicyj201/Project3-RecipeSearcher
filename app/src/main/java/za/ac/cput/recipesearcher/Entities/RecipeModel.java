package za.ac.cput.recipesearcher.Entities;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import za.ac.cput.recipesearcher.Entities.Util.CalorieCalculations;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RecipeModel {
    private String recipeName;
    private int recipeImage;
    private String recipeCategory;
    private String recipeRating;
    private String recipeCookingTime;
    private String recipeAmountOfServings;
    private String recipeAmountOfCalories;
    private String recipeSuggestions;
    private String recipeIngredients;
    private String recipeInstructions;

    public RecipeModel(int recipeImage, String recipeCategory, String recipeName,
                       String recipeRating, String recipeCookingTime, String recipeAmountOfServings,
                       String recipeAmountOfCalories, String recipeSuggestions, String recipeIngredients,
                       String recipeInstructions) {
        this.recipeImage = recipeImage;
        this.recipeCategory = recipeCategory;
        this.recipeName = recipeName;
        this.recipeRating = recipeRating;
        this.recipeCookingTime = recipeCookingTime;
        this.recipeAmountOfServings = recipeAmountOfServings;
        this.recipeAmountOfCalories = recipeAmountOfCalories;
        this.recipeSuggestions = recipeSuggestions;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public RecipeModel(RecipeBuilder builder){
        this.recipeImage = builder.recipeImage;
        this.recipeCategory = builder.recipeCategory;
        this.recipeName = builder.recipeName;
        this.recipeRating = builder.recipeRating;
        this.recipeCookingTime = builder.recipeCookingTime;
        this.recipeAmountOfServings = builder.recipeAmountOfServings;
        this.recipeAmountOfCalories = builder.recipeAmountOfCalories;
        this.recipeSuggestions = builder.recipeSuggestions;
        this.recipeIngredients = builder.recipeIngredients;
        this.recipeInstructions = builder.recipeInstructions;
    }

    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeRating() {
        return recipeRating;
    }

    public void setRecipeRating(String recipeRating) {
        this.recipeRating = recipeRating;
    }

    public String getRecipeCookingTime() {
        return recipeCookingTime;
    }

    public void setRecipeCookingTime(String recipeCookingTime) {
        this.recipeCookingTime = recipeCookingTime;
    }

    public String getRecipeAmountOfServings() {
        return recipeAmountOfServings;
    }

    public void setRecipeAmountOfServings(String recipeAmountOfServings) {
        this.recipeAmountOfServings = recipeAmountOfServings;
    }

    public String getRecipeAmountOfCalories() {
        return recipeAmountOfCalories;
    }

    public void setRecipeAmountOfCalories(String recipeAmountOfCalories) {
        this.recipeAmountOfCalories = recipeAmountOfCalories;
    }

    public String getRecipeSuggestions() {
        return recipeSuggestions;
    }

    public void setRecipeSuggestions(String recipeSuggestions) {
        this.recipeSuggestions = recipeSuggestions;
    }

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public static class RecipeBuilder{
        public static String recipeName;
        public static int recipeImage;
        public static String recipeCategory;
        public static String recipeRating;
        public static String recipeCookingTime;
        public static String recipeAmountOfServings;
        public static String recipeAmountOfCalories;
        public static String recipeSuggestions;
        public static String recipeIngredients;
        public static String recipeInstructions;

        public RecipeBuilder(){
            this.recipeName = recipeName;
            this.recipeImage = recipeImage;
            this.recipeCategory = recipeCategory;
            this.recipeRating = recipeRating;
            this.recipeCookingTime = recipeCookingTime;
            this.recipeAmountOfServings = recipeAmountOfServings;
            this.recipeAmountOfCalories = recipeAmountOfCalories;
            this.recipeSuggestions = recipeSuggestions;
            this.recipeIngredients = recipeIngredients;
            this.recipeInstructions = recipeInstructions;
        }

        public RecipeBuilder createRecipeName(String recipeName){
            this.recipeName = recipeName;
            return this;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public RecipeModel Build(){
            return new RecipeModel(this);
        }
    }
}
