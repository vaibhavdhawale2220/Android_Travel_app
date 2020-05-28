package com.example.splashscreen.ui.utility;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UtilityViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UtilityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Utility fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}