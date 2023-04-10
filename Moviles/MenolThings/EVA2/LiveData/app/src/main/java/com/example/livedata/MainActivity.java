package com.example.livedata;

import static java.lang.Short.MAX_VALUE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final double MAX_VALUE=30000;
    Button EButton;
    TextView Label;
    MutableLiveData<Integer> datosObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EButton = findViewById(R.id.EButton);
        Label = findViewById(R.id.SText);

        datosObserver = new MutableLiveData<Integer>(0);



        //LAMBDA GOD
        datosObserver.observe(this, datos -> {
            Label.setText(datos+"");
        });

        //Mas lambda, al presionar click
        EButton.setOnClickListener(view -> {
            datosObserver.postValue(new Integer((int)(Math.random()*MAX_VALUE)));
        });



    }



}