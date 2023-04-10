package PeliculasAPI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculasactores.DetallePelicula;
import com.example.peliculasactores.R;

import java.util.ArrayList;
import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaAdapterResultHolder> {

    private List<Respuesta> results = new ArrayList<>();
    private onItemClickListener mListener;
    private Context mContext;


    public PeliculaAdapter(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public PeliculaAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_row_pelicula, parent, false);
        return new PeliculaAdapterResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaAdapter.PeliculaAdapterResultHolder holder, int position) {

            Respuesta respuesta = results.get(position);
            holder.nEstrellas.setText(respuesta.getEstrellas());
            holder.nombrePelicula.setText(respuesta.getNombre());
            holder.descPelicula.setText(respuesta.getDescripcion());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        System.out.println("Click en " + respuesta.getUrl());
                        Intent intent = new Intent(mContext, DetallePelicula.class);
                        intent.putExtra("url", respuesta.getUrl());
                        mContext.startActivity(intent);
                    }
                }
            });

    }

    public void setmListener(onItemClickListener mListener) {
        this.mListener = mListener;
    }

    public List<Respuesta> getResults() {
        return results;
    }

    public void setResults(List<Respuesta> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class PeliculaAdapterResultHolder extends RecyclerView.ViewHolder {
        private TextView nEstrellas;
        private TextView nombrePelicula;
        private TextView descPelicula;

        public PeliculaAdapterResultHolder(@NonNull View itemView) {
            super(itemView);

            nEstrellas = itemView.findViewById(R.id.nEstrellas);
            nombrePelicula = itemView.findViewById(R.id.nombrePelicula);
            descPelicula = itemView.findViewById(R.id.descPelicula);
        }
    }

    public interface onItemClickListener{
        void onItemClick(int position);
    }

}

