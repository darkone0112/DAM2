package com.example.atracciones.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comentarios {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("comentarios")
    @Expose
    private List<Comentario> comentario;

    public String getUrl() {
        return url;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }
}
