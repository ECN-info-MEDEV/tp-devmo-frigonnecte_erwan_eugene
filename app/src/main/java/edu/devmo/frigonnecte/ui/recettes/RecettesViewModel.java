package edu.devmo.frigonnecte.ui.recettes;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;
import java.util.List;

public class RecettesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

//    private final RecipeRepository mRepository;
//    private final LiveData<List<Recipe>> mAllRecipes;

    public RecettesViewModel () {
//        super((Closeable) application);
//        mRepository = new RecipeRepository(application);
//        mAllRecipes = mRepository.getAllRecipes();
        mText = new MutableLiveData<>();
        mText.setValue("This is calendrier fragment");
    }


    public LiveData<String> getText() {
        return mText;
    }
}