package RickMortyAPI.APIMapear;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Clase utilizada para recibir objetos de la petición JSON (origen)
public class Origin {

    //Obtiene la url de los personajes origen de este planeta
    @SerializedName("url")
    @Expose
    private String urlOrigen;

    //Obtiene el nombre del planeta origen
    @SerializedName("name")
    @Expose
    private String nameOrigen;

    public String getUrlOrigen() {
        return urlOrigen;
    }

    public String getNameOrigen() {
        return nameOrigen;
    }
}
