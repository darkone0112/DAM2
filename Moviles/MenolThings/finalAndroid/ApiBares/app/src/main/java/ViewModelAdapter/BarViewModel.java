package ViewModelAdapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ApiBares.BarMap.ReseñasResponse;
import ApiBares.BarRepository;

//RECORDAR IMPORTANTE EXTENDER VIEWMODEL EXTENDER VIEWMODEL
public class BarViewModel extends ViewModel {
    private MutableLiveData <List<ReseñasResponse>> data;
    private BarRepository barRepository;

    public void init() {
        //Singleton maravilloso
        barRepository = new BarRepository().getInstance();
        data = barRepository.getBarLiveData();
    }

    public void listarReseñas () {
        barRepository.listarReseña();
    }

    public void filtrarEstrella (int estrella) {
        barRepository.filtrarEstrella(estrella);
    }

    public MutableLiveData<List<ReseñasResponse>> getData() {
        return data;
    }

}
