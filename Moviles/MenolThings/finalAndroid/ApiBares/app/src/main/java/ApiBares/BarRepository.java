package ApiBares;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ApiBares.BarMap.ReseñasResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarRepository {

    private final String API_URL = "http://192.168.1.54:8888";
    private BarRepository instance;
    MutableLiveData <List<ReseñasResponse>> barLiveData;

    List<ReseñasResponse> respuesta;
    BarService barService;

    //Constructor
    public BarRepository() {
        barLiveData = new MutableLiveData<>();

        barService = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BarService.class);

    }

    //Devuelve objeto singleton
    public BarRepository getInstance() {
        if (instance == null) {
            instance = new BarRepository();
        }
        return instance;
    }

    public void listarReseña() {
        barService.listarReseña().enqueue(new Callback<List<ReseñasResponse>>() {
            @Override
            public void onResponse(Call<List<ReseñasResponse>> call, Response<List<ReseñasResponse>> response) {
                //Recibe y transforma el JSOn
                respuesta = response.body();
                barLiveData.postValue(respuesta);

            }
            @Override
            public void onFailure(Call<List<ReseñasResponse>> call, Throwable t) {
                respuesta = new ArrayList<>();
                barLiveData.postValue(respuesta);
            }
        });
    }

    public void filtrarEstrella (int estrella) {
        barService.filtrarEstrella(estrella).enqueue(new Callback<List<ReseñasResponse>>() {
            @Override
            public void onResponse(Call<List<ReseñasResponse>> call, Response<List<ReseñasResponse>> response) {
                respuesta = response.body();
                barLiveData.postValue(respuesta);
            }
            @Override
            public void onFailure(Call<List<ReseñasResponse>> call, Throwable t) {
                respuesta = new ArrayList<>();
                barLiveData.postValue(respuesta);
            }
        });
    }

    public MutableLiveData<List<ReseñasResponse>> getBarLiveData() {
        return barLiveData;
    }
}
