package edu.devmo.frigonnecte.ui.calendrier;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalendrierViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CalendrierViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calendrier fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}