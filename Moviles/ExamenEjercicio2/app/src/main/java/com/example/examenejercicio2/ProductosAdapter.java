package com.example.examenejercicio2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder>{
    private ArrayList<productos> productos = new ArrayList<>();
    private Context context;
    public ProductosAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_productos_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        int cantidades [] = new int[productos.size()];
        holder.txtName.setText(productos.get(position).getNombre());
        //holder.txtPrecio.setText((int) productos.get(position).getPrecio());
        //holder.txtCantidad.setText(productos.get(position).getCantidad());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidades[holder.getAdapterPosition()] += 1;
                Toast.makeText(context,productos.get(holder.getAdapterPosition()).getNombre() + " Añadido total de: " + cantidades[holder.getAdapterPosition()], Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public  int getItemCount(){
        return productos.size();
    }
    public void setProductos(ArrayList<productos> productos){
        this.productos = productos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName,txtPrecio,txtCantidad;
        private CardView parent;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            txtCantidad = itemView.findViewById(R.id.txtCantidad);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
