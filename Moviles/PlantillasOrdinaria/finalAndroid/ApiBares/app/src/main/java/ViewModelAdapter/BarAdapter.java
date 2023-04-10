package ViewModelAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apibares.R;

import java.util.ArrayList;
import java.util.List;

import ApiBares.BarMap.ReseñasResponse;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.BarViewHolder>{

    private List<ReseñasResponse> results = new ArrayList<>();


    //Obtienes Los id, la row, es muy nazi pero funciona
    @NonNull
    @Override
    public BarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_resenas, parent, false);
        return new BarViewHolder(itemView);
    }

    //Llenado de la felicidad
    public void setResults(List<ReseñasResponse> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    //La chicha, recibe el onclick y más pollas
    @Override
    public void onBindViewHolder(@NonNull BarViewHolder holder, int position) {

        //de chill
        ReseñasResponse reseñaRespuesta = results.get(position);

        holder.url.setText(reseñaRespuesta.getUrl());
        holder.nombre.setText(reseñaRespuesta.getNombre());
        holder.descripcion.setText(reseñaRespuesta.getDescripcion());
        holder.cierre.setText(reseñaRespuesta.getCierre());
        holder.apertura.setText(reseñaRespuesta.getApertura());
        holder.estrellas.setText(String.valueOf(reseñaRespuesta.getEstrellas()));


    }

    //Devuelve la cantidad de items
    @Override
    public int getItemCount() {
        return results.size();
    }

    class BarViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, url, descripcion, cierre, apertura, estrellas;

        public BarViewHolder(@NonNull View itemView) {
            super(itemView);

            url = itemView.findViewById(R.id.Surl);
            nombre = itemView.findViewById(R.id.SNombre);
            descripcion = itemView.findViewById(R.id.SDescripcion);
            cierre = itemView.findViewById(R.id.SCierre);
            apertura = itemView.findViewById(R.id.SApertura);
            estrellas = itemView.findViewById(R.id.SEstrellas);

        }


    }


}
