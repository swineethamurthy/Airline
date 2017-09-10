package airline.Services;

import airline.Models.FlightInformation;
import airline.Models.TravelClass;

import java.util.List;

public class PricingService {

    public List<FlightInformation> mapCalculatedTotalPrice(List<FlightInformation> searchedFlights,
                                                           int noOfSeatsRequested,
                                                           TravelClass.TravelType travelType) {
        searchedFlights.forEach(flight -> flight.setTotalPrice(
                flight.getBasePrice(travelType)*noOfSeatsRequested));
        return searchedFlights;
    }
}
