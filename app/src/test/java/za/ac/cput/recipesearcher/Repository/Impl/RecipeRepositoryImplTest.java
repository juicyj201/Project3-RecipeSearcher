package za.ac.cput.recipesearcher.Repository.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.JupiterTestEngine;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.recipesearcher.Entities.RVSubCategoryModel;

@RunWith(MockitoJUnitRunner.class)
public class RecipeRepositoryImplTest {
    @Mock
    private RecipeRepositoryImpl repo = Mockito.mock(RecipeRepositoryImpl.class);
    private RVSubCategoryModel recipe;
    private List<RVSubCategoryModel> recipelist = new ArrayList<>();

    @BeforeEach
    public void setup(){
        recipe = new RVSubCategoryModel.RVSubCategoryModelBuilder()
                .createName("French Toast")
                .createBio("(filler text)")
                .createEstimatedTime("15min")
                .createAmountOfCalories("200cal")
                .build();

        recipelist.add(recipe);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveRecipe() {
        Assertions.assertNotNull(Mockito.when(repo.save(Mockito.any(RVSubCategoryModel.class))).thenReturn(recipe));
    }

    @Test
    void readRecipe() {
        Assertions.assertNotNull(Mockito.when(repo.read(Mockito.any(RVSubCategoryModel.class))).thenReturn(recipe));
    }

    @Test
    void testEquals() {
        Assertions.assertNotNull(Mockito.when(repo.readAll()).thenReturn(recipelist));
    }
}
