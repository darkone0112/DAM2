package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Data.Bares;

import java.util.List;

public class AnadirBar extends AppCompatActivity {

    private EditText nombre, descrip, cierre, apertura, estrellas;
    private Button add;
    BarViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_bar);

        nombre = findViewById(R.id.idAddNombre);
        descrip = findViewById(R.id.idAddDescrip);
        cierre = findViewById(R.id.idCierre);
        apertura = findViewById(R.id.idApertura);
        estrellas = findViewById(R.id.idAddEstrellas);
        add = findViewById(R.id.idAdd);

        vm = new ViewModelProvider(this).get(BarViewModel.class);
        vm.init();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nombre.getText().toString();
                String description = descrip.getText().toString();
                String opening = apertura.getText().toString();
                String closing = cierre.getText().toString();
                int stars = Integer.parseInt(estrellas.getText().toString());
                Bares bar = new Bares(name, description, opening, closing, stars);
                vm.addBar(bar);

                Intent intent = new Intent(AnadirBar.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}