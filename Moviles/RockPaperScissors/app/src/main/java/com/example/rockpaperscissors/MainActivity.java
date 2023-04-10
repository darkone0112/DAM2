package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button tijera,piedra,papel,reset;
    public TextView resultado,tu,maquina;
    public enum gesto{
        piedra,papel,tijera
    }
    public Random rn = new Random();
    gesto gjugador;
    gesto gmaquina;
    public int contador[] = new int [2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tijera = findViewById(R.id.tijera);
        piedra = findViewById(R.id.piedra);
        papel = findViewById(R.id.papel);
        reset = findViewById(R.id.reset);
        resultado = findViewById(R.id.resultado);
        tu = findViewById(R.id.tu);
        maquina = findViewById(R.id.maquina);
        tijera.setOnClickListener(this);
        piedra.setOnClickListener(this);
        papel.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int paso = 0;
        switch (view.getId()){
            case R.id.papel:
                gjugador = gesto.papel;
                break;
            case R.id.piedra:
                gjugador = gesto.piedra;
                break;
            case R.id.tijera:
                gjugador = gesto.tijera;
                break;
            case R.id.reset:
                paso = 1;
                reset();
                break;
        }
        if (paso == 0){
            maquinaJugada();
            compare(gmaquina,gjugador);
        }
        assign();
    }
    public gesto maquinaJugada(){
        int aleatorio = rn.nextInt(3) + 1;
        switch (aleatorio){
            case 1 :
                gmaquina = gesto.piedra;
                break;
            case 2 :
                gmaquina = gesto.papel;
                break;
            case 3 :
                gmaquina = gesto.tijera;
                break;
        }
        return gmaquina;
    }
    public void compare(gesto gmaquina, gesto gjugador){
        String ganas = "";
        if (gjugador == gmaquina){
            ganas = "Empate!!";
        }else{
            if (gjugador == gesto.piedra && gmaquina == gesto.tijera){
                ganas = "Ganas!!";
                contador[0]++;
            }
            if (gjugador == gesto.piedra && gmaquina == gesto.papel){
                ganas = "Pierdes!!";
                contador[1]++;
            }
            if (gjugador == gesto.papel && gmaquina == gesto.piedra){
                ganas = "Ganas!!";
                contador[0]++;
            }
            if (gjugador == gesto.papel && gmaquina == gesto.tijera){
                ganas = "Pierdes!!";
                contador[1]++;
            }
            if (gjugador == gesto.tijera && gmaquina == gesto.papel){
                ganas = "Ganas!!";
                contador[0]++;
            }
            if (gjugador == gesto.tijera && gmaquina == gesto.piedra){
                ganas = "Pierdes!!";
                contador[1]++;
            }
            /*if (ganas.equalsIgnoreCase("ganas!!")){
                resultado.setTextColor(0x008000);
            }else{
                if (ganas.equalsIgnoreCase("pierdes!!")){
                    resultado.setTextColor(0xff0000);
                }else{resultado.setTextColor(0x000000);}
            }*/
        }
        resultado.setText("Has elegido " + gjugador + " la maquina juega " + gmaquina + " " + ganas);
    }
    public void assign(){
        tu.setText(String.valueOf(contador[0]));
        maquina.setText(String.valueOf(contador[1]));
    }
    public void reset(){
        contador[0] = 0;
        contador[1] = 0;
        resultado.setText("Se reinician las puntuaciones!!");
    }
    }