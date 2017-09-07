package airline.Services;

import airline.Models.FlightInformation;
import airline.Models.FlightSearchCriteria;
import airline.Models.Place;
import airline.Models.TravelClass;
import airline.Repositories.FlightInformationRepository;
import airline.Repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FlightService {

    @Autowired @Qualifier("FlightsRepository")
    private FlightInformationRepository flightsInformationRepository;
    @Autowired @Qualifier("PlacesRepository")
    private PlaceRepository placesRepository;

    public FlightService() {

    }


    public List<FlightInformation> getFlightInformation() {
        return flightsInformationRepository.getFlightInformation();
    }

    public List<Place> getPlaces() {
        return placesRepository.getPlaces();

    }

    public List<TravelClass.TravelType> getTravelClasses()
    {
        return Arrays.asList(TravelClass.TravelType.values());
    }


    public List<FlightInformation> searchFlightsWithSourceAndDestination(String source, String destination) {
        return flightsInformationRepository.getFlightInformation().stream()
                .filter(x -> x.getSource().equals(source))
                .filter(x -> x.getDestination().equals(destination))
                .collect(Collectors.toList());
    }

    public List<FlightInformation> searchFlights(FlightSearchCriteria searchCriteria)
    {
        List<FlightInformation> getFlights;
        List<FlightInformation> getFlightsWithSourceAndDestination = searchFlightsWithSourceAndDestination(searchCriteria.getSource(),
                searchCriteria.getDestination());
        if(Optional.ofNullable(searchCriteria.getParsedDate()).equals(Optional.empty()))
        {

            getFlights = getFlightsWithSourceAndDestination.stream()
                    .filter(x -> x.getDepartureDate().isEqual(LocalDate.now()) || x.getDepartureDate().isAfter(LocalDate.now()))
                    .filter(x -> x.getNumberOfSeatsAvailable(searchCriteria.getParsedTravelClass()) >= searchCriteria.getNoOfPassengers())
                    .collect(Collectors.toList());

        }
        else
        {
            getFlights = getFlightsWithSourceAndDestination.stream()
                    .filter(x -> x.getDepartureDate().isEqual(searchCriteria.getParsedDate().get()))
                    .filter(x -> x.getNumberOfSeatsAvailable(searchCriteria.getParsedTravelClass()) >= searchCriteria.getNoOfPassengers())
                    .collect(Collectors.toList());
        }
        return getFlights;
    }

    public List<FlightInformation> searchResults(List<FlightInformation> searchedFlights,int noOfSeatsRequested) {
        List<FlightInformation> searchResult;
        if(searchedFlights.size()>0)
        {

        }
        else
        {
            searchResult=searchedFlights;
        }
        return searchResult;
    }
    public int calculateTotalPrice()
    {

    }
    }









