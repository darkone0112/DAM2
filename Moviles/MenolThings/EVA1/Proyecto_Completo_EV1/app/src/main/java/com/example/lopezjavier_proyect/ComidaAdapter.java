package com.example.lopezjavier_proyect;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ViewHolder> {

    //ArrayList que almacena los objetos Comidas
    private List<ComidasBas> userComidas;
    private static RecyclerViewClickListener listener;

    //Constructor que recibe ArrayList de comidas --- IMPORTAAAAANTE ---
    public ComidaAdapter (List<ComidasBas> comidas, RecyclerViewClickListener listener) {
        this.userComidas=comidas;
        this.listener=listener;
    }

    //Metodo ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nombre;
        private final TextView descripcion;
        private final ImageView imgcomida;
        public ViewHolder(View view) {
            super(view);
                view.setOnClickListener(this);
                //Extrae el id para su tratamiento
                nombre = (TextView) view.findViewById(R.id.SNombreClick);
                descripcion = (TextView) view.findViewById(R.id.SDescripcionClick);
                imgcomida = (ImageView) view.findViewById(R.id.SImageView);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getDescripcion() {
            return descripcion;
        }

        public ImageView getImgcomida() { return imgcomida; };

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
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

        //uri viewHOlder
        viewHolder.getImgcomida().setImageURI(Uri.parse(userComidas.get(position).getImgcomida()));
    }

    @Override
    public int getItemCount() {
        return userComidas.size();
    }
    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }
}
