package edu.devmo.frigonnecte.ui.recettes;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;
import java.util.List;

public class RecettesViewModel extends ViewModel {

    private RecipeRepository mRepository;

    private final LiveData<List<Recipe>> mAllRecipes;

    public RecettesViewModel (Application application) {
        super((Closeable) application);
        mRepository = new RecipeRepository(application);
        mAllRecipes = mRepository.getAllRecipes();
    }

    LiveData<List<Recipe>> getAllRecipes() { return mAllRecipes; }

    public void insert(Recipe recipe) { mRepository.insert(recipe); }
}