package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Api.BarModel;
import com.example.myapplication.Data.Bares;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView listado;
    BarViewModel vm;
    LiveData<List<Bares>> data;
    EditText textEstrellas, idEliminar;
    private Button filtrar, add, eliminar, buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEstrellas = findViewById(R.id.idTextoEstrellas);
        filtrar = findViewById(R.id.idBotonFiltrar);
        buscar = findViewById(R.id.idBotonBuscar);
        listado = findViewById(R.id.idRecycled);
        add = findViewById(R.id.idAddNuevo);
        idEliminar = findViewById(R.id.idTextEliminar);
        eliminar = findViewById(R.id.idButtonEliminar);

        ResultadoAdapter adapter = new ResultadoAdapter();
        listado.setLayoutManager(new LinearLayoutManager(this));
        listado.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(BarViewModel.class);
        vm.init();
        data = vm.getBaresLiveData();
        data.observe(this, data -> {
            adapter.setResults(data);
        });

        vm.mostrarTodo();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnadirBar.class);
                startActivity(intent);
                finish();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id  = Integer.parseInt(String.valueOf(idEliminar.getText()));
                vm.deleteBar(id);
                //para actualizar el listado
                vm.mostrarTodo();
            }
        });

        filtrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String estrellas = String.valueOf(textEstrellas.getText());
                //validacion por si no introduce ningun numero, si introduce alguna letra se rompe :)
                if(estrellas.equalsIgnoreCase("")){
                    vm.mostrarTodo();
                }else vm.filtrarBares(Integer.parseInt(estrellas));
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String estrellas = String.valueOf(textEstrellas.getText());
                //validacion por si no introduce ningun numero, si introduce alguna letra se rompe :)
                if(estrellas.equalsIgnoreCase("")){
                    vm.mostrarTodo();
                }else vm.estrellasBares(Integer.parseInt(estrellas));
            }
        });
    }
}