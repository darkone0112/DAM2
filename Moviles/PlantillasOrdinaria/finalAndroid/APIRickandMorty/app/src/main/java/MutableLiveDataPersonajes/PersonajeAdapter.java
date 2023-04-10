package MutableLiveDataPersonajes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apirickandmorty.MainActivity;
import com.example.apirickandmorty.PaginaDetalle;
import com.example.apirickandmorty.R;

import java.util.ArrayList;
import java.util.List;

import RickMortyAPI.APIMapear.PaginaRespuesta;
import RickMortyAPI.APIMapear.PersonajesRespuesta;


//Importamos la clase PersonajeAdapterResultHolder (En el mismo documento) y sus métodos obligatorios
public class PersonajeAdapter extends RecyclerView.Adapter <PersonajeAdapter.PersonajeAdapterResultHolder> {
    private List<PersonajesRespuesta> results = new ArrayList<>();
    private OnItemClickListener mListener;
    private Context mContext;

    //Para los Intents
    public PersonajeAdapter(Context context) {
            mContext = context;
    }

    @NonNull
    @Override
    public PersonajeAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_personaje, parent, false);

        return new PersonajeAdapterResultHolder(itemView);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    //Método encargado de insertar en los objetos
    @Override
    public void onBindViewHolder(@NonNull PersonajeAdapterResultHolder holder, int position) {

        //Recibe La página con la info
        PersonajesRespuesta personajeRespuesta = results.get(position);

        //Inserto al Recycler
        holder.EName.setText(personajeRespuesta.getName());
        holder.Estatus.setText(personajeRespuesta.getStatus());
        holder.Especies.setText(personajeRespuesta.getSpecies());
        holder.Egender.setText(personajeRespuesta.getGender());

        //Desde aquí se hace el Intent
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {

                    //Extrae el id del objeto RecyclerPulsado
                    //Método que envía a otra actividad
                    Intent intent = new Intent(mContext, PaginaDetalle.class);
                    intent.putExtra("id",personajeRespuesta.getId());
                    mContext.startActivity(intent);

                }
            }
        });

        //En imágenes
        if (personajeRespuesta.getImagelink() != null) {

            //No hace falta hacer replace ya que es HTTPS
            String imgURL = personajeRespuesta.getImagelink();

            Glide.with(holder.itemView)
                    .load(imgURL)
                    .into(holder.EimagenPersonaje);

        }

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    //Asigna el valor al results y reinicia el LiveData
    public void setResults(List<PersonajesRespuesta> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    //Clase Holder (Es otra clase en el mismo documento) No sé muy bien por qué se hizo así pero cuando retornas, retornas a esto
    class PersonajeAdapterResultHolder extends RecyclerView.ViewHolder {

        //Creamos las variables que utilizaremos para el Recycler
        private TextView EName, Estatus, Especies, Egender;
        private ImageView EimagenPersonaje;
        public PersonajeAdapterResultHolder(@NonNull View itemView) {
            super(itemView);

            //Asignamos ids
            EName = itemView.findViewById(R.id.Ename);
            Estatus = itemView.findViewById(R.id.Estatus);
            Especies = itemView.findViewById(R.id.Especies);
            Egender = itemView.findViewById(R.id.Egender);
            EimagenPersonaje = itemView.findViewById(R.id.EimagenPersonaje);

        }

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }



}
