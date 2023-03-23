package edu.devmo.frigonnecte.ui.recettes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecettesViewModel extends ViewModel {
<<<<<<< Updated upstream

    private final MutableLiveData<String> mText;

    public RecettesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is recettes fragment");
    }

=======
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


>>>>>>> Stashed changes
    public LiveData<String> getText() {
        return mText;
    }
}