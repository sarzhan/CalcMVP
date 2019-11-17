package com.example.com.calcmvp.presentation.base;

import androidx.fragment.app.Fragment;

public interface BaseActivityContract {
    void transactionFragmentNoBackStack(Fragment fragment, int container);

    void transactionFragmentWithBackStack(Fragment fragment, int container);

    void transactionActivity(Class<?> activity,boolean cycleFinish);

    <T>void transactionActivity(Class<?> activity,boolean cycleFinish,T... object);

    void message(String val);

    void isProgress(boolean val);

    void backStack();

    void isBack(boolean val);

    void header(String val);

}
