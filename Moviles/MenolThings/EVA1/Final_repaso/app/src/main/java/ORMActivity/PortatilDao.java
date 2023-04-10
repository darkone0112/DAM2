package ORMActivity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PortatilDao {
    @Query("SELECT * FROM portatiles")
    List<Portatiles> getAll();

    @Query("SELECT * FROM portatiles WHERE uid IN (:portatilesIds)")
    List<Portatiles> loadAllByIds(int[] portatilesIds);

    @Query("SELECT * FROM portatiles WHERE Nombre LIKE :nombre LIMIT 1")
    Portatiles findByName(String nombre);

    @Insert
    void insertAll(Portatiles... users);

    @Delete
    void delete(Portatiles user);
}

