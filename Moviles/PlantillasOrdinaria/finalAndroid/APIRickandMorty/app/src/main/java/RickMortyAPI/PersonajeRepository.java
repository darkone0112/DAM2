package RickMortyAPI;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import RickMortyAPI.APIMapear.PaginaRespuesta;
import RickMortyAPI.APIMapear.PersonajesRespuesta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonajeRepository {

    //URL de la API
    private static String URL_BASE = "https://rickandmortyapi.com";

    //Objeto de la Interfaz servicio - MutableLiveData
    private PersonajeService personajeService;
    private MutableLiveData <PaginaRespuesta> respuestaMutableLiveData;
    private MutableLiveData <PersonajesRespuesta> respuestaMutableLiveDataPersonaje;

    public PersonajeRepository() {

        //Instanciamos el objeto mutable
        respuestaMutableLiveData = new MutableLiveData<>();
        respuestaMutableLiveDataPersonaje = new MutableLiveData<>();

        //Utilizando el servicio
        personajeService = new retrofit2.Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PersonajeService.class);

    }

    public void volverPagina(String volverPeticion) {
        personajeService.volverPagina(volverPeticion).enqueue(new Callback<PaginaRespuesta>() {
            @Override
            public void onResponse(Call<PaginaRespuesta> call, Response<PaginaRespuesta> response) {
                if (response.body() != null) {
                    respuestaMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PaginaRespuesta> call, Throwable t) {
                respuestaMutableLiveData.postValue(null);
            }
        });
    }

    public void siguientePagina(String peticionSiguiente) {
        personajeService.siguientePagina(peticionSiguiente).enqueue(new Callback<PaginaRespuesta>() {
            @Override
            public void onResponse(Call<PaginaRespuesta> call, Response<PaginaRespuesta> response) {
                if (response.body() != null) {
                    respuestaMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PaginaRespuesta> call, Throwable t) {
                respuestaMutableLiveData.postValue(null);
            }
        });

    }

    //Método que filtra 1 personaje
    public void buscarPersonaje(String id) {
        personajeService.buscarPersonaje(id).enqueue(new Callback<PersonajesRespuesta>() {
            @Override
            public void onResponse(Call<PersonajesRespuesta> call, Response<PersonajesRespuesta> response) {
                if (response.body() != null) {
                    respuestaMutableLiveDataPersonaje.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PersonajesRespuesta> call, Throwable t) {
                respuestaMutableLiveDataPersonaje.postValue(null);
            }
        });

    }

    //Método que muestra la página
    public void buscarPagina(String page) {
        personajeService.buscarPagina(page).enqueue(new Callback<PaginaRespuesta>() {
            @Override
            public void onResponse(Call<PaginaRespuesta> call, Response<PaginaRespuesta> response) {
                if (response.body() != null) {
                    respuestaMutableLiveData.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<PaginaRespuesta> call, Throwable t) {
                respuestaMutableLiveData.postValue(null);
            }
        });

    }

    //Retorna el Mutable
    public LiveData<PaginaRespuesta> getPaginasRespuestaLiveData () {
        return respuestaMutableLiveData;
    }

    //Retorna el Mutable
    public LiveData<PersonajesRespuesta> getPersonajeRespuestaLiveData () {
        return respuestaMutableLiveDataPersonaje;
    }

}
