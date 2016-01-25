package com.dannyofir.www.placesapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Danny on 1/25/2016.
 */
public class PlaceHolder extends RecyclerView.ViewHolder  {

    private TextView textViewPlace;

    public PlaceHolder(View itemView) {
        super(itemView);

        textViewPlace = (TextView) itemView.findViewById(R.id.textViewItemPlace);

    }

    public void bindPlace(Place place){

        textViewPlace.setText(place.toString());

    }



    // Add Callbacks
}
