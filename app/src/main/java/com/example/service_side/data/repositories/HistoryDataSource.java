package com.example.service_side.data.repositories;

import android.app.Application;
import android.content.Entity;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.service_side.data.model.entities.Converters;
import com.example.service_side.data.model.entities.Parcel;

import java.util.List;
@TypeConverters(Converters.class)
@Database(entities={Parcel.class},version =1,exportSchema = false)
public abstract class HistoryDataSource extends RoomDatabase
{
   public abstract ParcelDAO getParcelDAO();


}
