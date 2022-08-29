package za.ac.cput.recipesearcher.Activities.FoodCategory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import za.ac.cput.recipesearcher.R;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.ViewHolder> {

    ArrayList<FoodCategoryModel> foodCategoryModels;
    Context context;

    public FoodCategoryAdapter(Context context, ArrayList<FoodCategoryModel> foodCategoryModels) {
        this.context = context;
        this.foodCategoryModels = foodCategoryModels;
    }

    public FoodCategoryAdapter(ArrayList<FoodCategoryModel> foodCategoryModels) {
        this.foodCategoryModels = foodCategoryModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_main_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodCategoryAdapter.ViewHolder holder, int position) {
        //Set Logo to ImageView
        holder.imageView.setImageResource(foodCategoryModels.get(position).getImages());
        //Set Name to TextView
        holder.textView.setText(foodCategoryModels.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return foodCategoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize variable
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            imageView = itemView.findViewById(R.id.img_fire_unselected);
            textView = itemView.findViewById(R.id.txt_category_name);
        }
    }
}
