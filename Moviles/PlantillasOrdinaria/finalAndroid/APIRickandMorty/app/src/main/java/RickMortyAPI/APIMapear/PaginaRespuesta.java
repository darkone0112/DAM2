package RickMortyAPI.APIMapear;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaginaRespuesta {

    //Devuelve info de las paginas
    @SerializedName("info")
    @Expose
    InfoPage infopage;

    //Devuelve personajes de la página actual
    @SerializedName("results")
    @Expose
    List<PersonajesRespuesta> personajesRespuestas;

    public InfoPage getInfopage() {
        return infopage;
    }

    public List<PersonajesRespuesta> getPersonajesRespuestas() {
        return personajesRespuestas;
    }
}
