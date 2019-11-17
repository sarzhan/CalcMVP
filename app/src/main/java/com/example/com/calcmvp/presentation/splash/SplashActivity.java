package com.example.com.calcmvp.presentation.splash;

import androidx.fragment.app.Fragment;
import com.example.com.calcmvp.R;
import com.example.com.calcmvp.Router;
import com.example.com.calcmvp.databinding.ActivitySplashBinding;
import com.example.com.calcmvp.presentation.base.BaseActivity;
import com.example.com.calcmvp.presentation.base.BasePresenter;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> implements SplashContract.View{
    private SplashContract.Presenter presenter;
    protected int getLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        Router.getInstanse().onStart(this);
        presenter = new SplashPresenter();
        presenter.pause();
    }

    @Override
    protected void onStartView() {
        presenter.startView(this);
    }

    @Override
    protected void onDestroyView() {
        presenter.detachView();
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void transactionFragmentNoBackStack(Fragment fragment, int container) {

    }

    @Override
    public void transactionFragmentWithBackStack(Fragment fragment, int container) {

    }

    @Override
    public void transactionActivity(Class<?> activity, boolean cycleFinish) {
        super.transactionActivity(activity,cycleFinish);
    }

    @Override
    public <T> void transactionActivity(Class<?> activity, boolean cycleFinish, T... object) {
        super.transactionActivity(activity,cycleFinish,object);
    }
    @Override
    public void message(String val) {

    }

    @Override
    public void isProgress(boolean val) {

    }

    @Override
    public void backStack() {

    }

    @Override
    public void isBack(boolean val) {

    }

    @Override
    public void header(String val) {

    }
}
