package com.example.task7.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface advertDAO {

    boolean found1 = true;

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void Insert(Advert advert);

    @Update
    void update(Advert advert);

    @Delete
    void delete(Advert advert);

    @Query("SELECT * FROM adverts ORDER BY name ASC")
    LiveData<List<Advert>> getAllAdverts();

    @Query("SELECT * FROM adverts WHERE found=1")
    LiveData<List<Advert>> getFound();

    @Query("DELETE FROM adverts")
    void deleteAll();
}
