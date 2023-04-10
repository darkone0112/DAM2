package com.example.examenejercicio1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

    @Database(entities = {numeros.class},version=1)
    public abstract class AppDatabase extends RoomDatabase{
        public abstract numerosDAO numerosDAO();
    }

