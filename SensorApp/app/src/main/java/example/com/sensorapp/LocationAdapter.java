package example.com.sensorapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    public class ViewHolder{

        private TextView huidigTxt;
        private TextView coordinatenTxt;
        private TextView bestemmingTxt;
        private TextView bCoordinatenTxt;
        private TextView tijd;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.location_list_items, parent, false);

            holder = new ViewHolder();
            holder.huidigTxt = (TextView) convertView.findViewById(R.id.huidigTxt);
            holder.coordinatenTxt = (TextView) convertView.findViewById(R.id.coordinatenTxt);
            holder.bestemmingTxt = (TextView) convertView.findViewById(R.id.bestemmingTxt);
            holder.bCoordinatenTxt = (TextView) convertView.findViewById(R.id.bCoordinatenTxt);
            holder.tijd = (TextView) convertView.findViewById(R.id.tijd);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Location item = locations.get(position);

        holder.huidigTxt.setText("HuidigeLocatie: " + item.getCurrentLocation());
        holder.coordinatenTxt.setText("HuidigeCoördinaat: " + item.getCurrentCoordination());
        holder.bestemmingTxt.setText("Bestemming: " + item.getDestination());
        holder.bCoordinatenTxt.setText("BestemmingCoördinaat: " + item.getCurrentCoordination());
        holder.tijd.setText("Tijd: " + item.getTime());


        return convertView;
    }

    public void setItems(List<Location> locations) {
        this.locations = locations;
    }
}
