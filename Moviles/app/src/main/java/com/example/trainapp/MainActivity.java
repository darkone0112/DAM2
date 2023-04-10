package com.example.trainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    public viaje viaje = new viaje();
    public Spinner spinner,spinner1;
    public TextView fechaida,fechavuelta,nombre,dni,direccion,error;
    public ToggleButton idavuelta;
    public Button btn;
    public LinearLayout linearLayout5,linearLayout2, linearLayout;
    public static String [] options = new String[]{"Madrid","Santiago","Santander"};
    Date fecha1;
    Date fecha2;
    public static String laclave = "laclave";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        error = findViewById(R.id.error);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        linearLayout5 = (LinearLayout) findViewById(R.id.linearLayout5);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        fechaida = (EditText) findViewById(R.id.fechaIda);
        fechavuelta = (EditText) findViewById(R.id.fechaVuelta);
        direccion = (EditText)findViewById(R.id.direccion);
        nombre = findViewById(R.id.nombre);
        dni = findViewById(R.id.dni);
        idavuelta = findViewById(R.id.idavuelta);
        btn = findViewById(R.id.btn);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        fechaida.setOnClickListener(this);
        fechavuelta.setOnClickListener(this);
        idavuelta.setOnClickListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == spinner.getId()){
            viaje.setOrigen(parent.getItemAtPosition(position).toString());
        }else{
            viaje.setDestino(parent.getItemAtPosition(position).toString());
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        switch (view.getId()){
            case R.id.idavuelta:
                    if (idavuelta.isChecked()){
                        fechavuelta.setClickable(true);
                        fechavuelta.setEnabled(true);
                        fechavuelta.setText("Fecha Vuelta");
                    }else{
                        fechavuelta.setClickable(false);
                        fechavuelta.setEnabled(false);
                        fechavuelta.setText("Sin Regreso");

                    }
                break;
            case R.id.fechaIda:
                showDatePickerDialog((EditText) fechaida);
               // viaje.setFechaSalida((Date)fechaida.getText());
                break;
            case R.id.fechaVuelta:
                showDatePickerDialog((EditText)fechavuelta);
                //viaje.setFechaRegreso((Date)fechavuelta.getText());
                break;
            case R.id.btn:
                checkValues();
                viaje.setDni(dni.getText().toString());
                viaje.setNombre(nombre.getText().toString());
                viaje.setDireccion(direccion.getText().toString());
                Intent lanzar = new Intent(this, display.class);
                lanzar.putExtra(laclave, passString());
                startActivity(lanzar);
                break;
        }
    }
    private void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + "/" + (month+1) + "/" + year;
                editText.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void checkValues(){
        Pattern PattDni = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Matcher matDni = PattDni.matcher(dni.getText());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fecha1 = simpleDateFormat.parse(fechaida.getText().toString());
            fecha2 = simpleDateFormat.parse(fechavuelta.getText().toString());
            if (viaje.getOrigen().equalsIgnoreCase(viaje.getDestino())){
                spinner.getBackground().setColorFilter(Color.RED,PorterDuff.Mode.SRC_ATOP);
                spinner1.getBackground().setColorFilter(Color.RED,PorterDuff.Mode.SRC_ATOP);
                //error = false;
            }else{
                spinner.getBackground().setColorFilter(Color.BLUE,PorterDuff.Mode.SRC_ATOP);
                spinner1.getBackground().setColorFilter(Color.BLUE,PorterDuff.Mode.SRC_ATOP);
                //error = true;
            }
            if (matDni.matches()){
                dni.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            }else{
                dni.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            }
            if (fecha1.after(fecha2)){
                fechavuelta.getBackground().setColorFilter(Color.RED,PorterDuff.Mode.SRC_ATOP);
                error.setText("La fecha de regreso es anterior a la de ida");
            }else{
                fechavuelta.getBackground().setColorFilter(Color.BLACK,PorterDuff.Mode.SRC_ATOP);
            }
        }catch (ParseException e){
            error.setText("Los datos son obligatorios");
        }

        //return error;
       /* if (ciudades[0] == ciudades[1]){
            direccion.setText("iguales");
        }else{
            direccion.setText("diferentes");
        }
        dni.setText(ciudades[0]);
        nombre.setText(ciudades[1]);
    }*/
    }
    public String passString(){
        String string = "Origen: " + viaje.getOrigen() + "\n" +
                        "Destino: " + viaje.getDestino()+ "\n" +
                        "Fecha Ida: " + fecha1 + "\n" +
                        "Fecha Vuelta: " + fecha2 + "\n" +
                        "Nombre: " + viaje.getNombre() + "\n" +
                        "Dni: " + viaje.getDni() + "\n" +
                        "Direccion: " + viaje.getDireccion();
        return string;
    }
}