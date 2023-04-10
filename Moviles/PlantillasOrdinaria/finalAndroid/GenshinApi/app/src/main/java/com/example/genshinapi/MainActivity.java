package com.example.genshinapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import GenshinAPI.GenshinAdapter;
import GenshinAPI.GenshinViewModel;

public class MainActivity extends AppCompatActivity implements GenshinAdapter.onItemClickListener {

    private RecyclerView lista;
    private GenshinAdapter adapter;
    private GenshinViewModel vm;
    private ProgressBar progressBarResult;

    private int MAX_RESULTS = 10;
    private int ADDNEW_RESULTS = 10;
    private int FINAL_SCROLL;
    public static final int LIMIT_SCROLL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarResult = findViewById(R.id.progressResults);
        lista = findViewById(R.id.recyclerGenshin);

        //Adapter
        lista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GenshinAdapter();
        lista.setAdapter(adapter);

        //Método OnClick
        adapter.setmListener(this);

        //ViewModel
        vm = new ViewModelProvider(this).get(GenshinViewModel.class);
        vm.init();

        vm.getData().observe(this, (data) -> {

            //Obtengo el tamaño máximo de la petición
            FINAL_SCROLL = data.size();

            //Limita la petición para solo mostrar 10 valores (MAX_RESULT)
            data.subList(MAX_RESULTS,data.size()).clear();

            progressBarResult.setVisibility(View.INVISIBLE);
            adapter.setResults(data);

            //Al volver a bajar hará una nueva petición con más resultados
            MAX_RESULTS+=ADDNEW_RESULTS;

        });

        vm.mostrarPersonajes();


        //Método que detecta cuando has llegado al final y añade más objetos en el recycler
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) lista.getLayoutManager();
        lista.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastItemVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int allItems = lista.getAdapter().getItemCount();

                if (lastItemVisible == (allItems - LIMIT_SCROLL)) {
                    progressBarResult.setVisibility(View.VISIBLE);
                    if (MAX_RESULTS>=FINAL_SCROLL) {
                        Toast.makeText(com.example.genshinapi.MainActivity.this, "No hay más Personajes", Toast.LENGTH_SHORT).show();
                    }
                    if ((MAX_RESULTS + ADDNEW_RESULTS) > (FINAL_SCROLL)) {
                        MAX_RESULTS = FINAL_SCROLL;
                    }
                    vm.mostrarPersonajes();
                }



            }
        });



    }


    @Override
    public void onItemClick(int position) {
        String nombre = adapter.getResults().get(position);
        envio(nombre);
    }

    public void envio(String nombre) {
        Intent intent = new Intent(this, DetallePersonaje.class);
        intent.putExtra("nombre",nombre);
        startActivity(intent);

    }

}