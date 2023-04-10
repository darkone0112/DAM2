package GenshinAPI;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class GenshinRepository {

    private final String API_URL = "https://api.genshin.dev";
    private GenshinRepository instance;
    private MutableLiveData <List<String>> pRMutableLiveData;
    private MutableLiveData <InfoPersonaje> infoPLiveData;
    private List<String> respuesta;
    private GenshinService service;

    public GenshinRepository () {
        pRMutableLiveData = new MutableLiveData<>();
        infoPLiveData = new MutableLiveData<>();

        service = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GenshinService.class);
    }

    //Singleton
    public GenshinRepository getInstance() {
        if (instance == null) {
            instance = new GenshinRepository();
        }
        return instance;
    }

    //Métodos que hacen peticiones
    public void mostrarPersonajes() {
        service.mostrarPersonajes().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                respuesta = response.body();
                pRMutableLiveData.postValue(respuesta);
            }
            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }

    public void mostrarDetalle(String nombre) {
        service.mostrarDetalle(nombre).enqueue(new Callback<InfoPersonaje>() {
            @Override
            public void onResponse(Call<InfoPersonaje> call, Response<InfoPersonaje> response) {
                infoPLiveData.postValue(response.body());
            }
            @Override
            public void onFailure(Call<InfoPersonaje> call, Throwable t) {
                //olla olla
            }
        });
    }

    public MutableLiveData<InfoPersonaje> getInfoPLiveData() {
        return infoPLiveData;
    }

    public MutableLiveData<List<String>> getpRMutableLiveData() {
        return pRMutableLiveData;
    }
}
