package com.dannyofir.www.placesapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class PlacesListFragment extends Fragment {


    public PlacesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_places_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listViewMain);

        return rootView;
    }

}
