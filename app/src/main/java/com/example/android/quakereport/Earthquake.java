package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String place;
    private String day;


    public Earthquake(double magnitude, String place, String day) {
        this.magnitude = magnitude;
        this.place = place;
        this.day = day;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
