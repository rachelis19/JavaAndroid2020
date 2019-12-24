package com.example.service_side.data.model.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.service_side.Utils.Address;

@Entity(tableName = "person_table")
public class Person {
    @PrimaryKey @NonNull private String id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String address;

    public Person(String id, String first_name, String last_name, String phone_number, String address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId().equals(person.getId()) &&
                getFirst_name().equals(person.getFirst_name()) &&
                getLast_name().equals(person.getLast_name()) &&
                getPhone_number().equals(person.getPhone_number()) &&
                getAddress().equals(person.getAddress()) ;
    }


}

