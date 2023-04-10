package com.example.final_repaso;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ViewHolder> {

    private ArrayList<Comidas> userComidas;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView descripcion;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nombre = (TextView) view.findViewById(R.id.SNombre);
            descripcion = (TextView) view.findViewById(R.id.SDescripcion);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getDescripcion() {
            return descripcion;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_comida, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {

        viewHolder.getNombre().setText(userComidas.get(position).nombre);
        viewHolder.getDescripcion().setText(userComidas.get(position).descripcion);

    }

    @Override
    public int getItemCount() {
        return userComidas.size();
    }


    public ComidaAdapter (Comidas[] dataSet) {
        userComidas = new ArrayList<Comidas>();
        add(dataSet);

    }

    public void add(Comidas[] dataSet){
        userComidas.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    };




}
