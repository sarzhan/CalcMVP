package yuri.lechshnko.com.mye.presentation;


import yuri.lechshnko.com.mye.data.Calc;
import yuri.lechshnko.com.mye.data.CalcContract;

public class MainPresenter implements MainContract.Presenter, CalcContract.CallBack {
    private MainContract.View view;
    private StringBuilder buffer = new StringBuilder();
    private boolean equalClick = false;
    private CalcContract calc;

    MainPresenter() {
        calc = new Calc();
        calc.init(this);
    }

    @Override
    public void startView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) view = null;
    }

    @Override
    public void eventOperation(String val) {
        switch (val) {
            case "0":
                if (!equalClick) {
                    append("0");
                }

                break;
            case "1":
                if (!equalClick) {
                    append("1");
                }
                break;
            case "2":
                if (!equalClick) {
                    append("2");
                }
                break;
            case "3":
                if (!equalClick) {
                    append("3");
                }
                break;
            case "4":
                if (!equalClick) {
                    append("4");
                }
                break;
            case "5":
                if (!equalClick) {
                    append("5");
                }
                break;
            case "6":
                if (!equalClick) {
                    append("6");
                }
                break;
            case "7":
                if (!equalClick) {
                    append("7");
                }
                break;
            case "8":
                if (!equalClick) {
                    append("8");
                }
                break;
            case "9":
                if (!equalClick) {
                    append("9");
                }
                break;
            case "C":
                delete();
                break;
            case "+":
                if (!isEmpty())
                    if (endsWithOperator())
                        replace("+");
                    else
                        append("+");
                equalClick = false;
                break;
            case "/":
                if (!isEmpty())
                    if (endsWithOperator())
                        replace("/");
                    else
                        append("/");
                equalClick = false;
                break;
            case "-":
                if (!isEmpty())
                    if (endsWithOperator())
                        replace("-");
                    else
                        append("-");
                equalClick = false;
                break;
            case "X":
                if (!isEmpty())
                    if (endsWithOperator())
                        replace("*");
                    else
                        append("*");
                equalClick = false;
                break;
            case "CE":
                clear();
                equalClick = false;
                break;
            case ".":
                if (!equalClick) {
                    append(".");
                }
                break;
            case "%":
                if (!equalClick) {
                    append("%");
                }
                break;
            case "=":
                calc.listener(getInput());
                equalClick = true;
                break;
            default:
                break;
        }

    }

    private boolean endsWithOperator() {
        return getInput().endsWith("+") || getInput().endsWith("-") || getInput().endsWith("/") || getInput().endsWith("*");
    }

    private void replace(String str) {
        buffer.replace(getInput().length() - 1, getInput().length(), str);
    }

    private void append(String str) {
        buffer.append(str);
        view.showDisplay(buffer.toString());
    }

    private void delete() {
        if (!isEmpty()) {
            buffer.delete(getInput().length() - 1, getInput().length());
            view.showDisplay(buffer.toString());
        } else clear();
    }

    private String getInput() {
        return buffer.toString();
    }

    private boolean isEmpty() {
        return getInput().isEmpty();
    }


    @Override
    public void result(String valRes) {
        view.showResult(valRes);
        buffer.setLength(0);
        buffer.append(valRes);
        view.showDisplay(buffer.toString());
    }


    public void clear() {
        buffer.setLength(0);
        view.showDisplay("");
        view.showResult("");
    }

}
