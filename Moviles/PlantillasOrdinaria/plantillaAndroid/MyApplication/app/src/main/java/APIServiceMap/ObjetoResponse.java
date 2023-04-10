package APIServiceMap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjetoResponse {
    public ObjetoResponse(String inventado, String urlimg) {
        this.inventado = inventado;
        this.urlimg = urlimg;
    }

    @SerializedName("inventado")
    @Expose
    private String inventado;

    @SerializedName("Imagen")
    @Expose
    private String urlimg;

    public String getInventado() {
        return inventado;
    }

    public String getUrlimg() {
        return urlimg;
    }
}
