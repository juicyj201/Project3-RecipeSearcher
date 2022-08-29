package za.ac.cput.recipesearcher.Activities;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.RVMainCategoryModel;
import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel_Favourites;
import za.ac.cput.recipesearcher.R;
import za.ac.cput.recipesearcher.adapters.RVMainCategoryAdapter;
import za.ac.cput.recipesearcher.adapters.RVSubCategoryAdapter_Favourites;

public class FavouritesFragment extends Fragment {

    RecyclerView rvMainCategory_favourites;
    RecyclerView rvSubCategory_favourites;
    List<RVMainCategoryModel> rvMainCategoryList_favourites;
    List<RVSubCategoryModel_Favourites> rvSubCategoryList_favourites;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_favourites, container, false);

        //Main Recipe Categories
        rvMainCategory_favourites = view.findViewById(R.id.rv_main_category_favourites);

        rvMainCategoryList_favourites = new ArrayList<>();

        rvMainCategoryList_favourites.add(new RVMainCategoryModel(R.drawable.fire, "Breakfast"));
        rvMainCategoryList_favourites.add(new RVMainCategoryModel(R.drawable.fire, "Lunch"));
        rvMainCategoryList_favourites.add(new RVMainCategoryModel(R.drawable.fire, "Supper"));
        rvMainCategoryList_favourites.add(new RVMainCategoryModel(R.drawable.fire, "Dessert"));
        rvMainCategoryList_favourites.add(new RVMainCategoryModel(R.drawable.fire, "Beverages"));
        rvMainCategoryList_favourites.add(new RVMainCategoryModel(R.drawable.fire, "Beer"));

        rvMainCategory_favourites.setLayoutManager(new LinearLayoutManager(rvMainCategory_favourites.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvMainCategory_favourites.setAdapter(new RVMainCategoryAdapter(getContext(), rvMainCategoryList_favourites));
        rvMainCategory_favourites.setHasFixedSize(true);
        rvMainCategory_favourites.setNestedScrollingEnabled(true);

        rvMainCategory_favourites.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        //Sub Recipe Category 2
        rvSubCategory_favourites = view.findViewById(R.id.rv_sub_category_favourites);

        rvSubCategoryList_favourites = new ArrayList<>();

        rvSubCategoryList_favourites.add(new RVSubCategoryModel_Favourites(R.drawable.pexels_pixabay_315755, "Macaronni & Cheese", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategoryList_favourites.add(new RVSubCategoryModel_Favourites(R.drawable.pexels_pixabay_315755, "Spaghetti", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategoryList_favourites.add(new RVSubCategoryModel_Favourites(R.drawable.pexels_pixabay_315755, "Pizza", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategoryList_favourites.add(new RVSubCategoryModel_Favourites(R.drawable.pexels_pixabay_315755, "Butter Chicken", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategoryList_favourites.add(new RVSubCategoryModel_Favourites(R.drawable.pexels_pixabay_315755, "Cheese Burger", "This recipe has been passed on by through generations.", "10min", "200kcal"));

        rvSubCategory_favourites.setLayoutManager(new LinearLayoutManager(rvSubCategory_favourites.getContext(), LinearLayoutManager.VERTICAL, false));
        rvSubCategory_favourites.setAdapter(new RVSubCategoryAdapter_Favourites(getContext(), rvSubCategoryList_favourites));
        rvSubCategory_favourites.setHasFixedSize(true);
        rvSubCategory_favourites.setNestedScrollingEnabled(true);

        rvSubCategory_favourites.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        return view;
    }
}