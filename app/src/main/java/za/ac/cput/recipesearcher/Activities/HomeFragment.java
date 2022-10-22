package za.ac.cput.recipesearcher.Activities;

import android.app.Activity;
import android.app.LauncherActivity;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import za.ac.cput.recipesearcher.Activities.FoodCategory.FoodCategoryAdapter;
import za.ac.cput.recipesearcher.Activities.FoodCategory.FoodCategoryModel;
import za.ac.cput.recipesearcher.Entities.Profile;
import za.ac.cput.recipesearcher.Entities.RVMainCategoryModel;
import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;
import za.ac.cput.recipesearcher.R;
import za.ac.cput.recipesearcher.Repository.Impl.RecipeRepositoryImpl;
import za.ac.cput.recipesearcher.adapters.RVMainCategoryAdapter;
import za.ac.cput.recipesearcher.adapters.RVSubCategoryAdapter;

public class HomeFragment extends Fragment {

        RecyclerView rvMainCategory;
        RecyclerView rvSub1Category, rvSub2Category;
        List<RVMainCategoryModel> rvMainCategoryList;
        List<RVSubCategoryModel> rvSubCategory1List, rvSubCategory2List;

        private Activity act;
        private RecipeRepositoryImpl repo = new RecipeRepositoryImpl();

        private static final String TAG = "HomeFragment";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_home, container, false);

            act = this.getActivity();

            //Main Recipe Categories
            rvMainCategory = view.findViewById(R.id.rv_main_category);
            rvMainCategoryList = new ArrayList<>();

//            rvMainCategoryList.add(new RVMainCategoryModel(R.drawable.fire, "Breakfast"));
//            rvMainCategoryList.add(new RVMainCategoryModel(R.drawable.fire, "Lunch"));
//            rvMainCategoryList.add(new RVMainCategoryModel(R.drawable.fire, "Supper"));
//            rvMainCategoryList.add(new RVMainCategoryModel(R.drawable.fire, "Dessert"));
//            rvMainCategoryList.add(new RVMainCategoryModel(R.drawable.fire, "Beverages"));
//            rvMainCategoryList.add(new RVMainCategoryModel(R.drawable.fire, "Beer"));=
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("category");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot s : snapshot.getChildren()) {
                        RVMainCategoryModel m = s.getValue(RVMainCategoryModel.class);
                        System.out.println(s.getValue().toString());
                        Log.i(TAG, s.getValue().toString());
                        m.setCategoryIcon(R.drawable.fire);
                        rvMainCategoryList.add(m);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e(TAG, error.getMessage());
                }
            });

            rvMainCategory.setLayoutManager(new LinearLayoutManager(rvMainCategory.getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvMainCategory.setAdapter(new RVMainCategoryAdapter(getContext(), rvMainCategoryList));
            rvMainCategory.setHasFixedSize(true);
            rvMainCategory.setNestedScrollingEnabled(true);

            rvMainCategory.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

            //Sub Recipe Category 1
            rvSub1Category = view.findViewById(R.id.rv_sub_category1);
            rvSubCategory1List = new ArrayList<>();

            //Sub Recipe Category 2
            rvSub2Category = view.findViewById(R.id.rv_sub_category2);
            rvSubCategory2List = new ArrayList<>();

            //Getting data from the realtime database
            DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference().child("recipe");
            ref2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot s : snapshot.getChildren()) {
                        RVSubCategoryModel r = s.getValue(RVSubCategoryModel.class);
                        System.out.println(s.getValue().toString());
                        Log.i(TAG, s.getValue().toString());
                        r.setRecipeImage(R.drawable.pexels_pixabay_315755);
                        //here i read all the data into the two lists
                        rvSubCategory1List.add(r);
                        rvSubCategory2List.add(r);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e(TAG, error.getMessage());
                }
            });

//            rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Macaronni & Cheese", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
//            rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Spaghetti", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
//            rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Pizza", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
//            rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Butter Chicken", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
//            rvSubCategory1List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Cheese Burger", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
            rvSub1Category.setLayoutManager(new LinearLayoutManager(rvSub1Category.getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvSub1Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategory1List));
            rvSub1Category.setHasFixedSize(true);
            rvSub1Category.setNestedScrollingEnabled(true);

            rvSub1Category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

//            rvSubCategory2List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Macaronni & Cheese", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
//            rvSubCategory2List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Spaghetti", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
//            rvSubCategory2List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Pizza", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
//            rvSubCategory2List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Butter Chicken", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
//            rvSubCategory2List.add(new RVSubCategoryModel(R.drawable.pexels_pixabay_315755, "Cheese Burger", "This recipe has been passed on by through generations.", "10min", "200kcal", "Supper"));
            rvSub2Category.setLayoutManager(new LinearLayoutManager(rvSub2Category.getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvSub2Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategory2List));
            rvSub2Category.setHasFixedSize(true);
            rvSub2Category.setNestedScrollingEnabled(true);

            rvSub2Category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

            //Sort by category
            rvMainCategory.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Toast.makeText(act, "About to get the categories", Toast.LENGTH_SHORT).show();

                    List<RVSubCategoryModel> rvSubCategoryNewList = new ArrayList<>();
                    for (RVSubCategoryModel m : rvSubCategory1List) {
                        if (m.getCategory().equalsIgnoreCase(view.findViewById(R.id.txt_category_name).toString())) {
                            for (RVMainCategoryModel c : rvMainCategoryList) {
                                if (m.getCategory().equalsIgnoreCase(c.getCategoryName())) {
                                    rvSubCategoryNewList.add(m);
                                    Toast.makeText(act, "This main category stuff is working", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(act, "Category not found. Please choose another category.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                    }
                    rvSub2Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategoryNewList));
                    rvSub2Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategoryNewList));

                    return true;
                }
            });

            //The mini-search engine for the home screen
            SearchView search = view.findViewById(R.id.search_view);
            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if(regexChecker(search.toString())) {
                       Toast.makeText(act, "Zǎoshang hǎo zhōngguó", Toast.LENGTH_SHORT).show();
                       Toast.makeText(act, "xiànzài wǒ yǒu BING CHILLING", Toast.LENGTH_SHORT).show();
                       Toast.makeText(act, "wǒ hěn xǐhuān BING CHILLING", Toast.LENGTH_SHORT).show();

//                       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                           List<RVSubCategoryModel> rvSubCategoryNewList = new ArrayList<>();
                           for(RVSubCategoryModel m : rvSubCategory1List){
                               if(search.toString().trim().contains(m.getRecipeName()))
//                               if(miniSearchEngine(search.toString(), m.getRecipeName()))
                                   rvSubCategoryNewList.add(m);
                               else{
                                   Toast.makeText(act, "Recipe not found. Please search for another recipe.", Toast.LENGTH_SHORT).show();
                               }
                           }
                           rvSub1Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategoryNewList));
                           rvSub2Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategoryNewList));
                       //}
                   }
                }
            });

            return view;
    }
    
    private boolean miniSearchEngine(String searchitem, String recipename) {
        String slines[] = searchitem.toLowerCase().split("\\s");
        for (String s : slines) {
            if (s.contains(recipename))
                return true;
        }
        return false;
    }

    private boolean regexChecker(String searchitem){
        Pattern research = Pattern.compile("^([a-zA-Z ]+)$", Pattern.CASE_INSENSITIVE);
        Matcher searchm = research.matcher(searchitem);
        if (!searchm.find()){
            return true;
        }else{
            Toast.makeText(act, "‘Sup guys, My name is Quandale Dingle. I am breaking out of prison on may 14, 2023. I am currently imprisoned in southern Saudi Arabia for various felonies", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}