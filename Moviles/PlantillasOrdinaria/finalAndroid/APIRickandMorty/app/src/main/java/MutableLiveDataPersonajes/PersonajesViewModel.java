package MutableLiveDataPersonajes;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import RickMortyAPI.APIMapear.PaginaRespuesta;
import RickMortyAPI.APIMapear.PersonajesRespuesta;
import RickMortyAPI.PersonajeRepository;

public class PersonajesViewModel extends AndroidViewModel {

    private PersonajeRepository personajeRepository;
    private LiveData<PaginaRespuesta> paginaRespuestaLiveData;
    private LiveData<PersonajesRespuesta> personajeRespuestaLiveData;

    //Constructor obligatorio
    public PersonajesViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        personajeRepository = new PersonajeRepository();
        paginaRespuestaLiveData = personajeRepository.getPaginasRespuestaLiveData();
        personajeRespuestaLiveData = personajeRepository.getPersonajeRespuestaLiveData();

    }

    //Métodos que actualizan el Mutable
    public void buscarPersonaje(String id) {
        personajeRepository.buscarPersonaje(id);
    }

    //métodos que actualizan el Mutable
    public void buscarPagina (String page) {
        personajeRepository.buscarPagina(page);
    }

    //Hace nueva petición, siguiente pagina
    public void siguientePagina(String peticionSiguiente) {personajeRepository.siguientePagina(peticionSiguiente);};

    //Hace nueva petición volver a la anterior
    public void volverPagina(String peticionVolver) {personajeRepository.volverPagina(peticionVolver);};

    //Getter
    public LiveData<PaginaRespuesta> getPaginaRespuestaLiveData () {
        return paginaRespuestaLiveData;
    }

    public LiveData<PersonajesRespuesta> getPersonajeRespuestaLiveData() {
        return personajeRespuestaLiveData;
    }

}
