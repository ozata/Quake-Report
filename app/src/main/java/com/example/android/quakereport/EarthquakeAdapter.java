package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private Context mContext;
    private List<Earthquake> earthquakeList = new ArrayList<>();

    //Want to show only one decimal.
    DecimalFormat formatter = new DecimalFormat("0.0");


    //String dateToDisplay = dateFormatter.format(dateObject);


    public EarthquakeAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Earthquake> list) {
        super(context, 0, list);
        mContext = context;
        earthquakeList = list;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.earthquake_list_item, parent, false);

        Earthquake currentEarthquake = earthquakeList.get(position);

        TextView magnitude = (TextView) listItem.findViewById(R.id.magnitudeTextView);
        String magnitudeString = formatter.format(currentEarthquake.getMagnitude());
        magnitude.setText(magnitudeString);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        TextView place = (TextView) listItem.findViewById(R.id.placeTextView);
        place.setText(currentEarthquake.getPlace());

        //Create the date object, meaning, get the UNIX Timestamp.
        Date dateObject = new Date(currentEarthquake.getDay());
        //Get the TextView for date
        TextView day = (TextView) listItem.findViewById(R.id.dateTextView);
        //Get the string of the formatted date by the method formatDate.
        String formattedDate = formatDate(dateObject);
        //Set the string to the dateTextView's reference View day.
        day.setText(formattedDate);

        //Now same things for the Time, get the text view.
        TextView time = (TextView) listItem.findViewById(R.id.timeTextView);
        //Get string
        String formattedTime = formatTime(dateObject);
        //Set string
        time.setText(formattedTime);

        return listItem;
    }


    private int getMagnitudeColor(double magnitude) {

        int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        int magnitude2Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
        int magnitude3Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
        int magnitude4Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
        int magnitude5Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
        int magnitude6Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
        int magnitude7Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
        int magnitude8Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
        int magnitude9Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
        int magnitude10Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);

        int magnitudeColor;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColor = magnitude1Color;
                break;
            case 2:
                magnitudeColor = magnitude2Color;
                break;
            case 3:
                magnitudeColor = magnitude3Color;
            case 4:
                magnitudeColor = magnitude4Color;
                break;
            case 5:
                magnitudeColor = magnitude5Color;
                break;
            case 6:
                magnitudeColor = magnitude6Color;
                break;
            case 7:
                magnitudeColor = magnitude7Color;
                break;
            case 8:
                magnitudeColor = magnitude8Color;
                break;
            case 9:
                magnitudeColor = magnitude9Color;
                break;
            case 10:
                magnitudeColor = magnitude10Color;
            default:
                magnitudeColor = magnitude10Color;
        }

        return magnitudeColor;
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String formattedDate = dateFormatter.format(dateObject);
        return formattedDate;
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm aa");
        String formattedTime = dateFormatter.format(dateObject);
        return formattedTime;
    }


}
