package com.example.proyecto_global;

import android.view.View;

public class manoElegida {
    // TIJERA 1,
    // PAPEL 2
    // PIEDRA 3
    int maquina;
    int manoRival,vencedor,contJugador,contMaquina = 0;

    //Método que genera mano utilizada
    public void manoMaquina() {
        switch (maquina = (int)(1+Math.random()*3)) {
            case 1:
                manoRival=1;
                break;
            case 2:
                manoRival=2;
                break;
            case 3:
                manoRival=3;
                break;
        }
    }

    public void manoTijera () {
        manoMaquina();
        switch (maquina) {
            case 1:
                vencedor=0; contJugador++; contMaquina++;
                break;
            case 2:
                vencedor=1; contJugador++;
                break;
            case 3:
                vencedor=2; contMaquina++;
                break;
        }
    }

    public void manoPapel () {
        manoMaquina();
        switch (maquina) {
            case 1:
                vencedor=2; contMaquina++;
                break;
            case 2:
                vencedor=0; contJugador++; contMaquina++;
                break;
            case 3:
                vencedor=1; contJugador++;
                break;
        }
    }

    public void manoPiedra () {
        manoMaquina();
        switch (maquina) {
            case 1:
                vencedor=1; contJugador++;
                break;
            case 2:
                vencedor=2; contMaquina++;
                break;
            case 3:
                vencedor=0; contJugador++; contMaquina++;
                break;
        }
    }

    public void manoChill () {
        vencedor=3;
         manoRival = contJugador = contMaquina=0;
    }

    public int getContJugador() {
        return contJugador;
    }

    public int getContMaquina () {
        return contMaquina;
    }

    public int getVencedor () {
        return vencedor;
    }

    public int getManoRival() {
        return manoRival;
    }

}





