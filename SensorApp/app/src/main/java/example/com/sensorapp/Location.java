package example.com.sensorapp;

/**
 * Created by alwin on 27/06/2015.
 */
public class Location {

    private double id;
    private String currentLocation;
    private String currentCoordination;
    private String destination;
    private String destinationCoordination;
    private String time;


    public Location(double id, String currentLocation, String currentCoordination, String destination, String destinationCoordination, String time) {
        this.id = id;
        this.currentLocation = currentLocation;
        this.currentCoordination = currentCoordination;
        this.destination = destination;
        this.destinationCoordination = destinationCoordination;
        this.time = time;
    }

    public Location(){}

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getCurrentCoordination() {
        return currentCoordination;
    }

    public void setCurrentCoordination(String currentCoordination) {
        this.currentCoordination = currentCoordination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationCoordination() {
        return destinationCoordination;
    }

    public void setDestinationCoordination(String destinationCoordination) {
        this.destinationCoordination = destinationCoordination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Current Location: " + currentLocation + "\n" +
                "Current Coordination: " + currentCoordination + "\n" +
                "Destination: " + destination + "\n" +
                "Destination Coordination: " + destinationCoordination + "\n" +
                "Time: " + time + "\n";
    }
}
