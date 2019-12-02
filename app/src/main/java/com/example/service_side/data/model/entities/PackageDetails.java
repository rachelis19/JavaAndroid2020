package com.example.service_side.data.model.entities;

public class PackageDetails {

    private PakageType pakageType;
    private boolean fragile_content;
    private PakageWeight pakageWeight;
    private String location;
    private Worker person;
    private String distribution_Company;

    public PackageDetails(PakageType pakageType, boolean fragile_content, PakageWeight pakageWeight, String location,Worker person,String distribution_Company) {
        this.pakageType = pakageType;
        this.fragile_content = fragile_content;
        this.pakageWeight = pakageWeight;
        this.location = location;
        this.person = person;
        this.distribution_Company=distribution_Company;

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
    public String getDistribution_Company() {
        return distribution_Company;
    }

    public void setDistribution_Company(String distribution_Company) {
        this.distribution_Company = distribution_Company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackageDetails)) return false;
        PackageDetails that = (PackageDetails) o;
        return isFragile_content() == that.isFragile_content() &&
                getPakageType() == that.getPakageType() &&
                getPakageWeight() == that.getPakageWeight() &&
                getLocation().equals(that.getLocation()) &&
                //getPerson().equals(that.getPerson()) &&
                getDistribution_Company().equals(that.getDistribution_Company());
    }

}
