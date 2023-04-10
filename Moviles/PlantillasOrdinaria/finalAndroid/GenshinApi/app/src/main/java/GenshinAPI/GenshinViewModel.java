package GenshinAPI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;


public class GenshinViewModel extends ViewModel {

    private MutableLiveData <List<String>> data;
    private MutableLiveData <InfoPersonaje> dataPersonaje;
    private GenshinRepository genshinRepository;

    public void init() {
        genshinRepository = new GenshinRepository().getInstance();
        data = genshinRepository.getpRMutableLiveData();
        dataPersonaje = genshinRepository.getInfoPLiveData();
    }

    public void mostrarPersonajes() {
        genshinRepository.mostrarPersonajes();
    }

    public void mostrarDetalle(String nombre) { genshinRepository.mostrarDetalle(nombre);}

    public MutableLiveData <List<String>> getData() {
        return data;
    }

    public MutableLiveData<InfoPersonaje> getDataPersonaje() {
        return dataPersonaje;
    }
}
