package yuri.lechshnko.com.mye.presentation.base;

public interface BasePresenter<V> {
    void startView(V view);

    void detachView();
}
