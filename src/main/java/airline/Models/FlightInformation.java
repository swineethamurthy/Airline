package airline.Models;

import java.time.LocalDate;

public class FlightInformation {
    private String source;
    private String destination;
    private String flightNumber;
    private Aeroplane aeroplane;
    private int noOfSeatsBooked;
    private LocalDate departureDate;

    public FlightInformation(String source, String destination, String flightName, LocalDate departureDate)
    {
        this.source = source;
        this.destination = destination;
        this.flightNumber = flightName;
        this.departureDate = departureDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
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

    public boolean isEqualOrAfterDepartureDate(LocalDate departureDate)
    {
        if(departureDate.isAfter(LocalDate.now()) || departureDate.isEqual(LocalDate.now()))
            return true;
        return false;
    }


}