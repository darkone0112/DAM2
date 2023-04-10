package Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PageResponse {

    @SerializedName("info")
    @Expose
    private InfoPage infopage;

    @SerializedName("results")
    @Expose
    private List <PersonajeRespuesta> personajeRespuestas;

    public InfoPage getInfopage() {
        return infopage;
    }

    public List<PersonajeRespuesta> getPersonajeRespuestas() {
        return personajeRespuestas;
    }
}
