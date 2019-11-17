package com.example.com.calcmvp.data;

import android.annotation.SuppressLint;


public class Calc implements CalcContract {
    private CalcContract.CallBack callBack;

    public Calc() {
    }

    @Override
    public void init(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void listener(String val) {
        calculate(val);
    }

    @SuppressLint("DefaultLocale")
    private void calculate(String input) {
        double res;
        String[] numb = input.split("[^0123456789.]");
        double[] numbers = new double[numb.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.valueOf(numb[i]);
        }
        String[] operator = input.split("[0123456789.\\s]+");
        res = numbers[0];

        for (int i = 1; i < operator.length; i++) {
            if (operator[i].compareTo("+") == 0) {
                res = res + numbers[i];
            }
            if (operator[i].compareTo("-") == 0) {
                res = res - numbers[i];
            }
            if (operator[i].compareTo("/") == 0) {
                if (res == 0.0 | numbers[i] == 0.0) {
                    res = 0;
                } else {
                    res = res / numbers[i];
                }
            }
            if (operator[i].compareTo("*") == 0) {
                res = res * numbers[i];
            }
        }

        callBack.result(String.format("%8.2f", res));
    }
}

