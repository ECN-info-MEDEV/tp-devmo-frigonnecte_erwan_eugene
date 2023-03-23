package edu.devmo.frigonnecte.ui.recettes;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;
import java.util.List;

public class RecettesViewModel extends ViewModel {
    private final RecipeRepository mRepository;
    private final LiveData<List<Recipe>> mAllRecipes;

    public RecettesViewModel (Application application) {
        super(application);
        mRepository = new RecipeRepository(application);
        mAllRecipes = mRepository.getAllRecipes();
    }
}