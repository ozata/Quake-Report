package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String place;
    private long day;
    private String url;


    public Earthquake(double magnitude, String place, long day, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.day = day;
        this.url = url;
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

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
