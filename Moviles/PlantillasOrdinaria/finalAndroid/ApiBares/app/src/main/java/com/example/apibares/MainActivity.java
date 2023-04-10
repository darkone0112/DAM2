package com.example.apibares;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ApiBares.BarMap.ReseñasResponse;
import ApiBares.BarRepository;
import ViewModelAdapter.BarAdapter;
import ViewModelAdapter.BarViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button BFiltrar;
    private EditText EditText;
    private BarAdapter adapter;
    private BarViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.ERecycler);
        BFiltrar = findViewById(R.id.EBuscar);
        EditText = findViewById(R.id.EEditText);

        //Creación y utilización adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BarAdapter();
        recyclerView.setAdapter(adapter);

        //ViewModel y sus vainas
        vm = new ViewModelProvider(this).get(BarViewModel.class);
        vm.init();

        vm.getData().observe(this, (data) ->{
            adapter.setResults(data);

        });

        BFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.filtrarEstrella(Integer.parseInt(String.valueOf(EditText.getText())));
            }
        });


        vm.listarReseñas();

    }



}