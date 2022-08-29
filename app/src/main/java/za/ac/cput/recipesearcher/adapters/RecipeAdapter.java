//package za.ac.cput.recipesearcher.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//import za.ac.cput.recipesearcher.Entities.RVMainCategoryModel;
//import za.ac.cput.recipesearcher.Entities.RecipeModel;
//import za.ac.cput.recipesearcher.R;
//
//public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{
//
//    Context context;
//    List<RecipeModel> list;
//
//    public RecipeAdapter(Context context, List<RecipeModel> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new RecipeAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_recipe_screen, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
////        holder.recipeImage.setImageResource(list.get(position).getRecipeImage());
////        holder.recipeCategory.setText(list.get(position).getRecipeCategory());
////        holder.recipeName.setText(list.get(position).getRecipeName());
////        holder.recipeRating.setText(list.get(position).getRecipeRating());
////        holder.recipeCookingTime.setText(list.get(position).getRecipeCookingTime());
////        holder.recipeAmountOfServings.setText(list.get(position).getRecipeAmountOfServings());
////        holder.recipeAmountOfCalories.setText(list.get(position).getRecipeAmountOfCalories());
////        holder.recipeSuggestions.setText(list.get(position).getRecipeSuggestions());
////
////
////        ArrayAdapter<String> recipeIngredientsAdapter = new ArrayAdapter<String>(this, R.layout.activity_recipe_screen, list.get(position).getRecipeIngredients());
//////        holder.recipeIngredients.setAdapter(list.get(position).getRecipeIngredients());
//////        holder.recipeIngredients.setAdapter(list.get(position).getRecipeIngredients());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView recipeImage;
//        TextView recipeCategory;
//        TextView recipeName;
//        TextView recipeRating;
//        TextView recipeCookingTime;
//        TextView recipeAmountOfServings;
//        TextView recipeAmountOfCalories;
//        TextView recipeSuggestions;
//        ListView recipeIngredients;
//        ListView recipeInstructions;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            recipeImage = itemView.findViewById(R.id.img_dish);
//            recipeCategory = itemView.findViewById(R.id.txt_recipe_category);
//            recipeName = itemView.findViewById(R.id.txt_recipe_name);
//            recipeRating = itemView.findViewById(R.id.txtRating);
//            recipeCookingTime = itemView.findViewById(R.id.metaTime);
//            recipeAmountOfServings = itemView.findViewById(R.id.metaServings);
//            recipeAmountOfCalories = itemView.findViewById(R.id.metaCalories);
//            recipeSuggestions = itemView.findViewById(R.id.metaSuggestions);
//            recipeIngredients = itemView.findViewById(R.id.list_ingredients);
//            recipeInstructions = itemView.findViewById(R.id.list_instructions);
//
//        }
//    }
//}
