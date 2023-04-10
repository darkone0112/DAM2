package com.example.atracciones.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Atracciones {

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("ocupantes")
    @Expose
    private String ocupantes;

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getOcupantes() {
        return ocupantes;
    }
}
