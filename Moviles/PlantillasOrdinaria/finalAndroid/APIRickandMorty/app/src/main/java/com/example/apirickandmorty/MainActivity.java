package com.example.apirickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import MutableLiveDataPersonajes.PersonajeAdapter;
import MutableLiveDataPersonajes.PersonajesViewModel;
import RickMortyAPI.APIMapear.PaginaRespuesta;

public class MainActivity extends AppCompatActivity implements PersonajeAdapter.OnItemClickListener {

    Button BSiguiente,BVolver;
    RecyclerView personajeRecycler;
    PersonajesViewModel vm;
    LiveData<PaginaRespuesta> data;
    private static String PAGINA_INICIAL = "1";
    private static String siguientePagina;
    private static String volverPagina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BSiguiente = findViewById(R.id.BSiguiente);
        BVolver = findViewById(R.id.BVolver);
        personajeRecycler = findViewById(R.id.PersonajesRecycler);

        //Vainas del Recycler y el adapter
        PersonajeAdapter adapter = new PersonajeAdapter(this);
        personajeRecycler.setLayoutManager(new LinearLayoutManager(this));
        personajeRecycler.setAdapter(adapter);

        //Método onClick
        adapter.setOnItemClickListener(this);

        //Vainas del ViewModel
        vm = new ViewModelProvider(this).get(PersonajesViewModel.class);
        vm.init();
        data = vm.getPaginaRespuestaLiveData();

        //Observador MutableLiveData
        data.observe(this, (data) ->{

            adapter.setResults(data.getPersonajesRespuestas());

            //Obtiene la siguiente pagina
            siguientePagina = data.getInfopage().getNext();
            Log.d("ojo",siguientePagina);

            //Obtiene la url para volver
            volverPagina = data.getInfopage().getPrev();

        });

        //Invoca la primera página automáticamente
        vm.buscarPagina(PAGINA_INICIAL);

        //Siguiente página
        BSiguiente.setOnClickListener(view -> {

            if (siguientePagina != null) {
                //Hace una nueva petición
                vm.siguientePagina(siguientePagina);
            } else {
                Toast.makeText(this,"No hay página siguiente",Toast.LENGTH_SHORT).show();
            }
        });

        //Volver página
        BVolver.setOnClickListener(view -> {

            //Hace una nueva peticion
            if (volverPagina != null) {
                vm.volverPagina(volverPagina);
            } else {
                Toast.makeText(this,"No hay página anterior",Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onItemClick(int position) {

    }

}