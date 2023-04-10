package com.example.examenejercicio1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String CLAVE_INFO = "PRIMERACOMUNICACION";
    private EditText numero1,numero2;
    private RadioButton suma,resta,div,multi;
    private Button calcular;
    private RadioGroup radioGroup;
    numerosDAO numerosDAO;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        radioGroup = findViewById(R.id.radioGroup);
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        div = findViewById(R.id.div);
        multi = findViewById(R.id.multi);
        calcular = findViewById(R.id.calcular);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"numeros").allowMainThreadQueries().build();
        numerosDAO = db.numerosDAO();
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int seleccion = radioGroup.getCheckedRadioButtonId();
                numeros n = new numeros();
                n.numero1 = Integer.valueOf(String.valueOf(numero1.getText()));
                n.numero2 = Integer.valueOf(String.valueOf(numero2.getText()));
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.suma:
                            n.operacion = "suma";
                        break;
                    case R.id.resta:
                            n.operacion = "resta";
                        break;
                    case R.id.div:
                            n.operacion ="div";
                        break;
                    case R.id.multi:
                            n.operacion =  "multi";
                        break;
                }
                numerosDAO.insertAll(n);
                Intent intento =  new Intent(getApplicationContext(),mostrar.class);
                startActivity(intento);
            }
        });
    }
}