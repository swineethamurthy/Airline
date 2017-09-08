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

    private int basePriceEconomy;
    private int basePriceFirst;
    private int basePriceBusiness;

    private int totalPrice=0;



    public FlightInformation(String source, String destination, String flightName, LocalDate departureDate,int totalPrice) {
        this.source = source;
        this.destination = destination;
        this.flightNumber = flightName;
        this.departureDate = departureDate;
        this.totalPrice=totalPrice;
    }

    public int getBasePriceEconomy() {
        return basePriceEconomy;
    }

    public void setBasePriceEconomy(int basePriceEconomy) {
        this.basePriceEconomy = basePriceEconomy;
    }

    public int getBasePriceFirst() {
        return basePriceFirst;
    }

    public void setBasePriceFirst(int basePriceFirst) {
        this.basePriceFirst = basePriceFirst;
    }

    public int getBasePriceBusiness() {
        return basePriceBusiness;
    }

    public void setBasePriceBusiness(int basePriceBusiness) {
        this.basePriceBusiness = basePriceBusiness;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
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

    public int getBasePrice(TravelClass.TravelType travelType) {
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