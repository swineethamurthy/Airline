package airline.Models;

import java.util.List;

public class Aeroplane {

    private int aeroplaneId;
    private String modelNumber;
    private int noOfSeats;
    private List<TravelClass> travelClasses;

    public Aeroplane(int aeroplaneId, String modelNumber, List<TravelClass> travelClasses)
    {
        this.aeroplaneId = aeroplaneId;
        this.modelNumber = modelNumber;
        this.travelClasses = travelClasses;
    }

    public List<TravelClass> getTravelClasses() {
        return travelClasses;
    }

    public void setTravelClasses(List<TravelClass> travelClasses) {
        this.travelClasses = travelClasses;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

}

