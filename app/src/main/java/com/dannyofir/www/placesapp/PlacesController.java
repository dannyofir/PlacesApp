package com.dannyofir.www.placesapp;

import android.app.Activity;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlacesController implements HttpRequest.Callbacks {

    private Activity activity;
    private ArrayList<Place> places;
    private ProgressDialog progressDialog;
    private ListView listViewMain;
//    private RecyclerView recyclerViewPlaces;

    public PlacesController(Activity activity){
        this.activity = activity;
        listViewMain = (ListView) activity.findViewById(R.id.listViewMain);
//        recyclerViewPlaces = (RecyclerView) activity.findViewById(R.id.recyclerViewPlaces);
        progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle("Connecting to Server...");
        progressDialog.setMessage("Please Wait...");
    }

    public void sendQuery(String query){
        HttpRequest httpRequest = new HttpRequest(this);
        httpRequest.execute(query);
    }

    @Override
    public void onAboutToStart() {
        progressDialog.show();

    }

    @Override
    public void onSuccess(String downloadedText) {

        try {

            JSONObject jsonObject = new JSONObject(downloadedText);
            JSONArray jsonArray;
            jsonArray = jsonObject.getJSONArray("results");

            places = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {

                jsonObject = jsonArray.getJSONObject(i);
                String placeId = jsonObject.getString("place_id");
                String name = jsonObject.getString("name");
                String address = jsonObject.getString("formatted_address");
                jsonObject = jsonObject.getJSONObject("geometry");
                jsonObject = jsonObject.getJSONObject("location");
                double latitude = jsonObject.getDouble("lat");
                double longitude = jsonObject.getDouble("lng");

                places.add(new Place(placeId, name, address, latitude, longitude));
            }

            ArrayAdapter<Place> adapter = new ArrayAdapter(activity, android.R.layout.simple_list_item_1, places);
//            PlacesAdapter adapter = new PlacesAdapter(activity, places);

            // Maybe change to recycler view
            listViewMain.setAdapter(adapter);
        }
        catch (JSONException ex) {
            Toast.makeText(activity, "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }

        progressDialog.dismiss();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(activity, "Error: " + errorMessage, Toast.LENGTH_LONG).show();
        progressDialog.dismiss();
    }
}
