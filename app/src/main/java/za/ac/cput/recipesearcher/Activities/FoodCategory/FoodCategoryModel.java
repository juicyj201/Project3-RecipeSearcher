package za.ac.cput.recipesearcher.Activities.FoodCategory;

public class FoodCategoryModel {

    Integer images;
    String categoryName;

    public FoodCategoryModel(Integer images, String categoryName) {
        this.images = images;
        this.categoryName = categoryName;
    }

    public Integer getImages() {
        return images;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
