package com.example.examenejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class mostrar extends AppCompatActivity {
    TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar);
        mensaje = findViewById(R.id.mensaje);
                Intent i = getIntent();
        mensaje.setText(i.getStringExtra(MainActivity.CLAVE_INFO));
    }
}