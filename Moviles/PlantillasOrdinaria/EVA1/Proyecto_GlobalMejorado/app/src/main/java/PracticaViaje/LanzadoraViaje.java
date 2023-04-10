package PracticaViaje;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


import com.example.proyecto_global.R;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanzadoraViaje extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText EHora,EHoraV,EFechaV,EFecha,EDni,ENombre,EDireccion;
    Switch ESwitch;
    Button EEnviado;
    boolean validado=true,esAccionado=false;
    String ESpinnerText,ESpinnerTextV,ESpinnerIdaText;
    Spinner ESpinnerV,ESpinner,ESpinnerIda;
    Viaje miViaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzadora_viaje);
        //Spinner ida
        ESpinnerIda = (Spinner) findViewById(R.id.ESpinnerIda);
        //Spinner Vuelta
        ESpinnerV = (Spinner) findViewById(R.id.ESpinnerV);
        //Spinner Entrada
        ESpinner = (Spinner) findViewById(R.id.ESpinnerS);
        //Adaptador
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Añadir al Spinner el adaptador
        ESpinnerV.setAdapter(adapter);
        ESpinner.setAdapter(adapter);
        ESpinnerIda.setAdapter(adapter);
        //Identificar variables
        ESwitch = findViewById(R.id.ESwitch);
        EHoraV = findViewById(R.id.EHoraV);
        EHora = findViewById(R.id.EHora);
        EFechaV = findViewById(R.id.EFechaV);
        EFecha = findViewById(R.id.EFecha);
        EDni = findViewById(R.id.EDni);
        EEnviado = findViewById(R.id.EEnviado);
        ENombre = findViewById(R.id.ENombre);
        EDireccion = findViewById(R.id.EDireccion);

        //Accedemos al método e incluimos la eleccion a una variable
        ESpinner.setOnItemSelectedListener(this);
        ESpinnerV.setOnItemSelectedListener(this);
        ESpinnerIda.setOnItemSelectedListener(this);

        //Expresion regulares
        EEnviado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validado=true;
                try {
                    validacion();
                } catch (ParseException x) {

                }

            }
        });

        //Verifica si es checked
        ESwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if (b) {
                   EHoraV.setVisibility(View.VISIBLE);
                   EFechaV.setVisibility(View.VISIBLE);
                   ESpinnerV.setVisibility(View.VISIBLE);
                   EHoraV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                   EFechaV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);

                       esAccionado=true;

               } else {
                   EHoraV.setVisibility(View.INVISIBLE);
                   EFechaV.setVisibility(View.INVISIBLE);
                   ESpinnerV.setVisibility(View.INVISIBLE);
                   EHoraV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                   EFechaV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);

               }
           }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
       //Añade la elección a la variable String (Para comparar que no son iguales)
        if (adapterView.getId()==ESpinner.getId()){
            ESpinnerText = adapterView.getItemAtPosition(posicion).toString();
        } else {
            if (adapterView.getId()==ESpinnerV.getId()) {
                ESpinnerTextV = adapterView.getItemAtPosition(posicion).toString();
            } else {
                if (adapterView.getId()==ESpinnerIda.getId()) {
                    ESpinnerIdaText = adapterView.getItemAtPosition(posicion).toString();
                }
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void validacion() throws ParseException {
        //Objetos Pattern and Matcher
        Pattern PattDni = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Pattern PattFecha = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
        Pattern PattHora = Pattern.compile("[0-2][0-9]:[0-9][0-9]");
        Matcher matdni = PattDni.matcher(EDni.getText());
        Matcher matFecha = PattFecha.matcher(EFecha.getText());
        Matcher matHora = PattHora.matcher(EHora.getText());
        //Objetos Pattern and Matcher Switch
        Pattern PattFechaV = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
        Pattern PattHoraV = Pattern.compile("[0-2][0-9]:[0-9][0-9]");
        Matcher matFechaV = PattFechaV.matcher(EFechaV.getText());
        Matcher matHoraV = PattHoraV.matcher(EHoraV.getText());

        //Pattern del objeto date, objetos date e inialización
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdf.parse("00/00/0000");
        Date fechaV = sdf.parse("00/00/0000");

        //Variables objeto Viaje
        String EhoraT="",EFechaT="",EDniT="",ESpinnerT="",ESpinnerIdaT="";
        String EhoraTV=" - ",EFechaTV=" - ",ESpinnerVT=" - ";
        String ENombreT = String.valueOf(ENombre.getText());
        String EDireccionT = String.valueOf(EDireccion.getText());

        //Pasa a true para volver a intentar
        validado=true;

        //Validación hora
        if (matHora.matches()){
            EHora.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            EHoraV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            EhoraT = String.valueOf(EHora.getText());
        } else {
            EHora.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            validado=false;
        }
        //Validacion Fecha
        if (matFecha.matches()){
            EFecha.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            fecha = sdf.parse(String.valueOf(EFecha.getText()));
            EFechaT = String.valueOf(EFecha.getText());
        } else {
            EFecha.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            validado=false;
        }
        //Validacion DNI
        if (matdni.matches()){
            EDni.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            EDniT = String.valueOf(EDni.getText());
        } else {
            EDni.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            validado=false;
        }
        //Validacion elementos Vuelta
        if (esAccionado) {
            if (matHoraV.matches()){
                EHoraV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                EFechaV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                EhoraTV = String.valueOf(EHoraV.getText());
            } else {
                EHoraV.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                validado=false;
            }
            //Validacion Fecha
            if (matFechaV.matches()){
                EFechaV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                fechaV = sdf.parse(String.valueOf(EFechaV.getText()));
                EFechaTV = String.valueOf(EFechaV.getText());
            } else {
                EFechaV.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                validado=false;
            }
            //Validacion Fecha
            if (fechaV.compareTo(fecha)>0) {
                EFechaV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                EFecha.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            } else {
                EFechaV.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                EFecha.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                validado=false;
            }
        }

        //Validacion Spinner
        if (ESpinnerText.equalsIgnoreCase(ESpinnerIdaText)) {
            ESpinner.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            ESpinnerIda.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            validado=false;
        } else {
            ESpinner.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            ESpinnerIda.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            ESpinnerT = ESpinnerText;
            ESpinnerIdaT = ESpinnerIdaText;
        }
        if (esAccionado) {
            if (ESpinnerIdaText.equalsIgnoreCase(ESpinnerTextV)) {
                ESpinnerIda.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                ESpinnerV.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                validado = false;
            } else {
                ESpinnerIda.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                ESpinnerV.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                if (esAccionado) {
                    ESpinnerVT = ESpinnerTextV;
                }
            }
        }
        //Validación completada
        //Creación objeto viaje
        miViaje = new Viaje(EhoraT,ESpinnerT,EFechaT,ESpinnerIdaT,
                            EhoraTV,EFechaTV,ESpinnerVT,ENombreT,
                            EDireccionT,EDniT);

        if (validado) {
            enviar();
        }
    }

    public void enviar() {
        Intent envioViaje = new Intent(this,Recibidora.class);
        envioViaje.putExtra("Viaje", (Serializable) miViaje);
        startActivity(envioViaje);
    }

}

