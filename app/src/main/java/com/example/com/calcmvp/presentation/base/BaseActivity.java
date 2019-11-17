package com.example.com.calcmvp.presentation.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class BaseActivity<Binding extends ViewDataBinding> extends AppCompatActivity {
    private Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onStartView();
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected Binding getBinding() {
        return binding;
    }

    protected abstract void initView();

    protected abstract void onStartView();

    protected abstract void onDestroyView();

    protected abstract BasePresenter getPresenter();

    protected void transactionFragmentNoBackStack(Fragment fragment, int container) {
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment, fragment.getClass().getSimpleName())
                .commit();
    }


    protected void transactionFragmentWithBackStack(Fragment fragment, int container) {
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    protected void transactionActivity(Class<?> activity, boolean cycleFinish) {
        if (activity != null) {
            Intent intent = new Intent(this, activity);
            startActivity(intent);
            if (cycleFinish) {
                this.finish();
            }
        }
    }

    protected <T> void transactionActivity(Class<?> activity, boolean cycleFinish, T... object) {
        if (activity != null) {
            Intent intent = new Intent(this, activity);
            if (object != null) {

            }
            startActivity(intent);
            if (cycleFinish) {
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager manager = this.getSupportFragmentManager();
        if (manager.getBackStackEntryCount() == 0) {
            super.finish();
        }
    }

    @Override
    public void onDestroy() {
        onDestroyView();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
        super.onDestroy();
    }
}
