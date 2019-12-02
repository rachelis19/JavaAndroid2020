package com.example.service_side.data.model.entities;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;
public class Worker {
    private String id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private Address address;
    private String email_address;
    private String password;
    private Date birthday;

    public Worker(String id, String first_name, String last_name, String phone_number, Address address, String email_address, String password, Date birthday) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address = address;
        this.email_address = email_address;
        this.password = password;
        this.birthday = birthday;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) &&
                Objects.equals(first_name, worker.first_name) &&
                Objects.equals(last_name, worker.last_name) &&
                Objects.equals(phone_number, worker.phone_number) &&
                Objects.equals(address, worker.address) &&
                Objects.equals(email_address, worker.email_address) &&
                Objects.equals(password, worker.password) &&
                Objects.equals(birthday, worker.birthday);
    }





}
