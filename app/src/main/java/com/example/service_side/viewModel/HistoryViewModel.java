package com.example.service_side.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.service_side.Utils.ApplicationContextProvider;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.data.repositories.HistoryDataSource;
import com.example.service_side.data.repositories.ParcelRepository;

import java.util.List;

public class HistoryViewModel
{
    ParcelRepository parcelRepository;
    public HistoryViewModel()
    {
       parcelRepository=new ParcelRepository(ApplicationContextProvider.getContext());

    }

}
