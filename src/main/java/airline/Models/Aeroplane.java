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


}

