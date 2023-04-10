package com.example.examenejercicio1;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;
@Entity(tableName = "numeros")
public class numeros {
    @PrimaryKey
    @NonNull
    public String id;
    @ColumnInfo(name="numero1")
    public int numero1;

    @ColumnInfo(name="numero2")
     public int numero2;

    @ColumnInfo(name="operacion")
    public String operacion;

    public numeros(){
        id = UUID.randomUUID().toString();
    }
}
