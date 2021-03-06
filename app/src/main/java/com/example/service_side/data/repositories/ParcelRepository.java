package com.example.service_side.data.repositories;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.service_side.Utils.ParcelChange;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.data.model.entities.ParcelStatus;
import com.example.service_side.data.model.entities.ParcelType;
import com.example.service_side.data.model.entities.ParcelWeight;
import com.example.service_side.viewModel.HistoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class ParcelRepository extends Application
{
    private ParcelDataSource  parcelDataSource;
    private HistoryDataSource historyDataSource=null;
    private ParcelDAO parcelDAO;
    private MutableLiveData<List<Parcel>> allParcels;
    //private static Context mContext;

     public ParcelRepository(Context app) {

            historyDataSource = Room.databaseBuilder(app, HistoryDataSource.class, "myRoom")
                 .allowMainThreadQueries().build();
            parcelDAO = historyDataSource.getParcelDAO();
            allParcels =new MutableLiveData<>();
            allParcels.postValue(parcelDAO.getAllParcels());
            parcelDataSource=new ParcelDataSource();



        parcelDataSource.notifyToParcelList(new ParcelDataSource.NotifyDataChange<List<Parcel>>() {
             @Override
             public void OnDataChanged(List<Parcel> parcelList) {
                 for (int i = 0; i < parcelList.size(); i++) {
                     if (parcelDAO.getParcelById(parcelList.get(i).getParcelId()) == null) {
                         parcelDAO.Insert(parcelList.get(i));
                     }
                 }

                 allParcels.postValue(parcelDAO.getAllParcels());
             }



            @Override
             public void onFailure(Exception exception)
             {
               //kljko;bt;o/ko
             }
         });

     }

    public LiveData<List<Parcel>> getAllParcel() {
       return allParcels;
   }


    public void addParcel(Parcel parcel)
    {
        parcelDataSource.addParcel(parcel);
    }
    public LiveData<ParcelChange> getParcelChange() {
        return parcelDataSource.getParcelChange();
    }


}

