package com.example.plantilla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import APIRepositoryViewModel.ObjetoViewModel;

public class MostrarDetalle extends AppCompatActivity {

    TextView ENombre,EDescripcion;
    ImageView EImage;
    private ObjetoViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalle);

        ENombre = findViewById(R.id.Ename);
        EDescripcion = findViewById(R.id.EDescription);
        EImage = findViewById(R.id.EImage);

        vm = new ViewModelProvider(this).get(ObjetoViewModel.class);
        vm.init();

        vm.getDataDetalle().observe(this, (data) -> {

            ENombre.setText(data.getInventado());
            EDescripcion.setText(data.getInventado());
            String imgURL = data.getUrlimg();

            Glide.with(EImage)
                    .load(imgURL)
                    .into(EImage);

        });


    }



}