package com.example.proyecto_global;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PiedraPapelTijeras extends AppCompatActivity implements View.OnClickListener{

    ImageView EChill,EPiedra,ETijera,EPapel;
    TextView SConPlayer,SConMaquina,SMaquina,SResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piedra_papel_tijeras);

        //Asignamos elementos a variables
        EChill=findViewById(R.id.EChill);
        EPiedra = findViewById(R.id.EPiedra);
        ETijera = findViewById(R.id.ETijeras);
        EPapel = findViewById(R.id.EPapel);
        SConPlayer = findViewById(R.id.SContadorPlayer);
        SConMaquina = findViewById(R.id.SContadorMaquina);
        SMaquina = findViewById(R.id.SMaquina);
        SResultado = findViewById(R.id.SResultado);

        //Implementamos el método a las variables
        EChill.setOnClickListener(this);
        EPiedra.setOnClickListener(this);
        ETijera.setOnClickListener(this);
        EPapel.setOnClickListener(this);
    }

    manoElegida jugador = new manoElegida();

    public void onClick (View view) {
        boolean ganador = false;
        switch(view.getId()) {
            case R.id.EChill:
                jugador.manoChill();
                break;
            case R.id.EPiedra:
                jugador.manoPiedra();
                break;
            case R.id.ETijeras:
                jugador.manoTijera();
                break;
            case R.id.EPapel:
                jugador.manoPapel();
                break;
        }
        visualizarPantalla();
    }

    public void visualizarPantalla () {
        SConPlayer.setText(String.valueOf(jugador.getContJugador()));
        SConMaquina.setText(String.valueOf(jugador.getContMaquina()));
        //Visualiza la mano Rival
        switch (jugador.getManoRival()) {
            case 1:
                SMaquina.setText("CPU usa Tijeras");
                break;
            case 2:
                SMaquina.setText("CPU usa Papel");
                break;
            case 3:
                SMaquina.setText("CPU usa Piedra");
                break;
            default:
                SMaquina.setText("SUAVE. . .");
                break;
        }
        //Visualiza el vencedor
        switch (jugador.getVencedor()) {
            case 1:
                SResultado.setText("El ganador es player");
                break;
            case 2:
                SResultado.setText("El ganador es CPU");
                break;
            case 0:
                SResultado.setText("EMPATE");
                break;
            case 3:
                SResultado.setText("De Chill eh...");
                break;
        }
    }




}