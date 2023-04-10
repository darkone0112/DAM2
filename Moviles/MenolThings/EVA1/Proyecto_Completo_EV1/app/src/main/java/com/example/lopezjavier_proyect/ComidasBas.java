package com.example.lopezjavier_proyect;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;
import java.util.UUID;

@Entity(tableName="comidasimg1")
public class ComidasBas {
    @PrimaryKey
    @NotNull
    public String uid;
    @ColumnInfo(name = "nombre")
    public String nombre;
    @ColumnInfo(name = "descripcion")
    public String descripcion;
    @ColumnInfo(name = "imgcomida")
    public String imgcomida;
    public ComidasBas(){
        uid=UUID.randomUUID().toString();
    }

        public ComidasBas (String nombre,String descripcion,String imgcomida) {
            this.nombre=nombre;
            this.descripcion=descripcion;
            this.imgcomida=imgcomida;
        };


        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getImgcomida(){ return imgcomida; }

}


