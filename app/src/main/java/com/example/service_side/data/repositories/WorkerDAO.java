package com.example.service_side.data.repositories;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.service_side.data.model.entities.Worker;

import java.util.List;

@Dao
public interface WorkerDAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Worker worker);

    @Update
    void update(Worker worker);

    @Delete
    void delete(Worker worker);

    @Query("SELECT * from worker_table")
   LiveData<List<Worker>> getAllWorkers();
}
