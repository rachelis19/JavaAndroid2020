package com.example.service_side.data.model.entities;

import androidx.room.Entity;

import com.example.service_side.Utils.Address;

import java.util.*;
@Entity(tableName = "worker_table")
public class Worker extends Person {
    private String email_address;
    private String password;


    public Worker(String id, String first_name, String last_name, String phone_number, String address, String email_address, String password, Date birthday) {
        super(id,first_name,last_name,phone_number,address);
        this.email_address = email_address;
        this.password = password;

    }
    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return getEmail_address().equals(worker.getEmail_address()) &&
                getPassword().equals(worker.getPassword());
    }

}
