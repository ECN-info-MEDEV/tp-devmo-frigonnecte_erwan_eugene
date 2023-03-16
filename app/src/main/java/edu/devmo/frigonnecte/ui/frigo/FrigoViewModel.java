package edu.devmo.frigonnecte.ui.frigo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FrigoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FrigoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is frigo fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}