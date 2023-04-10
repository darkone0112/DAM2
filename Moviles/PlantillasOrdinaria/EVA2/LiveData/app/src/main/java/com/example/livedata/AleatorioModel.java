package com.example.livedata;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AleatorioModel extends AppCompatActivity {

    Button EButon;
    TextView SText;
    LiveData<Integer> onlyObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EButon = findViewById(R.id.EButton);
        SText = findViewById(R.id.SText);

        AleatorioViewModel vm = new ViewModelProvider(this).get(AleatorioViewModel.class);
        onlyObserver = vm.getDatosAleatorios();
        onlyObserver.observe(this, dato -> {
            SText.setText(dato.toString());
        });

        EButon.setOnClickListener(v -> {
            SText.setText("Cargando . . .");
            vm.nuevoAleatorio();
        });

    }
}