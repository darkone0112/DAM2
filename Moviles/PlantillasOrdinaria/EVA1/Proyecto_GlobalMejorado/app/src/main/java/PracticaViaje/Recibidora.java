package PracticaViaje;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.proyecto_global.R;

import java.io.Serializable;

public class Recibidora extends AppCompatActivity implements Serializable {

    TextView probador;
    Viaje miViaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebidora);

            probador = findViewById(R.id.probador);
            miViaje = (Viaje) getIntent().getSerializableExtra("Viaje");

            probador.setText(miViaje.toString());

    }
}