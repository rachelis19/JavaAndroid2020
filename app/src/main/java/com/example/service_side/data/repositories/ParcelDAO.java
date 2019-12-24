package com.example.service_side.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import com.example.service_side.data.model.entities.Converters;
import com.example.service_side.data.model.entities.Parcel;

import java.util.List;

@Dao
public interface ParcelDAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Parcel parcel);
    @Query("SELECT * from parcel_table")
     LiveData<List<Parcel>> getAllParcels();
    @Query("SELECT * FROM parcel_table WHERE parcelId = :id")
     Parcel getParcelById(String id);

}
