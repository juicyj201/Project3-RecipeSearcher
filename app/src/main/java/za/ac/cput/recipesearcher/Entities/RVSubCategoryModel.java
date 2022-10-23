package za.ac.cput.recipesearcher.Entities;

public class RVSubCategoryModel {

    long recipeImage;
    String recipeName;
    String recipeBio;
    String recipeEstimatedTime;
    String recipeAmountOfCalories;
    String category;

    public RVSubCategoryModel(){
        //empty constructor
    }

    public RVSubCategoryModel(long recipeImage, String recipeName, String recipeBio, String recipeEstimatedTime, String recipeAmountOfCalories, String category) {
        this.recipeImage = recipeImage;
        this.recipeName = recipeName;
        this.recipeBio = recipeBio;
        this.recipeEstimatedTime = recipeEstimatedTime;
        this.recipeAmountOfCalories = recipeAmountOfCalories;
    }

    public RVSubCategoryModel(RVSubCategoryModelBuilder builder){
        this.recipeImage = builder.recipeImage;
        this.recipeName = builder.recipeName;
        this.recipeBio = builder.recipeBio;
        this.recipeEstimatedTime = builder.recipeEstimatedTime;
        this.recipeAmountOfCalories = builder.recipeAmountOfCalories;
    }

    public long getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(long recipeImage) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static class RVSubCategoryModelBuilder {
        public static long recipeImage;
        public static String recipeName;
        public static String recipeBio;
        public static String recipeEstimatedTime;
        public static String recipeAmountOfCalories;

        public RVSubCategoryModelBuilder(){
//            this.recipeImage = recipeImage;
//            this.recipeName = recipeName;
//            this.recipeBio = recipeBio;
//            this.recipeEstimatedTime = recipeEstimatedTime;
//            this.recipeAmountOfCalories = recipeAmountOfCalories;
        }

        public RVSubCategoryModelBuilder createImage(long recipeImage){
            this.recipeImage = recipeImage;
            return this;
        }

        public RVSubCategoryModelBuilder createName(String recipeName){
            this.recipeName = recipeName;
            return this;
        }

        public RVSubCategoryModelBuilder createBio(String recipeBio){
            this.recipeBio = recipeBio;
            return this;
        }

        public RVSubCategoryModelBuilder createEstimatedTime(String recipeEstimatedTime){
            this.recipeEstimatedTime = recipeEstimatedTime;
            return this;
        }

        public RVSubCategoryModelBuilder createAmountOfCalories(String recipeAmountOfCalories){
            this.recipeAmountOfCalories = recipeAmountOfCalories;
            return this;
        }

        public RVSubCategoryModel build(){
            return new RVSubCategoryModel(this);
        }
    }
}
