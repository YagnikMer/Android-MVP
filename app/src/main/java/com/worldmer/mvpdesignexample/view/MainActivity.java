package com.worldmer.mvpdesignexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.worldmer.mvpdesignexample.Presenter.MainPresenter;
import com.worldmer.mvpdesignexample.R;
import com.worldmer.mvpdesignexample.model.MathUtil;

public class MainActivity extends AppCompatActivity implements MainView {

    EditText edt1, edt2;
    TextView tvAnswer;
    MathUtil mathUtil;
    int num1, num2;
    MainPresenter mathPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        mathPresenter = new MainPresenter(this);
        mathUtil = new MathUtil();
        mathPresenter.onCreate();
    }

    public void bindView() {
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        tvAnswer = (TextView) findViewById(R.id.tvanswer);
    }

    public void getAnswer(View view) {
        Button button = (Button) view;
        if (isValid(edt1) && isValid(edt2)) {
            num1 = Integer.parseInt(edt1.getText().toString());
            num2 = Integer.parseInt(edt2.getText().toString());
            mathPresenter.onClick(button.getTag().toString(), num1, num2);
        } else {
            tvAnswer.setText("Error");
        }
    }

    public boolean isValid(EditText view) {
        boolean status = false;
        try {
            if (null != view) {
                if (view.getText().toString().trim().length() > 0) {
                    status = true;
                }
            }
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    @Override
    public void setAnwser(String text) {
        if (null != tvAnswer) {
            tvAnswer.setText(text);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mathPresenter.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mathPresenter.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mathPresenter.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mathPresenter.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mathPresenter.onDestroy();
    }
}