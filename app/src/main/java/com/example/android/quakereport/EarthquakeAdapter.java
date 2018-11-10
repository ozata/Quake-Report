package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private Context mContext;
    private List<Earthquake> earthquakeList = new ArrayList<>();

    public EarthquakeAdapter(@NonNull Context context, @LayoutRes ArrayList<Earthquake> list) {
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

        TextView day = (TextView) listItem.findViewById(R.id.dateTextView);
        day.setText(currentEarthquake.getDay());

        return listItem;
    }

}
