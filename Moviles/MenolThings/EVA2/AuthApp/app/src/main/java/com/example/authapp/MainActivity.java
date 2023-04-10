package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import PreguntasServicio.QuestionAPI;
import PreguntasServicio.QuestionResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView Sprueba;
    Call<QuestionResponse> llamada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sprueba = findViewById(R.id.Sprueba);

        /*
        llamada = QuestionAPI.getInstance().filtrar(1);
        llamada.enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                Sprueba.setText(response.body().getQuestion_text());
            }

            @Override
            public void onFailure(Call<QuestionResponse> call, Throwable t) {
                Sprueba.setText("mamaste");
            }
        });
        */

    }


}