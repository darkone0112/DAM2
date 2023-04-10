package com.example.mostrarnombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextView tmensaje;
    Button bAceptar;
    EditText imputText;
    TextView tNombre;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imputText = findViewById(R.id.imputText);
        tmensaje = findViewById(R.id.tmensaje);

        tNombre = findViewById(R.id.tnombre);
        bAceptar = findViewById(R.id.bAceptar);

        bAceptar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tNombre.setText("El nombre es: " + imputText.getText());
                    }
                }
        );





    }
}