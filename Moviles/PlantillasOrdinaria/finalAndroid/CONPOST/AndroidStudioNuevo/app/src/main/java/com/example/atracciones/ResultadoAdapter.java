package com.example.atracciones;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atracciones.Comentarios.ListadoComentarios;
import com.example.atracciones.Data.Atracciones;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ResultadoHolder> {
    private List<Atracciones> resultados = new ArrayList<>();
    public interface ItemClickListener {
        void onClick(View v, Atracciones atracciones);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ResultadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.atraccion, parent, false);

        return new ResultadoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoHolder holder, int position) {
        Atracciones atracciones = resultados.get(position);

        String url = atracciones.getUrl();
        Pattern pattern = Pattern.compile("/(\\d+)/$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String id = matcher.group(1);
            holder.id.setText(id);
        }
        holder.nombre.setText(atracciones.getNombre());
        holder.descripcion.setText(atracciones.getDescripcion());
        holder.ocupantes.setText(atracciones.getOcupantes());
    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    //notificar al recycler view de que hay nueva info
    public void setResults(List<Atracciones> results) {
        this.resultados.clear();
        this.resultados.addAll(results);
        notifyDataSetChanged();
    }

    class ResultadoHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private TextView id;
        private TextView nombre;
        private TextView descripcion;
        private TextView ocupantes;

        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onClick(v, resultados.get(getAdapterPosition()));
            }
            Atracciones atracciones = resultados.get(getAdapterPosition());
            Intent intent = new Intent(v.getContext(), ListadoComentarios.class);
            String url = atracciones.getUrl();
            Pattern pattern = Pattern.compile("/(\\d+)/$");
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                String id = matcher.group(1);
                intent.putExtra("datos", id);
            }
            v.getContext().startActivity(intent);
        }
        public ResultadoHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idAtraccion);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            ocupantes = itemView.findViewById(R.id.ocupantes);

            itemView.setOnClickListener(this);
        }

    }
}
