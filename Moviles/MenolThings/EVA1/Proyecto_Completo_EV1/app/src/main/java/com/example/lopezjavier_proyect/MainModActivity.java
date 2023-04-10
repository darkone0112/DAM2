package com.example.lopezjavier_proyect;

import static android.content.ContentValues.TAG;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainModActivity extends AppCompatActivity implements View.OnClickListener{

    Button  EVolver,EModificar,EAnadir,EEliminar,ELlamada,comidaImag;
    EditText SNombre,SNuevoNombre,SDescripcion;
    ComidaDao comidaDao;
    appDataBase db;
    ImageView comidaImagen;
    ActivityResultLauncher<String> requestPermissionLauncher;
    ActivityResultLauncher<Intent> imgResult;
    ActivityResultLauncher resultadoLauncher;

    //Variable final que indica que actividad ha terminado
    public static final int MAINMODACTIVITY = 1;
    private Uri uriCapturada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mod);
        getSupportActionBar().hide();

        //Metodo que asigna la bd
        createORM();

        //Asignamos el valor id a cada variable
        EVolver = findViewById(R.id.EVolver);
        EModificar = findViewById(R.id.EModificar);
        EAnadir = findViewById(R.id.EAnadir);
        SNombre = findViewById(R.id.SNombreMod);
        SNuevoNombre = findViewById(R.id.SNuevoNombre);
        SDescripcion = findViewById(R.id.SDescripcionMod);
        EEliminar = findViewById(R.id.EEliminar);
        ELlamada = findViewById(R.id.ELlamada);
        comidaImag = findViewById(R.id.Img);
        comidaImagen = findViewById(R.id.comidaImage);

        //Llamamos al metodo abstracto
        EVolver.setOnClickListener(this);
        EModificar.setOnClickListener(this);
        EAnadir.setOnClickListener(this);
        EEliminar.setOnClickListener(this);
        ELlamada.setOnClickListener(this);
        comidaImag.setOnClickListener(this);
        comidaImagen.setOnClickListener(this);

        requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {
                llamar();
            } else {
                Toast.makeText(MainModActivity.this, "Se requiere el permiso", Toast.LENGTH_SHORT).show();
            }
        });

        imgResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode()==RESULT_OK){
                        Intent data = result.getData();

                        uriCapturada = data.getData();
                        getContentResolver().takePersistableUriPermission(uriCapturada, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        comidaImagen.setImageURI(uriCapturada);


                    }
                }
        );

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.EVolver:
                volverPagina();
                break;
            case R.id.EModificar:
                modificarPlato();
                break;
            case R.id.EAnadir:
                anadirPlato();
                break;
            case R.id.EEliminar:
                eliminarPlato();
                break;
            case R.id.ELlamada:
                llamadaClick(ELlamada);
                break;
            case R.id.Img:
                //Anade una imagen
                selectImg();
                break;
            case R.id.comidaImage:
                //Anade una imagen
                selectImg();
                break;
        }
    }

    //
    public void selectImg () {
        Intent i =new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.putExtra(MediaStore.EXTRA_OUTPUT, uriCapturada);
        imgResult.launch(i);

    };

    //Metodo que inicia la llamada
    private void llamar(){
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:604 32 62 41"));
        startActivity(phoneIntent);
    }

    //Permite preguntar los permisos
    public void llamadaClick(View v){
        Toast.makeText(getApplicationContext(),"co;oo",Toast.LENGTH_SHORT);
        if (ContextCompat.checkSelfPermission(
                MainModActivity.this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {

            //Llama al metodo de llamada
            llamar();
        } else if (false) {

        } else {
            requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
        }
    }

    public void volverPagina() {

        Intent volverInt = new Intent(this,MainActivity.class);
        setResult(MAINMODACTIVITY,volverInt);
        finish();
    }

    public void anadirPlato () {

        if (!SNombre.getText().toString().equals("") && uriCapturada!= null) {
            String comidaRuta = uriCapturada.toString();
            correcto(SNombre);
            ComidasBas comidaBd = new ComidasBas();
            comidaBd.nombre = SNombre.getText().toString();
            comidaBd.descripcion= SDescripcion.getText().toString();
            comidaBd.imgcomida= comidaRuta;
            comidaDao.insertAll(comidaBd);
            Toast.makeText(getApplicationContext(),"Plato añadido",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Debe introducir un nombre y una imagen",Toast.LENGTH_SHORT).show();
            inCorrecto(SNombre);
        }

    }

    public void eliminarPlato () {
        boolean eliminado=false;
        if (!SNombre.getText().toString().equals("")) {
            //Extrae el total de la base de datos y comprueba si coincide
            List<ComidasBas> comidasbd = comidaDao.getAll();
            for (ComidasBas x : comidasbd) {
                if (SNombre.getText().toString().equals(x.nombre)) {
                    Toast.makeText(getApplicationContext(),"Ha borrado la comida "+x.nombre,Toast.LENGTH_SHORT).show();
                    comidaDao.delete(x);
                    eliminado=true;
                    correcto(SNombre);
                }
            }
        } else {
            inCorrecto(SNombre);
            Toast.makeText(getApplicationContext(),"Debe introducir un nombre si desea borrar",Toast.LENGTH_SHORT).show();
        }
        if (!eliminado) {
            inCorrecto(SNombre);
            Toast.makeText(getApplicationContext(),"Comida no encontrada",Toast.LENGTH_SHORT).show();
        }
    }

    public void modificarPlato () {
        //Extrae el total de la base de datos y comprueba si coincide
        Boolean validado=true;
        if (SNuevoNombre.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Debe introducir un nuevo nombre",Toast.LENGTH_SHORT).show();
            validado=false;
            //Si no ha validado aplica color rojo
            inCorrecto(SNuevoNombre);
        }
        if (validado) {

            //Si ha validado aplica color black
            correcto(SNuevoNombre);

            //Extrae el contenido actualizado de la base de datos
            List<ComidasBas> comidasbd = comidaDao.getAll();

            Boolean encontrado = false;
            for (ComidasBas x : comidasbd) {
                if (SNombre.getText().toString().equals(x.nombre)) {
                    correcto(SNombre);
                    x.nombre = SNuevoNombre.getText().toString();
                    x.descripcion = SDescripcion.getText().toString();
                    x.imgcomida = uriCapturada.toString();
                    comidaDao.updateRecord(x);
                    Toast.makeText(getApplicationContext(),"Comida editada",Toast.LENGTH_SHORT).show();
                    encontrado=true;
                }
            }
            //Comprueba si ha encontrado el registro
            if (!encontrado) {
                Toast.makeText(getApplicationContext(),"Comida no encontrada",Toast.LENGTH_SHORT).show();
                inCorrecto(SNombre);
            }
        }
    }

    public void createORM () {
        //Se crea la base de datos
        db = Room.databaseBuilder(getApplicationContext(),
                appDataBase.class, "comidasimg1").allowMainThreadQueries().build();
        comidaDao = db.comidasDAO();


    }

    public void inCorrecto (EditText editext) {
        editext.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
    }
    public void correcto(EditText editext) {
        editext.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
    }

}