package com.example.multicontador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button resetAll;
    Button resetOne,resetTwo,resetThre,resetFour;
    Button addOne,addTwo,addthre,addfour;
    TextView textView1,textView2,textView3,textView4,textView5;
    public int[] aux = new int [5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetAll = findViewById(R.id.resetAll);
        resetOne = findViewById(R.id.resetOne);
        resetTwo = findViewById(R.id.resetTwo);
        resetThre = findViewById(R.id.resetThre);
        resetFour = findViewById(R.id.resetFour);
        addOne = findViewById(R.id.addOne);
        addTwo = findViewById(R.id.addTwo);
        addthre = findViewById(R.id.addThre);
        addfour = findViewById(R.id.addFour);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        resetAll.setOnClickListener(this);
        addOne.setOnClickListener(this);
        addTwo.setOnClickListener(this);
        addthre.setOnClickListener(this);
        addfour.setOnClickListener(this);
        resetOne.setOnClickListener(this);
        resetTwo.setOnClickListener(this);
        resetThre.setOnClickListener(this);
        resetFour.setOnClickListener(this);
}
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.addOne:
                aux[0] +=1;
                aux[4] += 1;
            break;
            case  R.id.addTwo:
                aux[1] +=1;
                aux[4] += 1;
                break;
            case  R.id.addThre:
                aux[2] +=1;
                aux[4] += 1;
                break;
            case  R.id.addFour:
                aux[3] +=1;
                aux[4] += 1;
                break;
            case R.id.resetOne:
                aux[4] -= aux[0];
                aux[0] = 0;
                break;
            case R.id.resetTwo:
                aux[4] -= aux[1];
                aux[1] = 0;
                break;
            case R.id.resetThre:
                aux[4] -= aux[2];
                aux[2] = 0;
                break;
            case R.id.resetFour:
                aux[4] -= aux[3];
                aux[3] = 0;
                break;
            case R.id.resetAll:
                for (int i = 0; i < aux.length; i++) {
                    aux[i] = 0;
                }
                break;
        }
        assign(aux);
    }
    public void assign(int[] x){
        textView1.setText(String.valueOf(aux[0]));
        textView2.setText(String.valueOf(aux[1]));
        textView3.setText(String.valueOf(aux[2]));
        textView4.setText(String.valueOf(aux[3]));
        textView5.setText(String.valueOf(aux[4]));
    }
}