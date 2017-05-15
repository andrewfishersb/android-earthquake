package com.fisher.andrew.earthquaketracker;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.R;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by andrewfisher on 5/13/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";
    private String mUrl;


    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }


        Earthquake currentEarthquake = getItem(position);

        //Sets the magnitude and formats it to one decimal place
        double magnitude = currentEarthquake.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String formattedMagnitude = formatter.format(magnitude);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);


        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        magnitudeView.setText(formattedMagnitude);


        //Sets text of the earthquake location
        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation;
        String locationOffset;

        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String[] splitLocation = originalLocation.split(LOCATION_SEPARATOR);

            //Pin point location ie 10K North
            locationOffset = splitLocation[0];

            //Nearest City i.e. Portland
            primaryLocation = splitLocation[1];
        }else{
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(currentEarthquake.convertUnixToDate(currentEarthquake.getDate()));


        TextView locationView = (TextView) listItemView.findViewById(R.id.primary_location);
        locationView.setText(primaryLocation);

        TextView whereAboutView = (TextView) listItemView.findViewById(R.id.location_offset);
        whereAboutView.setText(locationOffset);



        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(currentEarthquake.convertUnixToTimeOfDay(currentEarthquake.getDate()));





        return listItemView;
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeInt = (int) magnitude;



        switch (magnitudeInt){
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);

            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }


    }


}
