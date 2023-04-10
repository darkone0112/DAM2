package com.example.examenejercicio1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface numerosDAO {
    @Query("SELECT * FROM numeros")
    List<numeros>getALL();

    @Query("SELECT * FROM numeros WHERE numero1 like :numero1 LIMIT 1")
    List<numeros>loadNumber1(int numero1);

    @Query("SELECT * FROM numeros WHERE numero2 like :numero2 LIMIT 1")
    List<numeros>loadNumber2(int numero2);

    @Query("SELECT * FROM numeros WHERE operacion like :operacion LIMIT 1")
    List<numeros>loadOperacion(String operacion);

    @Insert
    void insertAll(numeros... users);

    @Delete
    void delete(numeros user);
}
