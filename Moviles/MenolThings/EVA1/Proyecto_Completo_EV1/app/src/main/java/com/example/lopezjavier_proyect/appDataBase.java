package com.example.lopezjavier_proyect;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ComidasBas.class}, version = 1)
public abstract class appDataBase extends RoomDatabase {
    public abstract ComidaDao comidasDAO();
}