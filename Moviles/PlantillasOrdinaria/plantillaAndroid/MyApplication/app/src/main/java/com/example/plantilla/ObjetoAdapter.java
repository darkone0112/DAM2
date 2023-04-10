package com.example.plantilla;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import APIServiceMap.ObjetoResponse;

public class ObjetoAdapter extends RecyclerView.Adapter<ObjetoAdapter.ObjetoAdapterResultHolder>{
    private List<ObjetoResponse> results = new ArrayList<>();
    private onItemClickListener mListener;

    public void setmListener(onItemClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ObjetoAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_objeto, parent, false);
        return new ObjetoAdapterResultHolder(itemView);
    }

    public void setResults(List<ObjetoResponse> results) {
        this.results = results;
    }

    @Override
    public void onBindViewHolder(@NonNull ObjetoAdapterResultHolder holder, int position) {

        //holder.nombreObjeto.setText(results.get(position).getInventado())

        String imgURL = "https://api.genshin.dev/characters/icon";

        Glide.with(holder.itemView)
                .load(imgURL)
                .into(holder.imagePersonaje);


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

    public List<ObjetoResponse> getResults() {
        return results;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ObjetoAdapterResultHolder extends RecyclerView.ViewHolder {

        //Obtener ID de los elementos del layout aqui
        //private TextView nombreObjeto;
        //private ImageView imagenObjeto;

        public ObjetoAdapterResultHolder(@NonNull View itemView) {
            super(itemView);
            //nombreObjeto = itemView.findViewById(R.id.ENombreObjeto);
            //imgObjeto = itemView.findViewById(R.id.EImageObjeto);
        }
    }

    public interface onItemClickListener{
        void onItemClick(int position);
    }

}
