package com.example.service_side.Utils;

public class ParcelChange
{

    public boolean start;
    public boolean success;
    public boolean failure;
    public ParcelChange(boolean start,boolean success,boolean failure)
    {
       this.start=start;
       this.success=success;
       this.failure=failure;
    }
    public ParcelChange()
    {
        this.start=true;
        this.success=false;
        this.failure=false;
    }
}
