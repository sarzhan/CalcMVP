package com.example.com.calcmvp.presentation.main;


import com.example.com.calcmvp.presentation.base.BaseActivityContract;
import com.example.com.calcmvp.presentation.base.BasePresenter;

public interface MainContract {
    interface View extends BaseActivityContract {
        void showDisplay(String val);

        void showResult(String val);
    }

    interface Presenter extends BasePresenter<View> {
        void eventOperation(String val);
        void init();
    }
}
