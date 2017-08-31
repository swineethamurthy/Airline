package airline;

import java.util.List;

public class FlightService {

    private FlightInformationRepository flightInformationRepository;
    private PlaceRepository placeRepository;

    public FlightService(FlightInformationRepository flightRepository, PlaceRepository placeRepository)
    {
        this.flightInformationRepository = flightRepository;
        this.placeRepository = placeRepository;
    }

    public void AddFlightInformation(FlightInformation flightInfoRec)
    {
        flightInformationRepository.addFlightInformation(flightInfoRec);
    }

    public void removeFlightInformation(FlightInformation flightInfoRec)
    {
        flightInformationRepository.removeFlightInformation(flightInfoRec);
    }

    public List<FlightInformation> getFlightInformation()
    {
        return flightInformationRepository.getFlightInformation();
    }

    public List<Place> getPlaces()
    {
        return placeRepository.getPlaces();
    }



}