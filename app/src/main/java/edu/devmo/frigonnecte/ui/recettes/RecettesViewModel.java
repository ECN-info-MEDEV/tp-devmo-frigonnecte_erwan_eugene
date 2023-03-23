package edu.devmo.frigonnecte.ui.recettes;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;
import java.util.List;

public class RecettesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecettesViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("This is calendrier fragment");
    }


    public LiveData<String> getText() {
        return mText;
    }
}