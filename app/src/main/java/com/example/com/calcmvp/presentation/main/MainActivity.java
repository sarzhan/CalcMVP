package com.example.com.calcmvp.presentation.main;


import com.example.com.calcmvp.R;
import com.example.com.calcmvp.databinding.ActivityMainBinding;

import androidx.fragment.app.Fragment;
import com.example.com.calcmvp.Router;
import com.example.com.calcmvp.presentation.base.BaseActivity;



import com.example.com.calcmvp.presentation.base.BasePresenter;

public class MainActivity extends BaseActivity <ActivityMainBinding>  implements MainContract.View {
    private MainContract.Presenter presenter;

    @Override
    protected void initView() {
        Router.getInstanse().onStart(this);
        presenter = new MainPresenter();
        getBinding().setEvent(presenter);
    }

    @Override
    public void showDisplay(String val) {
        getBinding().inputText.setText(val);

    }

    @Override
    public void showResult(String val) {
        getBinding().resultText.setText(val);
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }


    @Override
    protected void onStartView() {
        presenter.startView(this);
    }

    @Override
    protected void onDestroyView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void transactionFragmentNoBackStack(Fragment fragment, int container) {
        super.transactionFragmentNoBackStack(fragment, container);
    }

    @Override
    public void transactionFragmentWithBackStack(Fragment fragment, int container) {
        super.transactionFragmentWithBackStack(fragment, container);
    }

    @Override
    public void transactionActivity(Class<?> activity, boolean cycleFinish) {
        super.transactionActivity(activity, cycleFinish);
    }

    @Override
    public <T> void transactionActivity(Class<?> activity, boolean cycleFinish, T... object) {
        super.transactionActivity(activity, cycleFinish, object);
    }

    @Override
    public void message(String val) {

    }

    @Override
    public void isProgress(boolean val) {

    }

    @Override
    public void backStack() {
        super.onBackPressed();
    }

    @Override
    public void isBack(boolean val) {

    }

    @Override
    public void header(String val) {

    }
}


