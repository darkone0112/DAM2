package com.example.apirickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import MutableLiveDataPersonajes.PersonajesViewModel;
import RickMortyAPI.APIMapear.PaginaRespuesta;
import RickMortyAPI.APIMapear.PersonajesRespuesta;

public class PaginaDetalle extends AppCompatActivity {

    ImageView SImage;

    TextView SName,SStatus,SSpecies,SGender,SLoUrl,SLoName,SDebut;

    PersonajesViewModel vm;
    LiveData<PersonajesRespuesta> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_detalle);

        SImage = findViewById(R.id.SImage);
        SName = findViewById(R.id.SName);
        SStatus = findViewById(R.id.SStatus);
        SSpecies = findViewById(R.id.SSpecies);
        SGender = findViewById(R.id.SGender);
        SLoName = findViewById(R.id.SLoName);
        SLoUrl = findViewById(R.id.SLoUrl);
        SDebut = findViewById(R.id.SCreado);


        String id = getIntent().getStringExtra("id");

        //Vainas del ViewModel
        vm = new ViewModelProvider(this).get(PersonajesViewModel.class);
        vm.init();
        data = vm.getPersonajeRespuestaLiveData();

        //Se realiza la nueva petición
        vm.buscarPersonaje(id);

        data.observe(this, (data)->{



            //Asignamos valores
            SName.setText(data.getName());
            SStatus.setText(data.getStatus());
            SSpecies.setText(data.getSpecies());
            SGender.setText(data.getGender());
            SLoName.setText(data.getOrigin().getNameOrigen());
            SLoUrl.setText(data.getOrigin().getUrlOrigen());
            SDebut.setText(data.getCreated());


            //Comprobamos si la imagen no es null
            if (data.getImagelink() != null) {

                String urlImg = data.getImagelink();

                Glide.with(this).load(urlImg).into(SImage);

            }


        });



    }



}