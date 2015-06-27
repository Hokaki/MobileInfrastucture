package example.com.sensorapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class LocationListActivity extends ActionBarActivity {

    private ArrayList<Location>arrayLocation = new ArrayList<>();
    private Button btnButton;
    private ListView locationListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        btnButton = (Button) findViewById(R.id.btnBack);
        locationListView = (ListView) findViewById(R.id.locationListView);

        /* DUMMY DATA TEST
        Location location = new Location(321, "bla", "test", "hahah", "blabla", "2313");
        arrayLocation.add(location);
        Location location2 = new Location(32123123, "blaasdasd", "sfatest", "hahahsaf", "blabgfdgla", "sadad2313");
        arrayLocation.add(location2);
        Location location3 = new Location(32123123, "blaasdasd", "sfatest", "hahahkiyuiuyisaf", "bluiyuiabgfdgla", "sadad2313");
        arrayLocation.add(location3);
        Location location4 = new Location(321123, "blaassddaddasd", "sfsfasfatest", "hahahsaf", "blabgfgfdgdgla", "sadad2313");
        arrayLocation.add(location4);
        */

        ArrayAdapter<Location> myAdapter = new ArrayAdapter<Location>(this, android.R.layout.simple_list_item_1, arrayLocation);

        locationListView.setAdapter(myAdapter);

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
