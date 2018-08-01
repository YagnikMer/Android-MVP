package com.worldmer.mvpdesignexample.Presenter;

import com.worldmer.mvpdesignexample.model.MathUtil;
import com.worldmer.mvpdesignexample.view.MainView;

/**
 * Created by Yagnik on 01-Aug-18.
 */

public class MainPresenter implements Presenter {

    MainView viewHandler;
    MathUtil mathUtil;

    public MainPresenter(MainView view) {
        viewHandler = view;
    }

    @Override
    public void onCreate() {
        mathUtil = new MathUtil();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onClick(String opration, int num1, int num2) {
        switch (opration) {
            case "add":
                viewHandler.setAnwser(String.valueOf(mathUtil.add(num1, num2)));
                break;
            case "sub":
                viewHandler.setAnwser(String.valueOf(mathUtil.sub(num1, num2)));
                break;
            case "mul":
                viewHandler.setAnwser(String.valueOf(mathUtil.mul(num1, num2)));
                break;
            case "div":
                viewHandler.setAnwser(String.valueOf(mathUtil.div(num1, num2)));
                break;
            case "mod":
                viewHandler.setAnwser(String.valueOf(mathUtil.mod(num1, num2)));
                break;

        }
    }
}
