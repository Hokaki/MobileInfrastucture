package example.com.sensorapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LocationListActivity extends Activity {

    private ArrayList<Location> arrayLocation;
    private Location item;
    private Button btnButton;
    private ListView locationListView;
    private LocationAdapter locationAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        btnButton = (Button) findViewById(R.id.btnBack);
        locationListView = (ListView) findViewById(R.id.locationListView);
        locationAdapter = new LocationAdapter(arrayLocation, this);
        //locationListView.setAdapter(locationAdapter);

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
                "http://192.168.0.102:8080/RestApp/resources/location/all", null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {

                Log.i("VOLLEYGET: ", response.toString());

                if (response != null) {

                    parseJsonComment(response);

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
            JSONArray feedArray = response.getJSONArray("");

            for (int i = 0; i < feedArray.length(); i++) {

                JSONObject feed = (JSONObject) feedArray.get(i);

                Log.i("VOLLEYJSON",feed.getString("tijd"));

                item = new Location();

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void postLocation(Context context){

        //requestStarted
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest sr = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VOLLYPOST", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //requestEndedWithError
                Log.i("VOLLYPOST",error.toString());
            }
        })

        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("gebruiker_id", "");
                params.put("bericht_id","");
                params.put("comment", "");
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }
}
