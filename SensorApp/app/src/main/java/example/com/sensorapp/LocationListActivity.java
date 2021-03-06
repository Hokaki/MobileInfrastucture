package example.com.sensorapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class LocationListActivity extends Activity {

    private ArrayList<Location> items;
    private Location item;
    private Button btnButton;
    private ListView locationListView;
    private LocationAdapter locationAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        btnButton = (Button) findViewById(R.id.btnBack);
        items = new ArrayList<Location>();
        locationListView = (ListView) findViewById(R.id.locationListView);
        locationAdapter = new LocationAdapter(items, this);
        locationListView.setAdapter(locationAdapter);

        getLocations();

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void getLocations(){

        RequestQueue queue = Volley.newRequestQueue(this);

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                "http://192.168.0.101:8080/RestApp/resources/location/all", null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {

                Log.i("VOLLEYGET: ", response.toString());

                if (response != null) {

                    parseJsonComment(response);
                    locationAdapter.setItems(items);
                    locationAdapter.notifyDataSetChanged();

                }
            }


        }, new Response.ErrorListener() {
            /**
             * TODO COMMENTS
             *
             * @param
             * @return
             * @throws
             */
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("VOLLEYERROR: ", error.getMessage());
            }
        });

        queue.add(request);
    }

    private void parseJsonComment(JSONObject response) {

        try {
            JSONArray feedArray = response.getJSONArray("location");

            for (int i = 0; i < feedArray.length(); i++) {

                JSONObject feed = (JSONObject) feedArray.get(i);

                item = new Location();
                item.setId(feed.getInt("id"));
                item.setCurrentLocation(feed.getString("huidigeLocation"));
                item.setCurrentCoordination(feed.getString("huidigeCoordinaten"));
                item.setDestination(feed.getString("bestemming"));
                item.setDestinationCoordination(feed.getString("bestemmingCoordinaten"));
                item.setTime(feed.getLong("tijd"));
                items.add(item);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
