package ORMActivity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "portatiles")
public class Portatiles {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "Nombre")
    public String Enombre;

    @ColumnInfo(name = "Descripcion")
    public String EDescripcion;

}
