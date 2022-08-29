package za.ac.cput.recipesearcher.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel_Favourites;
import za.ac.cput.recipesearcher.R;

public class RVSubCategoryAdapter_Favourites extends RecyclerView.Adapter<RVSubCategoryAdapter_Favourites.ViewHolder>{

    Context context;
    List<RVSubCategoryModel_Favourites> list;

    public RVSubCategoryAdapter_Favourites(Context context, List<RVSubCategoryModel_Favourites> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rv_sub_category_favourites, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVSubCategoryAdapter_Favourites.ViewHolder holder, int position) {
        holder.img_recipe.setImageResource(list.get(position).getRecipeImage());
        holder.txt_recipe_name.setText(list.get(position).getRecipeName());
        holder.txt_bio.setText(list.get(position).getRecipeBio());
        holder.txt_estimated_time.setText(list.get(position).getRecipeEstimatedTime());
        holder.txt_amount_of_calories.setText(list.get(position).getRecipeAmountOfCalories());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_recipe;
        TextView txt_recipe_name;
        TextView txt_bio;
        TextView txt_estimated_time;
        TextView txt_amount_of_calories;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_recipe = itemView.findViewById(R.id.img_dish);
            txt_recipe_name = itemView.findViewById(R.id.recipe_name);
            txt_bio = itemView.findViewById(R.id.recipe_bio);
            txt_estimated_time = itemView.findViewById(R.id.txt_estimatedtime);
            txt_amount_of_calories = itemView.findViewById(R.id.txt_amountofcalories);
        }
    }
}
