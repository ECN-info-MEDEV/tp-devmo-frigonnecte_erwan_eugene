package edu.devmo.frigonnecte.ui.recettes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecettesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecettesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is recettes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}