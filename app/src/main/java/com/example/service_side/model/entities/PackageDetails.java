package com.example.service_side.model.entities;

public class PackageDetails {

    private PakageType pakageType;
    private boolean fragile_content;
    private PakageWeight pakageWeight;
    private String location;
    private Worker person;

    public PackageDetails(PakageType pakageType, boolean fragile_content, PakageWeight pakageWeight, String location,Worker person) {
        this.pakageType = pakageType;
        this.fragile_content = fragile_content;
        this.pakageWeight = pakageWeight;
        this.location = location;
        this.person = person;

    }
    public void setPakageType(PakageType pakageType) {
        this.pakageType = pakageType;
    }

    public void setFragile_content(boolean fragile_content) {
        this.fragile_content = fragile_content;
    }

    public void setPakageWeight(PakageWeight pakageWeight) {
        this.pakageWeight = pakageWeight;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PakageType getPakageType() {
        return pakageType;
    }

    public boolean isFragile_content() {
        return fragile_content;
    }

    public PakageWeight getPakageWeight() {
        return pakageWeight;
    }

    public String getLocation() {
        return location;
    }
    public Worker getPerson() {
        return person;
    }

    public void setPerson(Worker person) {
        this.person = person;
    }

}
