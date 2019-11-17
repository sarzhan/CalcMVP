package com.example.com.calcmvp.presentation.splash;

import com.example.com.calcmvp.presentation.base.BaseActivityContract;
import com.example.com.calcmvp.presentation.base.BasePresenter;

public interface SplashContract {
    interface View extends BaseActivityContract {

    }

    interface Presenter extends BasePresenter<View> {
        void pause();
    }
}
