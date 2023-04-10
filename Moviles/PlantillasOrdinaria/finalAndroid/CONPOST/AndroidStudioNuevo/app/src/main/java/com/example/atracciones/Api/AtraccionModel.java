package com.example.atracciones.Api;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.atracciones.Data.Atracciones;
import com.example.atracciones.Data.Comentarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtraccionModel {

    private static final String ATRACCION_SEARCH_SERVICE_BASE_URL = "http://192.168.1.164:8000/";

    private BusquedaAtracciones busquedaAtracciones;

    private static  AtraccionModel instancia;

    private MutableLiveData<List<Atracciones>> atraccionesMutableLD;
    private MutableLiveData<Comentarios> comentariosMutableLiveData;
    private AtraccionModel(){
        atraccionesMutableLD = new MutableLiveData<>();
        comentariosMutableLiveData = new MutableLiveData<>();
        busquedaAtracciones = new Retrofit.Builder().
                baseUrl(ATRACCION_SEARCH_SERVICE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BusquedaAtracciones.class);
    }

    public  static AtraccionModel getInstance(){
        if(instancia==null){
            instancia = new AtraccionModel();
        }
        return instancia;
    }

    public void mostrarTodo(){
        busquedaAtracciones.mostrarTodo()
                .enqueue(new Callback<List<Atracciones>>() {
                    @Override
                    public void onResponse(Call<List<Atracciones>> call, Response<List<Atracciones>> response) {
                        List<Atracciones> listadoBares = response.body();
                        atraccionesMutableLD.postValue(listadoBares);
                    }

                    @Override
                    public void onFailure(Call<List<Atracciones>> call, Throwable t) {

                    }
                });
    }

    public void mostrarComentarios(int id){
        busquedaAtracciones.mostrarComentarios(id)
                .enqueue(new Callback<Comentarios>() {
                    @Override
                    public void onResponse(Call<Comentarios> call, Response<Comentarios> response) {
                        comentariosMutableLiveData.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Comentarios> call, Throwable t) {

                    }
                });
    }

    public LiveData<List<Atracciones>> getAtraccionesMutableLiveData(){return atraccionesMutableLD;}
    public LiveData<Comentarios> getComentariosMutableLiveData(){return comentariosMutableLiveData;}

}
