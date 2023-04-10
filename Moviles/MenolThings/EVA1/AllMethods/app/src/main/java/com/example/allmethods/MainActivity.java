package com.example.allmethods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TextWelcome;
    Button BotonLeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextWelcome = findViewById(R.id.TextWelcome);
        String Recuerda = (String) TextWelcome.getText();
        BotonLeer = findViewById(R.id.BotonLeer);



        BotonLeer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextWelcome.setText(Recuerda);
                    }
                }

        );

    }

    @Override
    protected void onStart () {
        super.onStart();
        TextWelcome.setText("A bueno adios Master");
    }








}