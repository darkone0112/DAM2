package Service;

import androidx.lifecycle.MutableLiveData;

import Data.PageResponse;
import Data.PersonajeRespuesta;

public class RickAndMortyRepository {

    private final String URL_API = "https://rickandmortyapi.com";
    private RickAndMortyRepository instance;

    private MutableLiveData <PageResponse> pageResponseMutableLiveData;
    private MutableLiveData <PersonajeRespuesta> personajeRespuestaMutableLiveData;

    //Singleton
    public RickAndMortyRepository getInstance() {



        return instance;
    }





}
