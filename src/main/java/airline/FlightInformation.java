package airline;

public class FlightInformation {
    private String source;
    private String destination;
    private String flightNumber;


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

}