package com.example.livedata;


import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrimosViewModel extends ViewModel {

    MutableLiveData<Integer> datosObserver;
    ModelPrimo datos;
    EditText et1,et2;
    public LiveData <Integer> getPrimos() {
        if (datosObserver == null) {
            datosObserver = new MutableLiveData<Integer>();

            //genera simulacion de Modelo servidor
            datos = new ModelPrimo();

            //generarALeatorio();
        }

        return datosObserver;
    }

    public void nuevoPrimo() {
        // Actividad Asincrona - lambda god
        new Thread(() -> {

            //Peticion a servidor remoto


            //Notifica la llegada del dato
            datosObserver.postValue(datos.calcularPrimo(Integer.parseInt(et1+""),Integer.parseInt(et2+"")));


        }).start();
    }

}