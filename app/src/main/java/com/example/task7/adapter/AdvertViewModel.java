package com.example.task7.adapter;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.task7.data.Advert;
import com.example.task7.data.AdvertRepository;

import java.util.List;

public class AdvertViewModel extends AndroidViewModel {

    AdvertRepository advertRepository;

    LiveData<List<Advert>> advertsList;
    LiveData<List<Advert>> foundList;


    public AdvertViewModel(@NonNull Application application) {
        super(application);
        advertRepository = new AdvertRepository(application);
        advertsList = advertRepository.getAdvertList();
        foundList = advertRepository.getFound();

    }

    public LiveData<List<Advert>> getAdvertsList() {
        return advertsList;
    }
    public LiveData<List<Advert>> getFoundList() {
        return foundList;
    }
    

    public void Insert(Advert advert){advertRepository.Insert(advert);}

    public void update(Advert advert){
        advertRepository.update(advert);
    }

    public void delete(Advert advert){
        advertRepository.delete(advert);
    }
}
