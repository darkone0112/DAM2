package com.example.myapplication.Api;

import com.example.myapplication.Data.Bares;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BusquedaBares {

    @GET("/pmdm/api/bares")
    Call <List<Bares>> mostrarTodo();

    @POST("pmdm/api/bares/")
    Call <Bares> addBar(@Body Bares bar);

    @DELETE("pmdm/api/bares/{id}/")
    Call <Void> deleteBar(@Path("id") int id);

    //este metodo nos devuelve todos los bares pero le mandamos un entero con estrellas para luego filtrar en el Model
    @GET("/pmdm/api/bares")
    Call <List<Bares>> filtrarBares(@Query("estrellas__gte")int estrellas);
    //Este metodo solo devuelve los bares con el numero de estrellas introducidos
    @GET("/pmdm/api/bares")
    Call <List<Bares>> barEstrellas(@Query("estrellas")int estrellas);
}
