package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView display;
    public Button btn7,btn8,btn9,btn4,btn5,btn6,btn1,btn2,btn3,btn0,btnmult,btndiv,btnmin,btnplus,btnequ,btnclear;
    public
    int n1 = 0;
    int n2 = 0;
    int t = 0;
    public int operacion = 0;
    public int calcular = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn1 = findViewById(R.id.btn1);
        btnmult = findViewById(R.id.btnmult);
        btndiv = findViewById(R.id.btndiv);
        btnplus = findViewById(R.id.btnplus);
        btnmin = findViewById(R.id.btnmin);
        btnequ = findViewById(R.id.btnequ);
        btnclear = findViewById(R.id.btnclear);
        display = findViewById(R.id.display);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnmult.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnequ.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnmin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn0:
                display.setText(display.getText() + "0");
                break;
            case R.id.btn1:
                display.setText(display.getText() + "1");
                break;
            case R.id.btn2:
                display.setText(display.getText() + "2");
                break;
            case R.id.btn3:
                display.setText(display.getText() + "3");
                break;
            case R.id.btn4:
                display.setText(display.getText() + "4");
                break;
            case R.id.btn5:
                display.setText(display.getText() + "5");
                break;
            case R.id.btn6:
                display.setText(display.getText() + "6");
                break;
            case R.id.btn7:
                display.setText(display.getText() + "7");
                break;
            case R.id.btn8:
                display.setText(display.getText() + "8");
                break;
            case R.id.btn9:
                display.setText(display.getText() + "9");
                break;
            case R.id.btnplus:
                try {
                    if (t == 0){
                        t+= Integer.valueOf((String)display.getText().toString());
                    }
                    operacion = 1;
                    display.setText("");
                    /*Block operations*/
                    blockOperations();
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println(n1);
                    System.out.println(n2);
                }
                break;
            case R.id.btnmin:
                try {
                    if (t == 0){
                        t+= Integer.valueOf((String)display.getText().toString());
                    }
                    operacion = 2;
                    display.setText("");
                    /*Block operations*/
                    blockOperations();
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println(n1);
                    System.out.println(n2);
                }
                break;
            case R.id.btnmult:
                try {
                    if (t == 0){
                        t+= Integer.valueOf((String)display.getText().toString());
                    }
                    operacion = 3;
                    display.setText("");
                    /*Block operations*/
                    blockOperations();
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println(n1);
                    System.out.println(n2);
                }
                break;
            case R.id.btndiv:
                try {
                    if (t == 0){
                        t+= Integer.valueOf((String)display.getText().toString());
                    }
                    operacion = 4;
                    display.setText("");
                    /*Block operations*/
                    blockOperations();
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println(n1);
                    System.out.println(n2);
                }
                break;
            case R.id.btnequ:
                try {
                    switch (operacion){
                        case 1:
                            t+= Integer.valueOf((String)display.getText().toString());
                        break;
                        case 2:
                            t-= Integer.valueOf((String)display.getText().toString());
                        break;
                        case 3:
                            t*= Integer.valueOf((String)display.getText().toString());
                        break;
                        case 4:
                            t/= Integer.valueOf((String)display.getText().toString());
                        break;

                    }
                    display.setText(String.valueOf(t));
                    /*Activate operations*/
                    enableOperations();
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println(n1);
                    System.out.println(n2);
                    System.out.println(n2+n1);

                }

                break;
            case R.id.btnclear:
                display.setText("");
                t = 0;
        }
    }
    public void blockOperations(){
        btnplus.setEnabled(false);
        btnmin.setEnabled(false);
        btndiv.setEnabled(false);
        btnmult.setEnabled(false);
    }
    public void enableOperations(){
        btnplus.setEnabled(true);
        btnmin.setEnabled(true);
        btndiv.setEnabled(true);
        btnmult.setEnabled(true);
    }
}