package com.example.atracciones.Comentarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.atracciones.AtraccionViewModel;
import com.example.atracciones.Data.Comentario;
import com.example.atracciones.Data.Comentarios;
import com.example.atracciones.R;
import com.example.atracciones.ResultadoAdapter;

import java.util.List;

public class ListadoComentarios extends AppCompatActivity {
    RecyclerView listado;
    AtraccionViewModel vm;
    LiveData<Comentarios> data;

    private Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        listado = findViewById(R.id.idRecyclerComentarios);

        AdaptadorComentarios adapter = new AdaptadorComentarios();
        listado.setLayoutManager(new LinearLayoutManager(this));
        listado.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(AtraccionViewModel.class);
        vm.init();
        data = vm.getComentariosLiveData();
        data.observe(this, data -> {
            adapter.setResults(data.getComentario());
        });

        id = Integer.parseInt(String.valueOf(getIntent().getSerializableExtra("datos")));
        vm.mostrarComentarios(id);
    }
}