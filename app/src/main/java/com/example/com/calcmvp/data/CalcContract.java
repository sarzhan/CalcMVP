package com.example.com.calcmvp.data;

public interface CalcContract {
    void init(CallBack callBack);

    void listener(String val);


    interface CallBack{
        void result(String valRes);


        void clear();
    }
}
