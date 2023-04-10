package com.example.atracciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.atracciones.Data.Atracciones;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView listado;
    AtraccionViewModel vm;
    LiveData<List<Atracciones>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = findViewById(R.id.idRecycler);

        ResultadoAdapter adapter = new ResultadoAdapter();
        listado.setLayoutManager(new LinearLayoutManager(this));
        listado.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(AtraccionViewModel.class);
        vm.init();
        data = vm.getAtraccionesLiveData();
        data.observe(this, data -> {
            adapter.setResults(data);
        });

        vm.mostrarTodo();
    }
}