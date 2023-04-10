package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import PreguntasServicio.QuestionAPI;
import PreguntasServicio.QuestionResponse;
import retrofit2.Call;

public class LoginAuth extends AppCompatActivity {

    EditText nombre,password;
    Button Elog;
    Call<QuestionResponse> llamada;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_auth);

        nombre = findViewById(R.id.ENombre);
        password = findViewById(R.id.EPassword);
        Elog = findViewById(R.id.ELog);

        Elog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vNombre = nombre.getText().toString();
                String vPassword = password.getText().toString();

                llamada = QuestionAPI



            }
        });


    }
}