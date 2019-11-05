package yuri.lechshnko.com.mye.presentation;

import yuri.lechshnko.com.mye.R;
import yuri.lechshnko.com.mye.databinding.ActivityMainBinding;
import yuri.lechshnko.com.mye.presentation.base.BaseActivity;
import yuri.lechshnko.com.mye.presentation.base.BasePresenter;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainContract.View {
    private MainContract.Presenter presenter;


    @Override
    public void showDisplay(String val) {
        getBinding().inputText.setText(val);

    }

    @Override
    public void showResult(String val) {
        getBinding().resultText.setText(val);
    }


    @Override
    public void toast(String val) {

    }



    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        presenter = new MainPresenter();
        getBinding().setEvent(presenter);
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
}


