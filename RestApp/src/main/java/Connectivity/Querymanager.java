package Connectivity;

import models.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jozef
 */
public class Querymanager {

    private final DbManager dbmanager;

    public Querymanager(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

/////////////////////////////////////////Locatie/////////////////////////////////
    public Location getLocation(int id) {
        Location location = new Location();
        try {
            String sq1 = "SELECT * FROM location " + "WHERE id='" + id + "'";
            ResultSet result = dbmanager.doQuery(sq1);
            if (result.next()) {
                location = new Location(result.getInt("id"),
                        result.getString("huidigelocatie"),
                        result.getString("huidigecoordinaten"),
                        result.getString("bestemming"),
                        result.getString("bestemmingcoordinaten"),
                        result.getString("tijd")
                );
            }
        } catch (SQLException e) {
            System.out.println(DbManager.SQL_EXCEPTION + e.getMessage());
        }

        return location;
    }
    
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<Location>();
        try {
            String sql = "SELECT * FROM location";
            ResultSet result = dbmanager.doQuery(sql);
            while (result.next()) {
                locations.add(new Location(result.getInt("id"),
                        result.getString("huidigelocatie"),
                        result.getString("huidigecoordinaten"),
                        result.getString("bestemming"),
                        result.getString("bestemmingcoordinaten"),
                        result.getString("tijd")));
            }
        } catch (SQLException e) {
            System.out.println(DbManager.SQL_EXCEPTION + e.getMessage());
        }
        return locations;
     }
    
    public void insterLocation(Location location){
        
        String sql = "INSERT INTO location (huidigelocatie, huidigecoordinaten, bestemming, bestemmingcoordinaten, tijd) "
                + "VALUES(" + location.getHuidigeLocation() + "," + location.getHuidigeCoordinaten() + "," + location.getBestemming() + 
                "," + location.getBestemmingCoordinaten() + "," + location.getTijd() + ")";
        ResultSet result = dbmanager.insertQuery(sql);
        System.out.println("Inserted" + result);
                 
    }
}
