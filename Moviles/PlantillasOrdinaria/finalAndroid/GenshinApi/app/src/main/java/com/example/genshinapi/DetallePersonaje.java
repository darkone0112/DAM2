package com.example.genshinapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import GenshinAPI.GenshinViewModel;
import GenshinAPI.InfoPersonaje;

public class DetallePersonaje extends AppCompatActivity {

    TextView ENombre, EVision, ETittle, ENation, EDescription;
    ImageView EImage;
    ProgressBar progess;
    private String nombre;

    private GenshinViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_personaje);

        ENombre = findViewById(R.id.Ename);
        EVision = findViewById(R.id.EVision);
        ETittle = findViewById(R.id.ETittle);
        ENation = findViewById(R.id.ENation);
        EDescription = findViewById(R.id.EDescription);
        EImage = findViewById(R.id.EImage);
        progess = findViewById(R.id.progressBar);

        nombre = getIntent().getStringExtra("nombre");

        vm = new ViewModelProvider(this).get(GenshinViewModel.class);
        vm.init();

        vm.getDataPersonaje().observe(this, (data) -> {

            ENombre.setText(data.getName());
            EVision.setText(data.getVision());
            ETittle.setText(data.getTitle());
            ENation.setText(data.getNation());
            EDescription.setText(data.getDescription());


            insertarImagenes(nombre);

        });
        vm.mostrarDetalle(nombre);
    }

    public void insertarImagenes(String nombre) {

        String imgURL = "https://api.genshin.dev/characters/"+nombre+"/gacha-splash";

        progess.setVisibility(View.INVISIBLE);
        Glide.with(EImage)
                .load(imgURL)
                .into(EImage);

        ENombre.setVisibility(View.VISIBLE);
        EVision.setVisibility(View.VISIBLE);
        ETittle.setVisibility(View.VISIBLE);
        ENation.setVisibility(View.VISIBLE);
        EDescription.setVisibility(View.VISIBLE);

    }


}