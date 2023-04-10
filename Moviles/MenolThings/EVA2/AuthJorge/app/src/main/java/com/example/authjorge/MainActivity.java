package com.example.authjorge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mensajeError;
    EditText ENombre,EPassword;
    Button EButton;
    ProgressBar progressBar;
    LoginViewModel vml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ENombre = findViewById(R.id.ENombre);
        EPassword = findViewById(R.id.EPassword);
        EButton = findViewById(R.id.EButton);
        progressBar = findViewById(R.id.Progress);
        mensajeError = findViewById(R.id.mensajeError);

        //Recoger ViewModel de la actividad
        vml = new ViewModelProvider(this).get(LoginViewModel.class);

        //Observar cuando espera respuesta
        vml.getLoginResponse().observe(this,(respuesta) ->{
            EButton.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            if (respuesta.nonFieldErrors.size()>0) {
                mensajeError.setText("Ha introducido mal las credenciales");
            } else {

            }

        });

        //Evento click en el login
        EButton.setOnClickListener(view -> {
            EButton.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            vml.hacerLogin(String.valueOf(ENombre.getText()),String.valueOf(EPassword.getText()));

        });

    }



}