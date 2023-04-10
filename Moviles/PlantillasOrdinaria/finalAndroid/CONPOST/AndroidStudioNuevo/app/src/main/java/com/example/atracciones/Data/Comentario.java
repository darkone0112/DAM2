package com.example.atracciones.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comentario {
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("texto")
    @Expose
    private String texto;

    public String getUrl() {
        return url;
    }

    public String getTexto() {
        return texto;
    }
}
