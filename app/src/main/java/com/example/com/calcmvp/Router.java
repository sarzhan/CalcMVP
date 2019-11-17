package com.example.com.calcmvp;

import com.example.com.calcmvp.presentation.main.MainActivity;
import com.example.com.calcmvp.presentation.base.BaseActivityContract;

public class Router implements RouterContract {

    private BaseActivityContract view;
    private static RouterContract instanse;

    private Router() {

    }

    public static synchronized RouterContract getInstanse() {
        if (instanse == null) {
            instanse = new Router();
        }
        return instanse;
    }

    @Override
    public void onStart(BaseActivityContract view) {
        this.view = view;
    }

    public void transactionCalcFragment() {
       // view.transactionFragmentNoBackStack(CalcFragment.newInstance(), R.id.content);
    }

    @Override
    public void transactionMainActivity() {
        view.transactionActivity(MainActivity.class, true);
    }

    @Override
    public void backStack() {
        view.backStack();
    }

    @Override
    public void isBack(boolean val) {
        view.isBack(val);
    }

    @Override
    public void header(String val) {
        view.header(val);
    }

    @Override
    public void message(String val) {
        view.message(val);
    }

    @Override
    public void isProgress(boolean val) {
        view.isProgress(val);
    }
}
