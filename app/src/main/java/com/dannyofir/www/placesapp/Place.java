package com.dannyofir.www.placesapp;

public class Place {

    //    private int id;
    private String placeId;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    // Maybe there will be more data members

    public Place(String placeID, String name, String address, double latitude, double longitude){
        setPlaceId(placeID);
        setName(name);
        setAddress(address);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address;
    }
}

