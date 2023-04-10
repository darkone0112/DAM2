package com.example.lopezjavier_proyect;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ComidaDao {
    @Query("SELECT * FROM comidasimg1")
    List<ComidasBas> getAll();

    @Query("SELECT * FROM comidasimg1 WHERE uid IN (:userIds)")
    List<ComidasBas> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM comidasimg1 WHERE nombre LIKE :nombre LIMIT 1")
    ComidasBas findByName(String nombre);

    @Insert
    void insertAll(ComidasBas... users);

    @Delete
    void delete(ComidasBas user);

    @Update
    void updateRecord(ComidasBas user);

}
