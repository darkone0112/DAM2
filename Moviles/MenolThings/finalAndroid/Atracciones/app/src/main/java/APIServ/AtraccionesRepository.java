package APIServ;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import Data.AtraccionesResponse;
import Data.AtraccionesService;
import Data.ComentariosInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtraccionesRepository {

    private final String API_URL = "http://192.168.1.54:8888";
    private AtraccionesRepository instance;

    //No olvidar esta vaina mmg
    MutableLiveData <List<AtraccionesResponse>> atraccionesLiveData;
    MutableLiveData <ComentariosInfo> comentariosLiveData;
    List <AtraccionesResponse> respuesta;

    AtraccionesService service;

    //Singleton
    public AtraccionesRepository getInstance() {
        if (instance == null) {
            instance = new AtraccionesRepository();
        }
        return instance;
    }

    //Constructor
    public AtraccionesRepository () {
        atraccionesLiveData = new MutableLiveData<>();
        comentariosLiveData = new MutableLiveData<>();

        service = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AtraccionesService.class);

    }

    public void mostrarComentarios (String urlComentario) {
        service.mostrarComentarios(urlComentario).enqueue(new Callback<ComentariosInfo>() {
            @Override
            public void onResponse(Call<ComentariosInfo> call, Response<ComentariosInfo> response) {
                comentariosLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ComentariosInfo> call, Throwable t) {
                comentariosLiveData.postValue(null);
            }
        });
    }


    public void listarAtracciones() {
        service.listarAtracciones().enqueue(new Callback<List<AtraccionesResponse>>() {
            @Override
            public void onResponse(Call<List<AtraccionesResponse>> call, Response<List<AtraccionesResponse>> response) {
                respuesta = response.body();
                atraccionesLiveData.postValue(respuesta);
            }

            @Override
            public void onFailure(Call<List<AtraccionesResponse>> call, Throwable t) {
                respuesta = new ArrayList<>();
                atraccionesLiveData.postValue(respuesta);
            }
        });
    }

    //No olvidar el get
    public MutableLiveData<List<AtraccionesResponse>> getAtraccionesLiveData() {
        return atraccionesLiveData;
    }

    public MutableLiveData<ComentariosInfo> getComentariosLiveData() {
        return comentariosLiveData;
    }
}
