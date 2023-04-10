package com.example.atracciones.Comentarios;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atracciones.Data.Comentario;
import com.example.atracciones.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdaptadorComentarios extends RecyclerView.Adapter<AdaptadorComentarios.ComentarioHolder> {
    private List<Comentario> resultados = new ArrayList<>();
    public interface ItemClickListener {
        void onClick(View v, Comentario comentario);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ComentarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comentarios, parent, false);

        return new ComentarioHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentarioHolder holder, int position) {
        Comentario comentarios = resultados.get(position);

        String url = comentarios.getUrl();
        Pattern pattern = Pattern.compile("/(\\d+)/$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String id = matcher.group(1);
            holder.id.setText(id);
        }
        holder.texto.setText(comentarios.getTexto());
    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    //notificar al recycler view de que hay nueva info
    public void setResults(List<Comentario> results) {
        this.resultados.clear();
        this.resultados.addAll(results);
        notifyDataSetChanged();
    }
    class ComentarioHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private TextView id;
        private TextView texto;
        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onClick(v, resultados.get(getAdapterPosition()));
            }
        }
        public ComentarioHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idComentario);
            texto = itemView.findViewById(R.id.texto);

            itemView.setOnClickListener(this);
        }

    }
}
