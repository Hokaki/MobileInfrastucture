package example.com.sensorapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Mohamed on 28/06/2015.
 */
public class LocationAdapter extends BaseAdapter{

    List<Location> locations;
    Activity activity;
    private LayoutInflater inflater;

    public LocationAdapter(List<Location> locations, Activity activity){
        this.locations = locations;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return locations.size();
    }

    @Override
    public Object getItem(int position) {
        return locations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.location_list_items, parent, false);

        }

        return convertView;
    }
}
