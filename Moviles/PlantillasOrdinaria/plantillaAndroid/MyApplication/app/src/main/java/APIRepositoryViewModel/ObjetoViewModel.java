package APIRepositoryViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import APIServiceMap.ObjetoResponse;

public class ObjetoViewModel extends ViewModel {

    private MutableLiveData <List<ObjetoResponse>> data;
    private MutableLiveData <ObjetoResponse> dataDetalle;
    private ObjetoRepository objetoRepository;

    public void init() {
        objetoRepository = new ObjetoRepository().getIntance();
        data = objetoRepository.getoPMutableLiveData();
        dataDetalle = objetoRepository.getoPMutableLiveDataDetalle();
    }

    public void mostrarDetalle(int valor, String nombre) {
        objetoRepository.mostrarDetalle(nombre, valor);
    }

    public void addObjeto (ObjetoResponse objetoResponse) {
        objetoRepository.addObjeto(objetoResponse);
    }

    public void deleteBar (int id) {
        objetoRepository.deleteBar(id);
    }

    public void listarObjetos () {
        objetoRepository.listarObjetos();
    }

    public MutableLiveData<List<ObjetoResponse>> getData() {
        return data;
    }

    public MutableLiveData<ObjetoResponse> getDataDetalle() {
        return dataDetalle;
    }
}
