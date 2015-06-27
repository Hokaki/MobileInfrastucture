package com.infra.restapp;

import Connectivity.DbManager;
import Connectivity.Querymanager;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import models.Location;

/**
 *
 * @author Mohamed
 */
@Path("location")
public class LocationService {

    private DbManager dbManager;
    private Querymanager querymanager;

    @GET
    @Path("/all")
    @Produces("application/json")
    public Location locations(){
        List<Location> locations = new ArrayList<Location>();
        Location location = new Location();
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);
        
        locations = querymanager.getLocations();

        for (Location l:locations) {
            location.setId(l.getId());
            location.setHuidigeLocation(l.getHuidigeLocation());
            location.setHuidigeCoordinaten(l.getHuidigeCoordinaten());
            location.setBestemming(l.getBestemming());
            location.setBestemmingCoordinaten(l.getBestemmingCoordinaten());
            location.setTijd(l.getTijd());
	}
        
        dbManager.closeConnection();
        return location;
    }
    
    
    @GET
    @Path("{id : \\d+}") //support digit only
    public String getLocation(@PathParam("id") int id) {
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);

        Location location;
        location = querymanager.getLocation(id);
        dbManager.closeConnection();
        String locationString = location.getHuidigeLocation();

        return locationString;
    }
    
    @POST
    @Path("create")
    @Consumes("text/plain")
   public void createLocation(@FormParam("huidige") String huidige, @FormParam("coordinaten") String coordinaten,
           @FormParam("bestemming") String bestemming,@FormParam("bCoordinaten") String bCoordinaten, @FormParam("tijd") String tijd){
       
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);
       
       Location location = new Location();
       
       location.setHuidigeLocation(huidige);
       location.setHuidigeCoordinaten(coordinaten);
       location.setBestemming(bestemming);
       location.setBestemmingCoordinaten(bCoordinaten);
       location.setTijd(tijd);
       
       querymanager.insterLocation(location);
       
   }

}
