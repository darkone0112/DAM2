package com.example.atracciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import APIServ.AtraccionesViewModel;
import Data.ComentariosInfo;
import Data.ComentariosResponse;

public class MostrarComentario extends AppCompatActivity {

    TextView SNombre, SDescripcion, SOcupantes;
    private RecyclerView lista;
    AtraccionesViewModel vm;
    ComentariosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_comentario);

        lista = findViewById(R.id.SRecycler);
        SNombre = findViewById(R.id.SNom);
        SDescripcion = findViewById(R.id.SDescripccion1);
        SOcupantes = findViewById(R.id.SOcupantess);

        String urlApi = getIntent().getStringExtra("urlDetalle");

        lista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ComentariosAdapter();
        lista.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(AtraccionesViewModel.class);
        vm.init();

        vm.getDataComentarios().observe(this,(data) -> {

            SNombre.setText(data.getNombreSitio());
            SDescripcion.setText(data.getComentarioSitio());
            SOcupantes.setText(String.valueOf(data.getComentariosOcupantes()));
            adapter.setResults(data.getComenariosResponse());

        });

        vm.mostrarComentarios(urlApi);

    }


}