package services;

import airline.Models.FlightInformation;
import airline.Models.FlightSearchCriteria;
import airline.Models.TravelClass;
import airline.Services.FlightService;
import org.junit.Test;

import java.util.List;

public class FlightServiceTest {

    @Test
    public void testGetTravelClass()
    {
        FlightSearchCriteria obj = new FlightSearchCriteria();
        TravelClass.TravelType o = obj.getEnumByString("Economy");
        FlightService flightService = new FlightService();
        List<TravelClass.TravelType> travelTypes = flightService.getTravelClasses();
        List<FlightInformation> flightInfoList = flightService.
                searchFlightsWithDepartureDate("Lkn","Mumbai", 30, null, o );

    }


}