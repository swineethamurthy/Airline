package airline.Models;

import java.time.LocalDate;
import java.util.Optional;

public class FlightInformation {
    private String source;
    private String destination;
    private String flightNumber;
    private Aeroplane aeroplane;
    private LocalDate departureDate;
    private int noOfSeatsBookedEconomy;
    private int noOfSeatsBookedFirst;
    private int noOfSeatsBookedBusiness;

    public FlightInformation() {

    }

    public FlightInformation(String source, String destination, String flightName, LocalDate departureDate) {
        this.source = source;
        this.destination = destination;
        this.flightNumber = flightName;
        this.departureDate = departureDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setAeroplane(Aeroplane aeroplane) {
        this.aeroplane = aeroplane;
    }

    public String getSource() {
        return this.source;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public int getTotalNoOfSeatsBooked() {
        return noOfSeatsBookedEconomy + noOfSeatsBookedFirst + noOfSeatsBookedBusiness;
    }

    public int getNumberOfSeatsAvailable(TravelClass.TravelType travelType) {
        Optional<TravelClass> travelClass = aeroplane.getTravelClasses().stream().
                filter(x -> x.getTravelClass().equals(travelType)).findFirst();
        if(travelClass.isPresent())
        {
            switch(travelType)
            {
                case BUSINESS:
                    return (travelClass.get().getNoOfSeats() - noOfSeatsBookedBusiness);
                case FIRST:
                    return (travelClass.get().getNoOfSeats() - noOfSeatsBookedFirst);
                case ECONOMY:
                    return (travelClass.get().getNoOfSeats() - noOfSeatsBookedEconomy);
                default:
                    return 0;

            } }

        return 0;
    }


}