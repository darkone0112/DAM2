package com.example.contadorlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button addBtn,removeBtn,resetBtn;
    TextView number;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    addBtn = findViewById(R.id.addBtn);
    removeBtn = findViewById(R.id.removeBtn);
    resetBtn = findViewById(R.id.resetBtn);
    number = findViewById(R.id.number);

    addBtn.setOnClickListener(this);
    removeBtn.setOnClickListener(this);
    resetBtn.setOnClickListener(this);
    number.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.addBtn:
                contador++;
            break;
            case R.id.removeBtn:
                contador--;
            break;
            case R.id.resetBtn:
                contador = 0;
            break;
        }
        if (contador <= 0){
            contador = 0;
        }
        number.setText(String.valueOf(contador));
    }
}