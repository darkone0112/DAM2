package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Data.Bares;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ResultadoHolder> {
    private List<Bares> resultados = new ArrayList<>();
    public interface ItemClickListener {
        void onClick(View v, Bares bar);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ResultadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bar, parent, false);

        return new ResultadoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoHolder holder, int position) {
        Bares bar = resultados.get(position);

        String url = bar.getUrl();
        Pattern pattern = Pattern.compile("/(\\d+)/$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String id = matcher.group(1);
            holder.id.setText(id);
        }
        holder.nombre.setText(bar.getNombre());
        holder.descripcion.setText(bar.getDescripcion());
        holder.apertura.setText(bar.getApertura());
        holder.cierre.setText(bar.getCierre());
        holder.estrellas.setText(String.valueOf(bar.getEstrellas()));
    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    //notificar al recycler view de que hay nueva info
    public void setResults(List<Bares> results) {
        this.resultados.clear();
        this.resultados.addAll(results);
        notifyDataSetChanged();
    }
    class ResultadoHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private TextView id;
        private TextView nombre;
        private TextView descripcion;
        private TextView apertura;
        private TextView cierre;
        private TextView estrellas;

        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onClick(v, resultados.get(getAdapterPosition()));
            }
        }
        public ResultadoHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idBar);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            apertura = itemView.findViewById(R.id.apertura);
            cierre = itemView.findViewById(R.id.cierre);
            estrellas = itemView.findViewById(R.id.estrellas);

            itemView.setOnClickListener(this);
        }

    }
}
