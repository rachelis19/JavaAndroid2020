package com.example.service_side.data.repositories;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.service_side.Utils.ParcelChange;
import com.example.service_side.data.model.entities.Parcel;
import com.example.service_side.data.model.entities.ParcelStatus;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;

import java.util.ArrayList;
import java.util.List;

public  class ParcelDataSource
{
    public interface NotifyDataChange<T>
    {
        void OnDataChanged(T obj);
        void onFailure(Exception exception);

    }
    static DatabaseReference parcelRef;
    static List<Parcel> parcelList;
    MutableLiveData<ParcelChange> parcelChange;
    private static ChildEventListener parcelRefChildEventListener;
    static
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        parcelRef=database.getReference("Parcels");
        parcelList=new ArrayList<>();
    }
     public ParcelDataSource()
     {
         parcelChange=new MutableLiveData<>();
     }
    public void addParcel(Parcel parcel)
    {
            String key=parcelRef.push().getKey();
            parcel.setIdParcel(key);
            parcelRef.child(key).setValue(parcel).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid)
                {
                    parcelChange.postValue(new ParcelChange(false,true,false));
                }

            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    parcelChange.postValue(new ParcelChange(false,false,true));
                }
            });


    }
    public LiveData<ParcelChange> getParcelChange()
    {
        return parcelChange;
    }
    public static void notifyToParcelList(final NotifyDataChange<List<Parcel>> notifyDataChange)
    {
        if(notifyDataChange!=null)
        {
            if(parcelRefChildEventListener!=null)
            {
                notifyDataChange.onFailure(new Exception("first unNotify parcel list"));
                return;
            }
            parcelList.clear();
            parcelRefChildEventListener=new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Parcel parcel=dataSnapshot.getValue(Parcel.class);
                    if(parcel.getParcelStatus()== ParcelStatus.ACCEPTED)
                    {
                        parcelList.add(parcel);
                        notifyDataChange.OnDataChanged(parcelList);
                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Parcel parcel = dataSnapshot.getValue(Parcel.class);
                    if (parcel.getParcelStatus() == ParcelStatus.ACCEPTED) {
                        parcelList.add(parcel);
                        notifyDataChange.OnDataChanged(parcelList);
                    }
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
        }
    }

    public static void stopNotifyToParcelList() {
        if (parcelRefChildEventListener != null) {
            parcelRef.removeEventListener(parcelRefChildEventListener);
            parcelRefChildEventListener = null;
        }
    }

}



