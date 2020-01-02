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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public  class ParcelDataSource
{
    MutableLiveData<ParcelChange> parcelChange;
    public interface NotifyDataChange<T>
    {
        void OnDataChanged(T obj);
        void onFailure(Exception exception);

    }
    static DatabaseReference parcelRef;
    static List<Parcel> parcelList;
    private static ValueEventListener parcelRefValueEventListener,tmp;
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
            parcel.setParcelId(key);
            stopNotifyToParcelList();
            parcelRef.child(key).setValue(parcel).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid)
                {
                    parcelRefValueEventListener=tmp;
                    parcelRef.addValueEventListener(parcelRefValueEventListener);
                    parcelChange.postValue(new ParcelChange(false,true,false));
                }

            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    parcelRefValueEventListener=tmp;
                    parcelRef.addValueEventListener(parcelRefValueEventListener);
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
            if(parcelRefValueEventListener!=null)
            {
                notifyDataChange.onFailure(new Exception("first unNotify parcel list"));
                return;
            }
            parcelList.clear();
            parcelRefValueEventListener=new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                {
                    int size=parcelList.size();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Parcel parcel = data.getValue(Parcel.class);
                        if(parcel.getParcelStatus()== ParcelStatus.ACCEPTED){
                            if(!(parcelList.contains(parcel))){
                                parcelList.add(parcel);
                            }
                        }
                    }
                    if(size<parcelList.size()){//Update only after all the packages have come in and not on each package separately
                        notifyDataChange.OnDataChanged(parcelList);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };

           parcelRef.addValueEventListener(parcelRefValueEventListener);
        }
    }

    public static void stopNotifyToParcelList() {
        if (parcelRefValueEventListener!= null) {
            parcelRef.removeEventListener(parcelRefValueEventListener);
            tmp=parcelRefValueEventListener;
            parcelRefValueEventListener=null;
        }
    }

}



