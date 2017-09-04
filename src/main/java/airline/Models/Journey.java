package airline.Models;

public class Journey {
    private FlightInformation flightInformation;
    private Aeroplane aeroplane;

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }

    public Aeroplane getAeroplane() {
        return aeroplane;
    }

    public void setAeroplane(Aeroplane aeroplane) {
        this.aeroplane = aeroplane;
    }

    public int getNoOfSeatsOccupied() {
        return noOfSeatsOccupied;
    }

    public void setNoOfSeatsOccupied(int noOfSeatsOccupied) {
        this.noOfSeatsOccupied = noOfSeatsOccupied;
    }

    private int noOfSeatsOccupied;



    public int getNumberOfSeatsAvailable()
    {
        return (aeroplane.getNoOfSeats() - this.noOfSeatsOccupied);
    }

}
