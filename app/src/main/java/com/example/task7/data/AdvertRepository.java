package com.example.task7.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class AdvertRepository {
    advertDAO advertDAO;

    LiveData<List<Advert>> advertList;

    LiveData<List<Advert>> foundList;

    public AdvertRepository(Application application)
    {
        AdvertRoomDatabase db = AdvertRoomDatabase.getDatabase(application);
        advertDAO = db.advertDAO();
        advertList = advertDAO.getAllAdverts();
        foundList = advertDAO.getFound();
    }

    public LiveData<List<Advert>> getAdvertList() { return advertList;}

    public LiveData<List<Advert>> getFound() { return foundList;}


    public void Insert(Advert advert){
        AdvertRoomDatabase.databaseWriteExecutor.execute(()->{
            advertDAO.Insert(advert);
        });
    }



    public void update(Advert advert){
        AdvertRoomDatabase.databaseWriteExecutor.execute(()->{
            advertDAO.update(advert);
        });
    }


    public void delete(Advert advert){
        AdvertRoomDatabase.databaseWriteExecutor.execute(()->{
            advertDAO.delete(advert);
        });
    }

}
