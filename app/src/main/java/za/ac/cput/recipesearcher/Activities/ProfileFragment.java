package za.ac.cput.recipesearcher.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.R;
import za.ac.cput.recipesearcher.adapters.RVSubCategoryAdapter;

public class ProfileFragment extends Fragment {

    RecyclerView rvSub1Category;
    List<RVSubCategoryModel> rvSubCategory1List;
    ImageView imgSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //Initialize TextViews
        imgSettings = view.findViewById(R.id.img_settings);

        //Button Onclicks
        imgSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Settings.class);
                startActivity(intent);
            }
        });

        //Sub Recipe Category 1
        rvSub1Category = view.findViewById(R.id.rv_sub_category1);

        rvSubCategory1List = new ArrayList<>();

        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Macaronni & Cheese", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Spaghetti", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Pizza", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Butter Chicken", "This recipe has been passed on by through generations.", "10min", "200kcal"));
        rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Cheese Burger", "This recipe has been passed on by through generations.", "10min", "200kcal"));

        rvSub1Category.setLayoutManager(new LinearLayoutManager(rvSub1Category.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvSub1Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategory1List));
        rvSub1Category.setHasFixedSize(true);
        rvSub1Category.setNestedScrollingEnabled(true);

        rvSub1Category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        return view;
    }
}