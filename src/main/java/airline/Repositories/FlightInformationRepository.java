package airline.Repositories;

import airline.Models.Aeroplane;
import airline.Models.FlightInformation;

import java.util.ArrayList;
import java.util.List;

public class FlightInformationRepository {

    private List<FlightInformation> flightInformationList = new ArrayList<FlightInformation>();

    public  FlightInformationRepository()
    {
        populateFlightInformation();
    }

    public void addFlightInformation(FlightInformation flightInfo)
    {
        flightInformationList.add(flightInfo);
    }

    public void removeFlightInformation(FlightInformation flightInfo)
    {
        flightInformationList.remove(flightInfo);
    }

    public List<FlightInformation> getFlightInformation()
    {
        return flightInformationList;
    }

    public void populateFlightInformation()
    {
        int i= 0;
        flightInformationList.add(new FlightInformation("Hyd","Mumbai","Vapasi-123"));
        flightInformationList.add(new FlightInformation("Mumbai","Hyd","Vapasi-456"));
        flightInformationList.add(new FlightInformation("Lkn","Mumbai","Vapasi-987"));
        flightInformationList.add(new FlightInformation("Lkn","Mumbai","Vapasi-100"));
        AeroplaneRepository aeroplaneRepository = new AeroplaneRepository();
        List<Aeroplane> aeroplanes =  aeroplaneRepository.getAeroplanes();
        for(FlightInformation flight : flightInformationList)
        {
            flight.setAeroplane(aeroplanes.get(i));
            flight.setNoOfSeatsBooked((i +1)*10);
            System.out.println(flight.getNumberOfSeatsAvailable());
            i++;
        }

    }

}