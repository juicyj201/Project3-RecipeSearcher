package za.ac.cput.recipesearcher.Entities;

public class RVSubCategoryModel {

    int recipeImage;
    String recipeName;
    String recipeBio;
    String recipeEstimatedTime;
    String recipeAmountOfCalories;
    //String recipeCategory - this needs to be added in the fragment functions

    public RVSubCategoryModel(int recipeImage, String recipeName, String recipeBio, String recipeEstimatedTime, String recipeAmountOfCalories) {
        this.recipeImage = recipeImage;
        this.recipeName = recipeName;
        this.recipeBio = recipeBio;
        this.recipeEstimatedTime = recipeEstimatedTime;
        this.recipeAmountOfCalories = recipeAmountOfCalories;
    }

    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeBio() {
        return recipeBio;
    }

    public void setRecipeBio(String recipeBio) {
        this.recipeBio = recipeBio;
    }

    public String getRecipeEstimatedTime() {
        return recipeEstimatedTime;
    }

    public void setRecipeEstimatedTime(String recipeEstimatedTime) {
        this.recipeEstimatedTime = recipeEstimatedTime;
    }

    public String getRecipeAmountOfCalories() {
        return recipeAmountOfCalories;
    }

    public void setRecipeAmountOfCalories(String recipeAmountOfCalories) {
        this.recipeAmountOfCalories = recipeAmountOfCalories;
    }
}
