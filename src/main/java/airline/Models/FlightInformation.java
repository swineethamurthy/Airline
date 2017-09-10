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

    private double totalPrice=0;



    public FlightInformation(String source, String destination, String flightName, LocalDate departureDate,double totalPrice) {
        this.source = source;
        this.destination = destination;
        this.flightNumber = flightName;
        this.departureDate = departureDate;
        this.totalPrice=totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public double getBasePrice(TravelClass.TravelType travelType) {
        Optional<TravelClass> travelClass = aeroplane.getTravelClasses().stream().
                filter(x -> x.getTravelClass().equals(travelType)).findFirst();
        if(travelClass.isPresent())
        {
            switch(travelType)
            {
                case BUSINESS:
                    return (travelClass.get().getBasePrice());
                case FIRST:
                    return (travelClass.get().getBasePrice());
                case ECONOMY:
                    return (travelClass.get().getBasePrice());
                default:
                    return 0;

            } }

        return 0;
    }


}