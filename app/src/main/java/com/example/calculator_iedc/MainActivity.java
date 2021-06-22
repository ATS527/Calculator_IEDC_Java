package com.example.calculator_iedc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn_ac,btn_division,btn_module,btn_equal,btn_plus,btn_minus,btn_multiplication,btn_dot;
    ImageView btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;

    TextView inputText,outputText;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_ac = findViewById(R.id.btn_ac);
        btn_plus = findViewById(R.id.btn_plus);
        btn_multiplication = findViewById(R.id.btn_multiplication);
        btn_dot = findViewById(R.id.btn_dot);
        btn_division = findViewById(R.id.btn_division);
        btn_minus = findViewById(R.id.btn_minus);
        btn_module = findViewById(R.id.btn_module);
        btn_equal = findViewById(R.id.btn_equal);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"9");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+".");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"-");
            }
        });

        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"%");
            }
        });

        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"x");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("");
                outputText.setText("");
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "÷");
            }
        });

//        btn_equal.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                return ;
//            }
//        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    data = inputText.getText().toString();

                    data = data.replaceAll("x","*");
                    data = data.replaceAll("%","%");
                    data = data.replaceAll("x","*");
                    data = data.replaceAll("÷","/");

                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);

                    String finalResult;

                    Scriptable scriptable = rhino.initStandardObjects();
                    if (data!="") {
                        finalResult = rhino.evaluateString(scriptable,data,"JavaScript",1,null).toString();
                    } else {
                        finalResult = "0";
                    }
                    outputText.setText(finalResult);
                }catch(Exception e) {
                    System.out.println("Catched the exception Hehe");
                }
            }
        });

    }
}