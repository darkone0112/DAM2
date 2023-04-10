package com.example.lopezjavier_proyect;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainClickMod extends AppCompatActivity implements View.OnClickListener{

        Button SVolver,SEdit,SBorrar;
        appDataBase db;
        ComidaDao comidaDao;
        TextView SNombre,SDescripcion;
        ImageView SImageClick;

        //Variable para indicar cual es la actividad que regresa
        public static final int MAINACTIVITY = 1;
    public static final int MAINMODACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_click_mod);
        getSupportActionBar().hide();

        SVolver = findViewById(R.id.VolverClick);
        SEdit = findViewById(R.id.EditarClick);
        SBorrar = findViewById(R.id.EliminarClick);

        SNombre = findViewById(R.id.SNombreClick);
        SDescripcion = findViewById(R.id.SDescripcionClick);
        SImageClick = findViewById(R.id.SImageClick);

        //Metodo que carga la BD
        createORM();

        //Metodo que inyecta la informacion
        asigComida();

        SVolver.setOnClickListener(this);
        SEdit.setOnClickListener(this);
        SBorrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.VolverClick:
                volverPagina();

                break;
            case R.id.EditarClick:

                //Metodo que devuelve a la pagina principal
                irMod();
                //Se cierra tras iniciar la actividad

                break;
            case R.id.EliminarClick:
                borrar();
                break;
        }
    }

    public void irMod() {

        //Devuelve a la actividad edit
        Intent volverMod = new Intent(this,MainModActivity.class);
        startActivity(volverMod);
        finish();
    }

    public void volverPagina() {

        //Devuelve a la actividad principal
        Intent volverInt = new Intent(this,MainActivity.class);
        setResult(MAINACTIVITY,volverInt);
        finish();
    }

    public void asigComida () {

        //Se extrae todos los extras enviados
        Bundle extras=getIntent().getExtras();

        //Se asigna valores a los TextViews
        SNombre.setText(extras.getString("nombre"));
        SDescripcion.setText(extras.getString("descripcion"));
        SImageClick.setImageURI(Uri.parse(extras.getString("comidaimg")));
    }

    public void createORM () {
        //Se crea la base de datos
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "comidasimg1").allowMainThreadQueries().build();

        //Extrae los datos de la bd para poder hacer querys
        comidaDao = db.comidasDAO();
    }

    public void borrar() {
        List <ComidasBas> comidasbd = comidaDao.getAll();
        for (ComidasBas x : comidasbd) {
            if (x.nombre.equals(SNombre.getText().toString())) {
                comidaDao.delete(x);
            }
        }
    }

}