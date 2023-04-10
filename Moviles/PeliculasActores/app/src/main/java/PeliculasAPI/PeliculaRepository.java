package PeliculasAPI;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculaRepository {

    private final String API_URL = "http://51.77.156.235:3322";
    private PeliculaRepository instance;
    private MutableLiveData <List<Respuesta>> pRMutableLiveData;
    private MutableLiveData <InfoPelicula> infoPLiveData;
    private List<Respuesta> respuesta;
    private PeliculaService service;

    public PeliculaRepository () {
        pRMutableLiveData = new MutableLiveData<>();
        infoPLiveData = new MutableLiveData<>();

        service = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PeliculaService.class);
    }

    //Singleton
    public PeliculaRepository getInstance() {
        if (instance == null) {
            instance = new PeliculaRepository();
        }
        return instance;
    }



    public void mostrarDescripcion(String nombre) {
        service.mostrarDescripcion(nombre).enqueue(new Callback<InfoPelicula>() {
            @Override
            public void onResponse(Call<InfoPelicula> call, Response<InfoPelicula> response) {
                infoPLiveData.postValue(response.body());
            }
            @Override
            public void onFailure(Call<InfoPelicula> call, Throwable t) {
                //olla olla
            }
        });
    }

    //Métodos que hacen peticiones
    public void mostrarPelicula() {
        service.mostrarPelicula().enqueue(new Callback<List<Respuesta>>() {
            @Override
            public void onResponse(Call<List<Respuesta>> call, Response<List<Respuesta>> response) {
                respuesta = response.body();
                pRMutableLiveData.postValue(respuesta);
            }
            @Override
            public void onFailure(Call<List<Respuesta>> call, Throwable t) {
            }
        });
    }
    public MutableLiveData<InfoPelicula> getInfoPLiveData() {
        return infoPLiveData;
    }

    public MutableLiveData<List<Respuesta>> getpRMutableLiveData() {
        return pRMutableLiveData;
    }
}
