package com.fisher.andrew.earthquaketracker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {



    private double mMagnitude;
    private String mLocation;
    private long mDate;
    private String mUrl;


    public Earthquake(double magnitude, String location, long date, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mUrl = url;
    }


    public double getMagnitude() {
        return mMagnitude;
    }

    public void setMagnitude(double magnitude) {
        mMagnitude = magnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public long getDate() {
        return mDate;
    }

    public void setDate(long date) {
        mDate = date;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String convertUnixToDate(long date){
        Date dateObject = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormat.format(dateObject);
    }

    public String convertUnixToTimeOfDay(long date){
        Date dateObject = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        return dateFormat.format(dateObject);
    }
}