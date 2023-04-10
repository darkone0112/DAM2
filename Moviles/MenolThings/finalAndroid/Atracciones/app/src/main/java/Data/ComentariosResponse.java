package Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComentariosResponse {

    @SerializedName("texto")
    @Expose
    private String textoComentario;

    public String getTextoComentario() {
        return textoComentario;
    }
}
