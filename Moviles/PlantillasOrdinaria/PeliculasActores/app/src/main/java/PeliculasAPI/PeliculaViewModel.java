package PeliculasAPI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;


public class PeliculaViewModel extends ViewModel {

    private MutableLiveData<List<Respuesta>> data;
    private MutableLiveData <InfoPelicula> dataPelicula;
    private PeliculaRepository PeliculaRepository;

    public void init() {
        PeliculaRepository = new PeliculaRepository().getInstance();
        data = PeliculaRepository.getpRMutableLiveData();
        dataPelicula = PeliculaRepository.getInfoPLiveData();
    }

    public void mostrarPelicula() {
        PeliculaRepository.mostrarPelicula();
    }

    public void mostrarDetalle(String nombre) { PeliculaRepository.mostrarDescripcion(nombre);}

    public MutableLiveData <List<Respuesta>> getData() {
        return data;
    }

    public MutableLiveData<InfoPelicula> getDataPelicula() {
        return dataPelicula;
    }
}
