package airline;

import java.util.ArrayList;
import java.util.List;

public class FlightInformationRepository {


    private List<FlightInformation> flightInformation = new ArrayList<FlightInformation>();
    public  FlightInformationRepository()
    {
        populateFlightInformation();
    }

    public void addFlightInformation(FlightInformation flightInfo)
    {
        flightInformation.add(flightInfo);
    }

    public void removeFlightInformation(FlightInformation flightInfo)
    {
        flightInformation.remove(flightInfo);
    }

    public List<FlightInformation> getFlightInformation()
    {
        return flightInformation;
    }

    public void populateFlightInformation()
    {
        flightInformation.add(new FlightInformation("Hyd","Mumbai","Boeing 777-200LR(77L)"));
        flightInformation.add(new FlightInformation("Mumbai","Hyd","Airbus A319 V2"));
        flightInformation.add(new FlightInformation("Lkn","Mumbai","Airbus A321"));

    }

}