package APIRepositoryViewModel;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import APIServiceMap.ObjetoResponse;
import APIServiceMap.PlantillaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class ObjetoRepository {

    private final String URL_API = "https://api.inventada.dev";
    private ObjetoRepository instance;
    private MutableLiveData <List<ObjetoResponse>> oPMutableLiveData;
    private MutableLiveData <ObjetoResponse> oPMutableLiveDataDetalle;
    private  List<ObjetoResponse> respuesta;
    private PlantillaService service;

    //Singleton
    public ObjetoRepository getIntance() {
        if (instance == null) {
            instance = new ObjetoRepository();
        }
        return instance;
    }

    public void mostrarDetalle(String nombre, int valor) {
        service.mostrarDetalle(valor,nombre).enqueue(new Callback<ObjetoResponse>() {
            @Override
            public void onResponse(Call<ObjetoResponse> call, Response<ObjetoResponse> response) {
                oPMutableLiveDataDetalle.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ObjetoResponse> call, Throwable t) {
                oPMutableLiveDataDetalle.postValue(null);
            }
        });
    }

    //Constructor
    public ObjetoRepository() {
        oPMutableLiveData = new MutableLiveData<>();
        oPMutableLiveDataDetalle = new MutableLiveData<>();

        service = new retrofit2.Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PlantillaService.class);

    }

    public void listarObjetos() {
        service.listarObjetos().enqueue(new Callback<List<ObjetoResponse>>() {
            @Override
            public void onResponse(Call<List<ObjetoResponse>> call, Response<List<ObjetoResponse>> response) {
                respuesta = response.body();
                oPMutableLiveData.postValue(respuesta);
            }
            @Override
            public void onFailure(Call<List<ObjetoResponse>> call, Throwable t) {
                respuesta = new ArrayList<>();
                oPMutableLiveData.postValue(respuesta);
            }
        });
    }

    //Añade nuevo objeto con post
    public void addObjeto (ObjetoResponse objetoResponse) {
        service.addObjeto(objetoResponse).enqueue(new Callback<ObjetoResponse>() {
            @Override
            public void onResponse(Call<ObjetoResponse> call, Response<ObjetoResponse> response) {

            }

            @Override
            public void onFailure(Call<ObjetoResponse> call, Throwable t) {

            }
        });
    }

    //eliminar bar
    public void deleteBar(int id) {
        service.deleteBar(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    //Retorna el MutableLiveData
    public MutableLiveData<List<ObjetoResponse>> getoPMutableLiveData() {
        return oPMutableLiveData;
    }

    public MutableLiveData<ObjetoResponse> getoPMutableLiveDataDetalle() {
        return oPMutableLiveDataDetalle;
    }
}
