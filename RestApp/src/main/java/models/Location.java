package models;

/**
 *
 * @author Mohamed
 */
public class Location {
    
    int id;
    String huidigeLocation;
    String huidigeCoordinaten;
    String bestemming;
    String bestemmingCoordinaten;
    String tijd;

    public Location(int id, String huidigeLocation, String huidigeCoordinaten, String bestemming, String bestemmingCoordinaten, String tijd) {
        this.id = id;
        this.huidigeLocation = huidigeLocation;
        this.huidigeCoordinaten = huidigeCoordinaten;
        this.bestemming = bestemming;
        this.bestemmingCoordinaten = bestemmingCoordinaten;
        this.tijd = tijd;
    }
    
    public Location(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHuidigeLocation() {
        return huidigeLocation;
    }

    public void setHuidigeLocation(String huidigeLocation) {
        this.huidigeLocation = huidigeLocation;
    }

    public String getHuidigeCoordinaten() {
        return huidigeCoordinaten;
    }

    public void setHuidigeCoordinaten(String huidigeCoordinaten) {
        this.huidigeCoordinaten = huidigeCoordinaten;
    }

    public String getBestemming() {
        return bestemming;
    }

    public void setBestemming(String bestemming) {
        this.bestemming = bestemming;
    }

    public String getBestemmingCoordinaten() {
        return bestemmingCoordinaten;
    }

    public void setBestemmingCoordinaten(String bestemmingCoordinaten) {
        this.bestemmingCoordinaten = bestemmingCoordinaten;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }
    
}
