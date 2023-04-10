package com.example.myapplication.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bares {

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("cierre")
    @Expose
    private String cierre;

    @SerializedName("apertura")
    @Expose
    private String apertura;

    @SerializedName("estrellas")
    @Expose
    private int estrellas;

    public Bares(String nombre, String descripcion, String cierre, String apertura, int estrellas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cierre = cierre;
        this.apertura = apertura;
        this.estrellas = estrellas;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCierre() {
        return cierre;
    }

    public String getApertura() {
        return apertura;
    }

    public int getEstrellas() {
        return estrellas;
    }
}
