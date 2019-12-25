package com.example.service_side.ui.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.service_side.R;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.viewModel.HistoryViewModel;
import com.example.service_side.viewModel.ParcelViewModel;

import java.util.List;

public class HistoryParcelActivity extends AppCompatActivity {

     private HistoryViewModel historyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent i=getIntent();
        final List<Parcel> firstParcelList=(List<Parcel>)historyViewModel.getAllParcel();
        historyViewModel=new HistoryViewModel();
        historyViewModel=ViewModelProviders.of(this).get(HistoryViewModel.class);
        historyViewModel.getAllParcel().observe(this, new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcelList)
            {
                if(firstParcelList.size()<parcelList.size())
                    Toast.makeText(getApplicationContext(),"new List",Toast.LENGTH_SHORT);
            }
        });

    }
}




