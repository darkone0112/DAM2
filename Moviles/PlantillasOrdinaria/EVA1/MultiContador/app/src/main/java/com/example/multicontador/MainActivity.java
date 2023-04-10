package com.example.multicontador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Text1,Text2,Text3,Text4,Text5;
    Button Boton1,Boton2,Boton3,Boton4,Boton5,Boton22,Boton33,Boton44,Boton55;
    public int [] valores = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos el id a la variable
        Text1=findViewById(R.id.Text1);
        Text2=findViewById(R.id.Text2);
        Text3=findViewById(R.id.Text3);
        Text4=findViewById(R.id.Text4);
        Text5=findViewById(R.id.Text5);
        Boton1=findViewById(R.id.Boton1);
        Boton2=findViewById(R.id.Boton2);
        Boton3=findViewById(R.id.Boton3);
        Boton4=findViewById(R.id.Boton4);
        Boton5=findViewById(R.id.Boton5);
        Boton22=findViewById(R.id.Boton22);
        Boton33=findViewById(R.id.Boton33);
        Boton44=findViewById(R.id.Boton44);
        Boton55=findViewById(R.id.Boton55);

        //Asignamos a cada boton el método setOnClickListener
        Boton1.setOnClickListener(this);
        Boton2.setOnClickListener(this);
        Boton3.setOnClickListener(this);
        Boton4.setOnClickListener(this);
        Boton5.setOnClickListener(this);
        Boton22.setOnClickListener(this);
        Boton33.setOnClickListener(this);
        Boton44.setOnClickListener(this);
        Boton55.setOnClickListener(this);

    }

    @Override
    public void onClick(View vista) {
        switch (vista.getId()) {
            case R.id.Boton1:
                valores[0] = valores[1] = valores[2] = valores[3] = valores[4] = 0;
                break;
            case R.id.Boton2:
                valores[1]++;
                valores[0]++;
                break;
            case R.id.Boton3:
                valores[2]++;
                valores[0]++;
                break;
            case R.id.Boton4:
                valores[3]++;
                valores[0]++;
                break;
            case R.id.Boton5:
                valores[4]++;
                valores[0]++;
                break;
            case R.id.Boton22:
                valores[0]-=valores[1];
                valores[1]=0;
                break;
            case R.id.Boton33:
                valores[0]-=valores[2];
                valores[2]=0;
                break;
            case R.id.Boton44:
                valores[0]-=valores[3];
                valores[3]=0;
                break;
            case R.id.Boton55:
                valores[0]-=valores[4];
                valores[4]=0;
                break;
        }
        Text1.setText(String.valueOf(valores[0]));
        Text2.setText(String.valueOf(valores[1]));
        Text3.setText(String.valueOf(valores[2]));
        Text4.setText(String.valueOf(valores[3]));
        Text5.setText(String.valueOf(valores[4]));
    }
}