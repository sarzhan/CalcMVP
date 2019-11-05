package yuri.lechshnko.com.mye.data;

public interface CalcContract {
    void init(CallBack callBack);

    void listener(String val);


    interface CallBack{
        void result(String valRes);


        void clear();
    }
}
