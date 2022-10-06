package za.ac.cput.recipesearcher.Repository;

import java.util.List;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.Entities.RecipeModel;

public interface RecipeRepository extends IRepository<RVSubCategoryModel, String>{
    public RVSubCategoryModel save(RVSubCategoryModel recipe);
    public RVSubCategoryModel read(RVSubCategoryModel recipe);
    public List<RVSubCategoryModel> readAll();
}
