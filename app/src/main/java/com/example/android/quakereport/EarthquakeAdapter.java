package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private Context mContext;
    private List<Earthquake> earthquakeList = new ArrayList<>();

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
        String magnitudeString = Double.toString(currentEarthquake.getMagnitude());
        magnitude.setText(magnitudeString);

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


    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String formattedDate = dateFormatter.format(dateObject);
        return formattedDate;
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm aa");
        String formattedTime = dateFormatter.format(dateObject);
        return formattedTime;
    }



}
