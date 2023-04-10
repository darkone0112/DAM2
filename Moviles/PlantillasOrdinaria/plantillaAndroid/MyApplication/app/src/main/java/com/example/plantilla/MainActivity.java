package com.example.plantilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import APIRepositoryViewModel.ObjetoRepository;
import APIRepositoryViewModel.ObjetoViewModel;
import APIServiceMap.ObjetoResponse;

public class MainActivity extends AppCompatActivity implements ObjetoAdapter.onItemClickListener{

    private RecyclerView lista;
    private ObjetoAdapter adapter;
    private ObjetoViewModel vm;
    private final int LIMIT_SCROLL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.Recycler);

        //Adapter
        lista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ObjetoAdapter();
        lista.setAdapter(adapter);

        //ViewModel
        vm = new ViewModelProvider(this).get(ObjetoViewModel.class);
        vm.init();

        vm.getData().observe(this, (data) ->{

            adapter.setResults(data);

        });

        vm.listarObjetos();

        //Método que detecta cuando has llegado al final y añade más objetos en el recycler
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) lista.getLayoutManager();
        lista.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastItemVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int allItems = lista.getAdapter().getItemCount();

                if (lastItemVisible == (allItems - LIMIT_SCROLL)) {
                    vm.listarObjetos();
                }



            }
        });

        //Para añadir objeto
        ObjetoResponse objetoResponse = new ObjetoResponse("nombre inventado","linkimagen");
        vm.addObjeto(objetoResponse);

        //Para eliminar objeto
        vm.deleteBar(1);

    }


    @Override
    public void onItemClick(int position) {

        String nombreObjeto = adapter.getResults().get(position).getInventado();
        envio(nombreObjeto);

    }

    public void envio(String nombre){

        Intent intent = new Intent(this, MostrarDetalle.class);
        intent.putExtra("nombre",nombre);
        startActivity(intent);

    }


}