package com.example.lopezjavier_proyect;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ComidasBas> comidasBasList;
    RecyclerView recyclerComidas;
    ComidaAdapter adapter;
    appDataBase db;
    ComidaDao comidaDao;
    Button EButton;
    private ComidaAdapter.RecyclerViewClickListener listener;
    ActivityResultLauncher resultadoLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerComidas =(RecyclerView) findViewById(R.id.SListaContenedor);
        EButton = findViewById(R.id.EButton);

        //Creo el ArrayList que se utilizara para distintas operaciones
        comidasBasList=new ArrayList<>();

        //Oculta la barra
        getSupportActionBar().hide();

        //Metodo que crea la base de datos
        createORM();

        //Metodo encargado de crear el RecyclerView
        createRecycler();

        //Anadir otra comida - accede a otra actividad
        EButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Metodo que envia a la actividad de modificaciones
                envio();
            }
        });

        //Intent principal, intent launcher, recibe todos los intent
        resultadoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{

                    //Codigo que va a recibir los Intents entrantes - (actualiza el recycler)
                    comidasBasList= comidaDao.getAll();
                    adapter = new ComidaAdapter(comidasBasList,listener);
                    recyclerComidas.setAdapter(adapter);

                });

    }



    public void createRecycler() {

        //Llama al metodo  ClickListener
        setOnClickListener();

        adapter = new ComidaAdapter(comidasBasList,listener);

        //obtiene el layout del dispositivo
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerComidas.setLayoutManager(LayoutManager);

        recyclerComidas.setItemAnimator(new DefaultItemAnimator());
        //Anades el adaptador al dispositivo
        recyclerComidas.setAdapter(adapter);
    }

    //Metodo que recibe una pulsacion (click) para acceder a otra actividad
    private void setOnClickListener() {
        listener= new ComidaAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {

                //Crea un Intent que accede a la actividad que muestra el objeto
                Intent intent= new Intent(getApplicationContext(),MainClickMod.class);
                intent.putExtra("nombre",comidasBasList.get(position).getNombre());
                intent.putExtra("descripcion",comidasBasList.get(position).getDescripcion());
                intent.putExtra("comidaimg",comidasBasList.get(position).getImgcomida());

                resultadoLauncher.launch(intent);
            }
        };}

    //Metodo que carga la base de datos
    public void createORM () {
        //Se crea la base de datos
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "comidasimg1").allowMainThreadQueries().build();

        //Extrae los datos de la bd para poder hacer querys
        comidaDao = db.comidasDAO();

        //extr4e el contenido de la bd
        comidasBasList= comidaDao.getAll();

    }

    //Metodo envio
    public void envio() {

            //Abre una nueva actividad a la espera de nuevos resulset
            Intent intent = new Intent(MainActivity.this,MainModActivity.class);
            resultadoLauncher.launch(intent);

    }
}