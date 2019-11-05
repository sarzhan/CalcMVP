package yuri.lechshnko.com.mye.presentation.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
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
    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager manager = this.getSupportFragmentManager();
        if (manager.getBackStackEntryCount() == 0) {
            super.finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        onStartView();
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected Binding getBinding(){
        return binding;
    }

    protected abstract void initView();


    @Override
    public void onDestroy() {
        onDestroyView();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
        super.onDestroy();
    }

    protected abstract void onStartView();

    protected abstract void onDestroyView();

    protected abstract BasePresenter getPresenter();
    protected void toast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
