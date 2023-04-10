package com.example.atracciones.Api;

import com.example.atracciones.Data.Atracciones;
import com.example.atracciones.Data.Comentarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BusquedaAtracciones {

    @GET("/pmdm/api/atracciones")
    Call<List<Atracciones>> mostrarTodo();

    @GET("/pmdm/api/atracciones/{id}")
    Call<Comentarios> mostrarComentarios(@Path("id") int id);
}
