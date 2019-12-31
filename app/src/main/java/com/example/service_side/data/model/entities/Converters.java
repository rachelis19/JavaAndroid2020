package com.example.service_side.data.model.entities;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Converters
{


    @TypeConverter
    public static ParcelStatus stringToStatus(String status) {
        if (status =="ACCEPTED") {
            return ParcelStatus.ACCEPTED;
        } else if (status =="SENT") {
            return ParcelStatus.SENT;
        } else if (status =="ON_WAY") {
            return ParcelStatus.ON_WAY;
        } else if (status =="SOMEONE_OFFERED") {
            return ParcelStatus.SOMEONE_OFFERED;
        }else {
            return null;
        }
    }

    @TypeConverter
    public static String statusToString(ParcelStatus status) {
        if (status==null)
            return null;
        return  status.toString();
    }
    @TypeConverter
    public String FromParcelToString(ParcelType p)
    {
        switch (p)
        {
            case ENVELOPE: return "ENVELOPE" ;
            case BIG_PACKAGE: return "BIG_PACKAGE";
            case SMALL_PACKAGE: return "SMALL_PACKAGE";
        }

        return null;
    }
    @TypeConverter
    public ParcelType FromStringToParcelT(String s)
    {
        switch (s)
        {
            case "ENVELOPE": return ParcelType.ENVELOPE;
            case "BIG_PACKAGE": return ParcelType.BIG_PACKAGE;
            case "SMALL_PACKAGE": return ParcelType.SMALL_PACKAGE;
        }
        return null;
    }


    @TypeConverter
    public String FromParceWlToString(ParcelWeight w)
    {
        switch (w)
        {
            case UNTIL_500G: return "UNTIL_500G";
            case UNTIL_1KG: return "UNTIL_1KG";
            case UNTIL_5KG: return "UNTIL_5KG";
            case UNTIL_20KG:return "UNTIL_20KG";
        }

        return null;
    }
    @TypeConverter
    public ParcelWeight FromStringToParcelW(String s)
    {
        switch (s)
        {
            case "UNTIL_500G": return ParcelWeight.UNTIL_500G;
            case "UNTIL_1KG": return  ParcelWeight.UNTIL_1KG;
            case "UNTIL_5KG": return ParcelWeight.UNTIL_5KG;
            case "UNTIL_20KG":return ParcelWeight.UNTIL_20KG;
        }
        return null;
    }


}


