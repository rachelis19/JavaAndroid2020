package com.example.service_side.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.service_side.Utils.ApplicationContextProvider;
import com.example.service_side.Utils.ParcelChange;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.data.repositories.ParcelDAO;
import com.example.service_side.data.repositories.ParcelRepository;

import java.util.List;

public class ParcelViewModel extends AndroidViewModel
{
    ParcelRepository parcelRepository;
    Context r=getApplication();

    public ParcelViewModel(@NonNull Application application) {
        super(application);
        this.parcelRepository = new ParcelRepository(r);

    }
    public LiveData<ParcelChange> getParcelChange() {
        return parcelRepository.getParcelChange();
    }
    public void addParcel(Parcel parcel)
    {

        parcelRepository.addParcel(parcel);
    }
}

