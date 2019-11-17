package com.example.com.calcmvp;

import com.example.com.calcmvp.presentation.base.BaseActivityContract;

public interface RouterContract {

    void onStart(BaseActivityContract view);

    void transactionCalcFragment();

    void transactionMainActivity();

    void backStack();

    void isBack(boolean val);

    void header(String val);

    void message(String val);

    void isProgress(boolean val);

}
