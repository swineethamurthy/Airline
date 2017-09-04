package airline.Models;

import java.util.Date;

public class FlightInformation {
    private String source;
    private String destination;
    private String flightNumber;
    private Aeroplane aeroplane;
    private int noOfSeatsBooked;
    private Date departureDate;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }



    public Aeroplane getAeroplane() {
        return aeroplane;
    }

    public void setAeroplane(Aeroplane aeroplane) {
        this.aeroplane = aeroplane;
    }

    public FlightInformation()
    {

    }

    public FlightInformation(String source, String destination, String flightName)
    {
        this.source = source;
        this.destination = destination;
        this.flightNumber = flightName;
    }

    public String getSource()
    {
        return this.source;
    }

    public String getDestination()
    {
        return this.destination;
    }

    public String getFlightNumber()
    {
        return this.flightNumber;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public void setDestination(String destination)
    {
         this.destination = destination;
    }

    public void setFlightNumber(String flightNumber)
    {
         this.flightNumber = flightNumber;
    }

    public int getNoOfSeatsBooked() {
        return noOfSeatsBooked;
    }

    public void setNoOfSeatsBooked(int noOfSeatsBooked) {
        this.noOfSeatsBooked = noOfSeatsBooked;
    }

    public int getNumberOfSeatsAvailable()
    {
        return (aeroplane.getNoOfSeats() - this.noOfSeatsBooked);
    }




}