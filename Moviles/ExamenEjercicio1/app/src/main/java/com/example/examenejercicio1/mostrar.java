package com.example.examenejercicio1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mostrar extends AppCompatActivity {
    numerosDAO numerosDAO;
    AppDatabase db;
    TextView result;
    Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        result = findViewById(R.id.result);
        reset = findViewById(R.id.reset);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"numeros").allowMainThreadQueries().build();
        numerosDAO = db.numerosDAO();
        int numero1 = 0;
        int numero2 = 0;
        numerosDAO.loadNumber1(numero1);
        numerosDAO.loadNumber2(numero2);
        result.setText(String.valueOf(numero1+numero2));
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(0);
                //numerosDAO.delete();
            }
        });
    }
}