package com.example.service_side.data.repositories;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.service_side.data.model.entities.Converters;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.data.model.entities.Person;
import com.example.service_side.data.model.entities.Worker;

//@Database(entities = {Parcel.class}, version = 1,exportSchema = false)
//@TypeConverters({Converters.class})
public abstract class ParcelRoomDatabase extends RoomDatabase
{
   /* public abstract ParcelDAO parcelDAO();
    private static ParcelRoomDatabase instance;

    public static synchronized ParcelRoomDatabase getInstance(Context context)
    {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ParcelRoomDatabase.class, "ParcelRoomDatabase").fallbackToDestructiveMigration().build();
        }

        return instance;
    }*/

}
