package yuri.lechshnko.com.mye.presentation;


import yuri.lechshnko.com.mye.presentation.base.BasePresenter;

public interface MainContract {
    interface View {
        void showDisplay(String val);

        void showResult(String val);
    }

    interface Presenter extends BasePresenter<View> {
        void eventOperation(String val);
    }
}
