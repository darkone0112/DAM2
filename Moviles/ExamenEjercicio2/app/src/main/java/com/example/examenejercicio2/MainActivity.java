package com.example.examenejercicio2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String CLAVE_INFO = "PRIMERACOMUNICACION";
    private RecyclerView MyRecycleView;
    private Button lanzador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lanzador = findViewById(R.id.lanzar);
        MyRecycleView = findViewById(R.id.MyRecycleView);
        ArrayList<productos>productos = new ArrayList<>();
        productos.add(new productos("Lechuga",0,20));
        productos.add(new productos("Tomate",0,25));
        productos.add(new productos("Pepinillo",0,18));
        productos.add(new productos("Filete Pollo",0,150));
        productos.add(new productos("Filete Ternera",0,210));
        productos.add(new productos("Filete Lomo",0,190));
        lanzador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalProductos = 0;
                int precioTotal = 0;
                for (int i = 0; i < productos.size(); i++) {
                    totalProductos += productos.getCantidad;
                    precioTotal += productos.getPrecio;
                }
                Intent intento = new Intent(this,mostrar.class);
                intento.putExtra(CLAVE_INFO, productos.toString());
                startActivity(intento);
            }
        });
        ProductosAdapter adapter = new ProductosAdapter(this);
        adapter.setProductos(productos);
        MyRecycleView.setAdapter(adapter);
        MyRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void lanzar(){

    }
}