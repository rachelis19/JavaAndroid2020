package com.example.service_side.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.service_side.Utils.ApplicationContextProvider;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.data.repositories.HistoryDataSource;
import com.example.service_side.data.repositories.ParcelRepository;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel
{
    ParcelRepository parcelRepository;
    Context r=getApplication();

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        parcelRepository=new ParcelRepository(r);
    }

    public LiveData<List<Parcel>>  getAllParcel() {
    return parcelRepository.getAllParcel();
}
}
