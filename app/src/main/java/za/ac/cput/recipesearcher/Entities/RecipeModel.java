//package za.ac.cput.recipesearcher.Entities;
//
//import android.os.Build;
//
//import androidx.annotation.RequiresApi;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import za.ac.cput.recipesearcher.Entities.Util.CalorieCalculations;
//
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//public class RecipeModel {
//	  
//    Name is primary key for recipe db
//	  String recipeName;
//    int recipeImage;
//    String recipeCategory;
//    String recipeRating;
//    String recipeCookingTime;
//    String recipeAmountOfServings;
//    String recipeAmountOfCalories;
//    String recipeSuggestions;
//    String recipeIngredients;
//    String recipeInstructions;
//
//    public RecipeModel(int recipeImage, String recipeCategory, String recipeName,
//                       String recipeRating, String recipeCookingTime, String recipeAmountOfServings,
//                       String recipeAmountOfCalories, String recipeSuggestions, String recipeIngredients,
//                       String recipeInstructions) {
//        this.recipeImage = recipeImage;
//        this.recipeCategory = recipeCategory;
//        this.recipeName = recipeName;
//        this.recipeRating = recipeRating;
//        this.recipeCookingTime = recipeCookingTime;
//        this.recipeAmountOfServings = recipeAmountOfServings;
//        this.recipeAmountOfCalories = recipeAmountOfCalories;
//        this.recipeSuggestions = recipeSuggestions;
//        this.recipeIngredients = recipeIngredients;
//        this.recipeInstructions = recipeInstructions;
//    }
//
//    public int getRecipeImage() {
//        return recipeImage;
//    }
//
//    public void setRecipeImage(int recipeImage) {
//        this.recipeImage = recipeImage;
//    }
//
//    public String getRecipeCategory() {
//        return recipeCategory;
//    }
//
//    public void setRecipeCategory(String recipeCategory) {
//        this.recipeCategory = recipeCategory;
//    }
//
//    public String getRecipeName() {
//        return recipeName;
//    }
//
//    public void setRecipeName(String recipeName) {
//        this.recipeName = recipeName;
//    }
//
//    public String getRecipeRating() {
//        return recipeRating;
//    }
//
//    public void setRecipeRating(String recipeRating) {
//        this.recipeRating = recipeRating;
//    }
//
//    public String getRecipeCookingTime() {
//        return recipeCookingTime;
//    }
//
//    public void setRecipeCookingTime(String recipeCookingTime) {
//        this.recipeCookingTime = recipeCookingTime;
//    }
//
//    public String getRecipeAmountOfServings() {
//        return recipeAmountOfServings;
//    }
//
//    public void setRecipeAmountOfServings(String recipeAmountOfServings) {
//        this.recipeAmountOfServings = recipeAmountOfServings;
//    }
//
//    public String getRecipeAmountOfCalories() {
//        return recipeAmountOfCalories;
//    }
//
//    public void setRecipeAmountOfCalories(String recipeAmountOfCalories) {
//        this.recipeAmountOfCalories = recipeAmountOfCalories;
//    }
//
//    public String getRecipeSuggestions() {
//        return recipeSuggestions;
//    }
//
//    public void setRecipeSuggestions(String recipeSuggestions) {
//        this.recipeSuggestions = recipeSuggestions;
//    }
//
//    public String getRecipeIngredients() {
//        return recipeIngredients;
//    }
//
//    public void setRecipeIngredients(String recipeIngredients) {
//        this.recipeIngredients = recipeIngredients;
//    }
//
//    public String getRecipeInstructions() {
//        return recipeInstructions;
//    }
//
//    public void setRecipeInstructions(String recipeInstructions) {
//        this.recipeInstructions = recipeInstructions;
//    }
//    private String recipeName;
//    private String recipeBio;
//    private String estimatedTime;
//    private List<Ingredient> ingredients;
//    //entire segment for calorie calclulations
//    private CalorieCalculations calorieCalc;
//    private int calories;
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public Recipe(RecipeBuilder recipeBuilder){
//        this.recipeName = recipeBuilder.recipeName;
//        this.recipeBio = recipeBuilder.recipeBio;
//        this.estimatedTime = recipeBuilder.estimatedTime;
//        this.ingredients = recipeBuilder.ingredients;
//        this.calories = recipeBuilder.calories;
//
//        //creating an instance for calorie calculations and ingredient array occurence
//        Ingredient[] array = ingredients.stream().toArray(Ingredient[]::new);
//        //since there is a variable amount of ingredients in the ingredient list we have to enter an array, or one or multiple values
//        this.calorieCalc = new CalorieCalculations(array);
//    }
//
//    public String getRecipeName() {
//        return recipeName;
//    }
//
//    public String getRecipeBio() {
//        return recipeBio;
//    }
//
//    public String getEstimatedTime() {
//        return estimatedTime;
//    }
//
//    public List<Ingredient> getIngredients(){
//        return ingredients;
//    }
//
//    public int getCalories() {
//        calories = calorieCalc.getTotalCalories();
//
//        return calories;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Recipe)) return false;
//        Recipe recipe = (Recipe) o;
//        return recipeName.equals(recipe.recipeName) && recipeBio.equals(recipe.recipeBio) && estimatedTime.equals(recipe.estimatedTime) && calories.equals(recipe.calories);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(recipeName, recipeBio, estimatedTime, calorieCalc);
//    }
//
//    @Override
//    public String toString() {
//        return "Recipe{" +
//                "recipeName='" + recipeName + '\'' +
//                ", recipeBio='" + recipeBio + '\'' +
//                ", estimatedTime='" + estimatedTime + '\'' +
//                ", calories='" + calorieCalc + '\'' +
//                '}';
//    }
//
//    public static class RecipeBuilder{
//        private static String recipeName;
//        private static String recipeBio;
//        private static String estimatedTime;
//        private static List<Ingredient> ingredients;
//        private static int calories;
//
//        public RecipeBuilder(){
//            this.recipeName = recipeName;
//            this.recipeBio = recipeBio;
//            this.estimatedTime = estimatedTime;
//            this.ingredients = ingredients;
//            this.calories = calories;
//        }
//
//        public RecipeBuilder createRecipeName(String recipeName){
//            this.recipeName = recipeName;
//            return this;
//        }
//
//        public RecipeBuilder createRecipeBio(String recipeBio){
//            this.recipeBio = recipeBio;
//            return this;
//        }
//
//        public RecipeBuilder createEstimateTime(String estimatedTime){
//            this.estimatedTime = estimatedTime;
//            return this;
//        }
//
//        public RecipeBuilder createIngredients(Ingredient...ingredients){
//            //create a list with all possible ingredients and set it as the new ingredient list for the recipe object
//            List<Ingredient> ingredientList = new ArrayList<>();
//            for(Ingredient ingredient : ingredients){
//                ingredientList.add(ingredient);
//            }
//
//            this.ingredients = ingredientList;
//
//            return this;
//        }
//
//        @RequiresApi(api = Build.VERSION_CODES.N)
//        public Recipe Build(){
//            return new Recipe(this);
//        }
//    }
//}
