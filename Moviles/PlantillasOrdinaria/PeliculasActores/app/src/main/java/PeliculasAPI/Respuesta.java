package PeliculasAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Respuesta {
    public Respuesta(String nombre, String descripcion, String estrellas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estrellas = estrellas;
    }
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("estrellas")
    @Expose
    private String estrellas;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public String getUrl() {
        return url;
    }


}
