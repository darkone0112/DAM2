package com.example.final_repaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerComidas;
    ComidaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerComidas =(RecyclerView) findViewById(R.id.SListaContenedor);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerComidas.setLayoutManager(layoutManager);


    }

    @Override
    protected void onStart() {
        super.onStart();
        //adapter.add(Comidas.generateComidas());
        adapter = new ComidaAdapter(Comidas.generateComidas());
        recyclerComidas.setAdapter(adapter);

    }
}