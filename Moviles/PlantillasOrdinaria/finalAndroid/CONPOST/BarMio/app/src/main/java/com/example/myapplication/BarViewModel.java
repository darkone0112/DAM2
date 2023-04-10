package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Api.BarModel;
import com.example.myapplication.Data.Bares;

import java.util.List;

import retrofit2.Call;

public class BarViewModel extends AndroidViewModel {

    private BarModel barModel;
    private LiveData<List<Bares>>baresLiveData;

    public BarViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        barModel = BarModel.getInstance();
        baresLiveData = barModel.getBaresMutableLiveData();
    }

    public void mostrarTodo(){
        barModel.mostrarTodo();
    }

    public void addBar(Bares bar){
        barModel.addBar(bar);
    }
    public void deleteBar(int id) {
        barModel.deleteBar(id);
    }

    public void filtrarBares(int estrellas){
        barModel.filtrarBares(estrellas);
    }

    public void estrellasBares(int estrellas){
        barModel.estrellasBares(estrellas);
    }
    public LiveData<List<Bares>> getBaresLiveData(){return baresLiveData;}
}
