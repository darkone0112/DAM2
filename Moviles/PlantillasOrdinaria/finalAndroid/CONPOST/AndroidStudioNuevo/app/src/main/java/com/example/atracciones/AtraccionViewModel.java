package com.example.atracciones;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.atracciones.Api.AtraccionModel;
import com.example.atracciones.Data.Atracciones;
import com.example.atracciones.Data.Comentarios;

import java.util.List;

public class AtraccionViewModel extends AndroidViewModel {

    private AtraccionModel atraccionModel;
    private LiveData<List<Atracciones>> atraccionesLiveData;

    private LiveData<Comentarios> comentariosLiveData;

    public AtraccionViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        atraccionModel = AtraccionModel.getInstance();
        comentariosLiveData = atraccionModel.getComentariosMutableLiveData();
        atraccionesLiveData = atraccionModel.getAtraccionesMutableLiveData();
    }

    public void mostrarTodo(){
        atraccionModel.mostrarTodo();
    }
    public void mostrarComentarios(int id){
        atraccionModel.mostrarComentarios(id);
    }
    public LiveData<List<Atracciones>> getAtraccionesLiveData(){return atraccionesLiveData;}
    public LiveData<Comentarios> getComentariosLiveData(){return comentariosLiveData;}

}
