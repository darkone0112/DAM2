can package com.example.atracciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import APIServ.AtraccionesViewModel;
import Data.AtraccionesService;

public class MainActivity extends AppCompatActivity implements AtraccionesAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private AtraccionesAdapter adapter;
    private AtraccionesViewModel vm;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerAtracciones);

        //Adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AtraccionesAdapter();
        recyclerView.setAdapter(adapter);

        //Método Onclick
        adapter.setmListener(this);

        //ViewModel
        vm = new ViewModelProvider(this).get(AtraccionesViewModel.class);
        vm.init();

        //Observador
        vm.getData().observe(this, (data) -> {

            adapter.setResults(data);

        });

        vm.listarAtracciones();



    }


    @Override
    public void onItemClick(int position) {
        //Obtengo el dato necesario
        String urlDetalle = adapter.getResults().get(position).getUrl();

        envio(urlDetalle);
    }

    public void envio(String urlDetalle){
        Intent intent = new Intent(this, MostrarComentario.class);
        intent.putExtra("urlDetalle",urlDetalle);
        startActivity(intent);

    }

}