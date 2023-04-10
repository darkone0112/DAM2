package com.example.peliculasactores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import PeliculasAPI.InfoPelicula;
import PeliculasAPI.PeliculaViewModel;

public class DetallePelicula extends AppCompatActivity {

    TextView Nombre, Description, Estrellas, Actores;
    ImageView EImage;
    ProgressBar progess;
    LiveData<InfoPelicula> data;
    private String nombre;

    private PeliculaViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);

        Nombre = findViewById(R.id.nombre);
        Description = findViewById(R.id.descripcion);
        Estrellas = findViewById(R.id.estrellas);
        Actores = findViewById(R.id.actores);
        //progess = findViewById(R.id.progressBar);

        nombre = getIntent().getStringExtra("url");

        vm = new ViewModelProvider(this).get(PeliculaViewModel.class);
        vm.init();
        data = vm.getDataPelicula();

        vm.getDataPelicula().observe(this, (data) -> {

            Nombre.setText(data.getNombre());
            Description.setText(data.getDescripcion());
            Estrellas.setText(data.getEstrellas());

        });
        vm.mostrarDetalle(nombre);
    }


}