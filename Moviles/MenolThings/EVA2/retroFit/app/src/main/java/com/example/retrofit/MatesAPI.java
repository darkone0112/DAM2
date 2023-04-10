package com.example.retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MatesAPI {

    private static String URL_API = "http://192.168.1.46:8000/";

    private static MatesAPI instancia=null;

    MatesServicio service;

    private MatesAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MatesServicio.class);

    }

    public static MatesAPI getInstance(){
        if (instancia == null ) {
            instancia = new MatesAPI();
        }
        return instancia;
    };

    public  Call<Resultado> suma(int n1,int n2) {
        return service.suma(n1,n2);
    }

    public  Call<Resultado> resta(int n1,int n2) {
        return service.resta(n1,n2);
    }

    public  Call<Resultado> multi(int n1,int n2) {
        return service.multi(n1,n2);
    }
    public  Call<Resultado> div(int n1,int n2) {
        return service.div(n1,n2);
    }
}
