package com.example.calculate_it;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isPressed = false;
    private double firstNum = 0;
    private int secondNumIndex = 0;
    private char curOp = '\0';
    private String screenElement = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
        final TextView calculatorScreen = findViewById(R.id.calculatorScreen);
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button division = findViewById(R.id.division);
        final Button multiply = findViewById(R.id.multiply);
        final Button decimal = findViewById(R.id.decimal);
        final Button equal = findViewById(R.id.equal);
        final Button sub = findViewById(R.id.sub);
        final Button add = findViewById(R.id.add);
        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch (id) {
                    case R.id.n0:
                        calculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        break;
                    case R.id.division:
                         screenElement = calculatorScreen.getText().toString();
                        secondNumIndex = screenElement.length() + 1;
                        firstNum = Double.parseDouble(screenElement);
                        calculatorScreen.append("/");
                        isPressed = true;
                        curOp = '/';
                        break;
                    case R.id.multiply:
                         screenElement = calculatorScreen.getText().toString();
                        secondNumIndex = screenElement.length() + 1;
                        firstNum = Double.parseDouble(screenElement);
                        calculatorScreen.append("*");
                        isPressed = true;
                        curOp = '*';
                        break;
                    case R.id.add:
                         screenElement = calculatorScreen.getText().toString();
                        secondNumIndex = screenElement.length() + 1;
                        firstNum = Double.parseDouble(screenElement);
                        calculatorScreen.append("+");
                        isPressed = true;
                        curOp = '+';
                        break;
                    case R.id.sub:
                         screenElement = calculatorScreen.getText().toString();
                        secondNumIndex = screenElement.length() + 1;
                        firstNum = Double.parseDouble(screenElement);
                        calculatorScreen.append("-");
                        isPressed = true;
                        curOp = '-';
                        break;
                    case R.id.decimal:
                        calculatorScreen.append(".");
                        break;
                    case R.id.equal:
                        double answer = 0;
                        if (isPressed) {
                            String screenContents = calculatorScreen.getText().toString();
                            String secNumString = screenContents.substring(secondNumIndex, screenContents.length());
                            double secNum = Double.parseDouble(secNumString);

                            if (curOp == '/') {
                                answer = firstNum / secNum;
                                calculatorScreen.setText(String.valueOf(answer));
                            }
                            if (curOp == '*') {
                                answer = firstNum * secNum;
                                calculatorScreen.setText(String.valueOf(answer));
                            }
                            if (curOp == '+') {
                                answer = firstNum + secNum;
                                calculatorScreen.setText(String.valueOf(answer));
                            }
                            if (curOp == '-') {
                                answer = firstNum - secNum;
                                calculatorScreen.setText(String.valueOf(answer));
                            }
                        }

                        break;
                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        add.setOnClickListener(calculatorListener);
        sub.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        multiply.setOnClickListener(calculatorListener);
        decimal.setOnClickListener(calculatorListener);
        equal.setOnClickListener(calculatorListener);

        final Button del = findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display = calculatorScreen.getText().toString();
                int len = display.length();
                display = display.substring(0, len - 1);
                calculatorScreen.setText(display);
            }
        });
        final Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorScreen.setText("");
            }
        });


    }
}
