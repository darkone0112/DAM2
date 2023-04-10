package GenshinAPI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.genshinapi.R;

import java.util.ArrayList;
import java.util.List;

public class GenshinAdapter extends RecyclerView.Adapter<GenshinAdapter.GenshinAdapterResultHolder> {

    private List<String> results = new ArrayList<>();
    private onItemClickListener mListener;




    @NonNull
    @Override
    public GenshinAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_personaje, parent, false);
        return new GenshinAdapterResultHolder(itemView);
    }

    public void setmListener(onItemClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onBindViewHolder(@NonNull GenshinAdapterResultHolder holder, int position) {

        holder.nombrePersonaje.setText(results.get(position));

        //Insertamos el nombre para filtrar la imagen
        String imgURL = "https://api.genshin.dev/characters/"+results.get(position)+"/icon";

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

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class GenshinAdapterResultHolder extends RecyclerView.ViewHolder {

        private TextView nombrePersonaje;
        private ImageView imagePersonaje;

        public GenshinAdapterResultHolder(@NonNull View itemView) {
            super(itemView);

            nombrePersonaje = itemView.findViewById(R.id.EnamePersonaje);
            imagePersonaje = itemView.findViewById(R.id.EimagenPersonaje);

        }
    }

    public interface onItemClickListener{
        void onItemClick(int position);
    }

}
