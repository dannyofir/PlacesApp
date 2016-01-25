package com.dannyofir.www.placesapp;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Danny on 1/25/2016.
 */
public class PlacesAdapter extends RecyclerView.Adapter<PlaceHolder> {

    private Activity activity;
    private ArrayList<Place> places;

    public PlacesAdapter(Activity activity, ArrayList<Place> places){
        this.activity = activity;
        this.places = places;
    }

    @Override
    public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater)activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);

        View itemLayout = layoutInflater.inflate(R.layout.item_place, null);

        return new PlaceHolder(itemLayout); // Maybe need to add activity to constructor
    }

    @Override
    public void onBindViewHolder(PlaceHolder holder, int position) {

        Place place = places.get(position);
        holder.bindPlace(place);

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

}
