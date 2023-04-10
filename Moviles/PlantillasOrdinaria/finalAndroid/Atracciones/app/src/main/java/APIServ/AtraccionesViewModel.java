package APIServ;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import Data.AtraccionesResponse;
import Data.ComentariosInfo;

public class AtraccionesViewModel extends ViewModel {

    private MutableLiveData <List<AtraccionesResponse>> data;
    private MutableLiveData <ComentariosInfo> dataComentarios;
    private AtraccionesRepository atraccionesRepository;

    public void init() {
        //Singleton
        atraccionesRepository = new AtraccionesRepository().getInstance();
        data = atraccionesRepository.getAtraccionesLiveData();
        dataComentarios = atraccionesRepository.getComentariosLiveData();
    }

    public void mostrarComentarios (String urlComentarios) {
        atraccionesRepository.mostrarComentarios(urlComentarios);
    }

    public void listarAtracciones () {
        atraccionesRepository.listarAtracciones();
    }

    public MutableLiveData<List<AtraccionesResponse>> getData() {
        return data;
    }

    public MutableLiveData <ComentariosInfo> getDataComentarios() {
        return dataComentarios;
    }
}
