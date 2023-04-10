package Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComentariosInfo {

    @SerializedName("url")
    @Expose
    private String urlComentario;

    @SerializedName("comentarios")
    @Expose
    private List<ComentariosResponse> comenariosResponse;

    @SerializedName("nombre")
    @Expose
    private String nombreSitio;

    @SerializedName("descripcion")
    @Expose
    private String comentarioSitio;

    @SerializedName("ocupantes")
    @Expose
    private int comentariosOcupantes;

    public String getUrlComentario() {
        return urlComentario;
    }

    public List<ComentariosResponse> getComenariosResponse() {
        return comenariosResponse;
    }

    public String getNombreSitio() {
        return nombreSitio;
    }

    public String getComentarioSitio() {
        return comentarioSitio;
    }

    public int getComentariosOcupantes() {
        return comentariosOcupantes;
    }
}
