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

public class AtraccionesAdapter extends RecyclerView.Adapter<AtraccionesAdapter.AtraccionesViewHolder> {

    private List<AtraccionesResponse> results = new ArrayList<>();
    //Dichoso OnItemClick hay que crear interfaz primero
    private OnItemClickListener mListener;

    @NonNull
    @Override
    public AtraccionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_atraccion, parent, false);
        return new AtraccionesViewHolder(itemView);
    }

    public void setmListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onBindViewHolder(@NonNull AtraccionesViewHolder holder, int position) {

        //one all
        AtraccionesResponse atraccionesResponse = results.get(position);

        holder.url.setText(atraccionesResponse.getUrl());
        holder.nombre.setText(atraccionesResponse.getNombre());
        holder.descripcion.setText(atraccionesResponse.getDescripcion());
        holder.ocupantes.setText(String.valueOf(atraccionesResponse.getOcupantes()));

        //Más OnClick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            }
        });


    }

    public List<AtraccionesResponse> getResults() {
        return results;
    }

    //Que lo haga Android y el notify rt
    public void setResults(List<AtraccionesResponse> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class AtraccionesViewHolder extends RecyclerView.ViewHolder {

        private TextView url, nombre, descripcion, ocupantes;

        public AtraccionesViewHolder(@NonNull View itemView) {
            super(itemView);

            url = itemView.findViewById(R.id.STexto);
            nombre = itemView.findViewById(R.id.SNombre);
            descripcion = itemView.findViewById(R.id.SDescripcion);
            ocupantes = itemView.findViewById(R.id.SOcupantes);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
