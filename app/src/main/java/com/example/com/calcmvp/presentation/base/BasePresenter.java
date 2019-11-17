package com.example.com.calcmvp.presentation.base;

public interface BasePresenter<V> {
    void startView(V view);

    void detachView();
}
