package com.example.myapplication.Api;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Data.Bares;
import com.example.myapplication.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarModel {

    private static final String BAR_SEARCH_SERVICE_BASE_URL = "http://192.168.1.164:8000/";

    private BusquedaBares busquedaBares;

    private  static  BarModel instancia;

    private MutableLiveData<List<Bares>> baresMutableLiveData;

    private BarModel(){
        baresMutableLiveData = new MutableLiveData<>();
        busquedaBares = new Retrofit.Builder().
                baseUrl(BAR_SEARCH_SERVICE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BusquedaBares.class);
    }

    public  static BarModel getInstance(){
        if(instancia==null){
            instancia = new BarModel();
        }
        return instancia;
    }

    public void mostrarTodo(){
        busquedaBares.mostrarTodo()
                .enqueue(new Callback<List<Bares>>() {
                    @Override
                    public void onResponse(Call<List<Bares>> call, Response<List<Bares>> response) {
                        List<Bares> listadoBares = response.body();
                        baresMutableLiveData.postValue(listadoBares);
                    }

                    @Override
                    public void onFailure(Call<List<Bares>> call, Throwable t) {

                    }
                });
    }

    public void addBar(Bares bar){
        busquedaBares.addBar(bar)
                .enqueue(new Callback<Bares>() {
                    @Override
                    public void onResponse(Call<Bares> call, Response<Bares> response) {
                        if (response.isSuccessful()) {
                            // handle success
                        } else {
                            // handle error
                        }
                    }

                    @Override
                    public void onFailure(Call<Bares> call, Throwable t) {}
                });
    }

    public void deleteBar(int id) {
        busquedaBares.deleteBar(id)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                    }
                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                    }
                });
    }

    public void filtrarBares(int estrellas){
        busquedaBares.filtrarBares(estrellas)
                .enqueue(new Callback<List<Bares>>() {
                    @Override
                    public void onResponse(Call<List<Bares>> call, Response<List<Bares>> response) {
                        List<Bares> listadoBares = response.body();
                        List<Bares> listadoBaresFiltrado = new ArrayList<>();

                        for (Bares bar: listadoBares) {
                            if(bar.getEstrellas()>=estrellas){
                                listadoBaresFiltrado.add(bar);
                            }
                        }

                        baresMutableLiveData.postValue(listadoBaresFiltrado);
                    }

                    @Override
                    public void onFailure(Call<List<Bares>> call, Throwable t) {

                    }
                });
    }

    public void estrellasBares(int estrellas){
        busquedaBares.barEstrellas(estrellas)
                .enqueue(new Callback<List<Bares>>() {
                    @Override
                    public void onResponse(Call<List<Bares>> call, Response<List<Bares>> response) {
                        List<Bares> listadoBares = response.body();
                        baresMutableLiveData.postValue(listadoBares);
                    }

                    @Override
                    public void onFailure(Call<List<Bares>> call, Throwable t) {

                    }
                });
    }
    public LiveData<List<Bares>> getBaresMutableLiveData(){return baresMutableLiveData;}
}
