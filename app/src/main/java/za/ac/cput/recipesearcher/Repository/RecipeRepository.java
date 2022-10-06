package za.ac.cput.recipesearcher.Repository;

import java.util.List;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;

public interface RecipeRepository extends IRepository<RVSubCategoryModel, String>{
    public RVSubCategoryModel save(RVSubCategoryModel recipe);
    public RVSubCategoryModel read(RVSubCategoryModel recipe);
    public List<RVSubCategoryModel> readAll();
}
