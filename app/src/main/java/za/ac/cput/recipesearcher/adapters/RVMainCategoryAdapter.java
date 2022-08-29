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

import za.ac.cput.recipesearcher.Entities.RVMainCategoryModel;
import za.ac.cput.recipesearcher.R;

public class RVMainCategoryAdapter extends RecyclerView.Adapter<RVMainCategoryAdapter.ViewHolder>{

    Context context;
    List<RVMainCategoryModel> list;

    public RVMainCategoryAdapter(Context context, List<RVMainCategoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rv_main_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVMainCategoryAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getCategoryIcon());
        holder.name.setText(list.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_fire_unselected);
            name = itemView.findViewById(R.id.txt_category_name);
        }
    }
}
