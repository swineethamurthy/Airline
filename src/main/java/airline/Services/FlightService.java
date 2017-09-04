package airline.Services;

import airline.Repositories.FlightInformationRepository;
import airline.Models.FlightInformation;
import airline.Models.Place;
import airline.Repositories.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlightService {

    private FlightInformationRepository flightInformationRepository;
    private PlaceRepository placeRepository;

    public FlightService()
    {
        this.flightInformationRepository = new FlightInformationRepository();
        this.placeRepository = new PlaceRepository();
    }


    public List<FlightInformation> getFlightInformation()
    {
        return flightInformationRepository.getFlightInformation();
    }

    public List<Place> getPlaces()
    {
        return placeRepository.getPlaces();

    }


    public List<FlightInformation> searchFlights(String source, String destination)
    {
        return flightInformationRepository.getFlightInformation().stream()
                .filter(x -> x.getSource().equals(source))
                .filter(x -> x.getDestination().equals(destination))
                .collect(Collectors.toList());
    }

    public List<FlightInformation> searchFlights(String source, String destination, int noOfSeats)
    {

        return flightInformationRepository.getFlightInformation().stream()
                .filter(x -> x.getSource().equals(source))
                .filter(x -> x.getDestination().equals(destination))
                .filter(x -> x.getNumberOfSeatsAvailable() >= noOfSeats)
                .collect(Collectors.toList());

    }





}