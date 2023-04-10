package com.example.atracciones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Data.AtraccionesResponse;
import Data.ComentariosInfo;
import Data.ComentariosResponse;

public class ComentariosAdapter extends RecyclerView.Adapter<ComentariosAdapter.ComentariosViewHolder> {

    private List<ComentariosResponse> results = new ArrayList<>();



    @NonNull
    @Override
    public ComentariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comentario, parent, false);
        return new ComentariosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentariosViewHolder holder, int position) {

        //one all
        ComentariosResponse comentarioResponse = results.get(position);

        holder.texto.setText(comentarioResponse.getTextoComentario());


    }

    public List<ComentariosResponse> getResults() {
        return results;
    }

    //Que lo haga Android y el notify rt
    public void setResults(List<ComentariosResponse> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ComentariosViewHolder extends RecyclerView.ViewHolder {

        private TextView texto;

        public ComentariosViewHolder(@NonNull View itemView) {
            super(itemView);

            texto = itemView.findViewById(R.id.STexto);

        }
    }
}