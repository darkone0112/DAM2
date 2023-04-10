package com.example.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AleatorioViewModel extends ViewModel {

    MutableLiveData<Integer> datosObserver;
    ModelAleatorio datos;

    public LiveData <Integer> getDatosAleatorios() {
        if (datosObserver == null) {
            datosObserver = new MutableLiveData<Integer>();

            //genera simulacion de Modelo servidor
            datos = new ModelAleatorio();

            //generarALeatorio();
        }

        return datosObserver;
    }

    public void nuevoAleatorio() {
        // Actividad Asincrona - lambda god
        new Thread(() -> {

            //Peticion a servidor remoto
            datos.generarAleatorio();

            //Notifica la llegada del dato
            datosObserver.postValue(datos.getAleatorio());

        }).start();
    }

}
