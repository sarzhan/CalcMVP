package com.example.com.calcmvp.presentation.splash;

import java.util.concurrent.TimeUnit;

import com.example.com.calcmvp.Router;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter implements SplashContract.Presenter {
    private SplashContract.View view;
    private Single<Long> subcribe;


    @Override
    public void startView(SplashContract.View view) {
        this.view = view;
        subcribe.subscribe(new DisposableSingleObserver<Long>() {
            @Override
            public void onSuccess(Long aLong) {
                Router.getInstanse().transactionMainActivity();
            }

            @Override
            public void onError(Throwable e) {
                if (view != null) view.message("Что-то пошло не так :)");
            }
        });
    }

    @Override
    public void detachView() {
        if (view != null) view = null;
    }

    @Override
    public void pause() {
        subcribe = Single.timer(10, TimeUnit.SECONDS, Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
