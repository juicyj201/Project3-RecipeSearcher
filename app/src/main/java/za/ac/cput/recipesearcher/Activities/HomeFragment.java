package za.ac.cput.recipesearcher.Activities;

import static za.ac.cput.recipesearcher.R.id.txt_category_name;

import android.annotation.SuppressLint;
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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
            View otherview = inflater.inflate(R.layout.item_rv_main_category, container, false);

            act = this.getActivity();

            //Main Recipe Categories
            rvMainCategory = view.findViewById(R.id.rv_main_category);
            rvMainCategoryList = new ArrayList<>();

            //getting the categories from the real time database
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("category");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot s : snapshot.getChildren()) {
                        RVMainCategoryModel m = s.getValue(RVMainCategoryModel.class);
                        m.setCategoryIcon(R.drawable.fire);
                        rvMainCategoryList.add(m);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e(TAG, error.getMessage());
                }
            });

            rvMainCategory.setLayoutManager(new LinearLayoutManager(rvMainCategory.getContext(), LinearLayoutManager.HORIZONTAL, true));
            rvMainCategory.setAdapter(new RVMainCategoryAdapter(getContext(), rvMainCategoryList));
            rvMainCategory.setHasFixedSize(true);
            rvMainCategory.setNestedScrollingEnabled(true);
            rvMainCategory.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true));

            //Sub Recipe Category 1
            rvSub1Category = view.findViewById(R.id.rv_sub_category1);
            rvSubCategory1List = new ArrayList<>();

            //Sub Recipe Category 2
            rvSub2Category = view.findViewById(R.id.rv_sub_category2);
            rvSubCategory2List = new ArrayList<>();

            List<RVSubCategoryModel> list = new ArrayList<>();

            //Getting all recipes from the realtime database
            DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference().child("recipe");
            ref2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot s : snapshot.getChildren()) {
                        RVSubCategoryModel r = s.getValue(RVSubCategoryModel.class);
                        r.setRecipeImage(R.drawable.pexels_pixabay_315755);
                        rvSubCategory1List.add(r);
                        rvSubCategory2List.add(r);
                        list.add(r);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e(TAG, error.getMessage());
                }
            });

            rvSub1Category.setLayoutManager(new LinearLayoutManager(rvSub1Category.getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvSub1Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategory1List));
            rvSub1Category.setHasFixedSize(true);
            rvSub1Category.setNestedScrollingEnabled(true);
            rvSub1Category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

            rvSub2Category.setLayoutManager(new LinearLayoutManager(rvSub2Category.getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvSub2Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategory2List));
            rvSub2Category.setHasFixedSize(true);
            rvSub2Category.setNestedScrollingEnabled(true);
            rvSub2Category.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

            //sorting through the categories
            rvMainCategory.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    return false;
                }

                @Override
                public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    List<TextView> views = null;
                    for(int i = 0; i < rv.getLayoutManager().getItemCount(); i++) {
                        views.add((TextView) rv.getLayoutManager().getChildAt(i));
                    }

                    List<RVSubCategoryModel> rvSubCategoryNewList = new ArrayList<>();
                    for (RVSubCategoryModel m : list) {
                        for(TextView texts : views) {
                            if (m.getCategory().equals(texts.getText().toString())) {
                                rvSubCategoryNewList.add(m);
                                rvSub1Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategoryNewList));
//                                rvSub2Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategoryNewList));
                                rvMainCategory.setAdapter(null);
                                rvSub2Category.setAdapter(null);
                                TextView breakfast = (TextView) view.findViewById(R.id.txtCategory1);
                                breakfast.setText(null);
                                TextView Lunch = (TextView) view.findViewById(R.id.txtCategory2);
                                Lunch.setText(null);
                            } else {
                                Toast.makeText(act, "Category not found. Please choose another category.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });

            SearchView search = view.findViewById(R.id.search_view);
            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        if(regexChecker(search.getQuery().toString())) {
                            String searchitem = search.getQuery().toString();

                            List<RVSubCategoryModel> rvSubCategoryNewList = new ArrayList<>();
                            for (RVSubCategoryModel m : rvSubCategory1List) {
                                String name = m.getRecipeName();

                                if(searchitem.contains(name) || name.contains(searchitem)){
                                    rvSubCategoryNewList.add(m);
                                    rvSub1Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategoryNewList));
                                    rvSub2Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategoryNewList));
                                    Toast.makeText(act, "Recipe found.", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                        }
                    }
                }
            });

            rvSub1Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategory1List));
            rvSub2Category.setAdapter(new RVSubCategoryAdapter(getContext(), rvSubCategory2List));

            return view;
    }

    private boolean regexChecker(String searchitem){
        Pattern research = Pattern.compile("^([a-zA-Z ]+)$", Pattern.CASE_INSENSITIVE);
        Matcher searchm = research.matcher(searchitem);
        if (searchm.find()){
            return true;
        }else{
            Toast.makeText(act, "Search item contains non-letter characters. Please try again.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}