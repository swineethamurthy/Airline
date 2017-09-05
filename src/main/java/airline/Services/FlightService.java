package airline.Services;

import airline.Models.FlightInformation;
import airline.Models.Place;
import airline.Models.TravelClass;
import airline.Repositories.FlightInformationRepository;
import airline.Repositories.PlaceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FlightService {

    private FlightInformationRepository flightInformationRepository;
    private PlaceRepository placeRepository;

    public FlightService() {
        this.flightInformationRepository = new FlightInformationRepository();
        this.placeRepository = new PlaceRepository();
    }


    public List<FlightInformation> getFlightInformation() {
        return flightInformationRepository.getFlightInformation();
    }

    public List<Place> getPlaces() {
        return placeRepository.getPlaces();

    }

    public List<TravelClass.TravelType> getTravelClasses()
    {
        return Arrays.asList(TravelClass.TravelType.values());
    }


    public List<FlightInformation> searchFlights(String source, String destination, int noOfSeats) {
        return flightInformationRepository.getFlightInformation().stream()
                .filter(x -> x.getSource().equals(source))
                .filter(x -> x.getDestination().equals(destination))
                .collect(Collectors.toList());
    }

    public List<FlightInformation> searchFlightsWithDepartureDate(String source,
                                                                  String destination, int noOfSeats,
                                                                  Optional<LocalDate> departureDate,
                                                                  TravelClass.TravelType travelClass)
    {

        List<FlightInformation> getFlightsWithSearchDate;
        List<FlightInformation> getFlightsWithoutSearchDate = searchFlights(source,destination,noOfSeats);
        if(Optional.ofNullable(departureDate).equals(Optional.empty()))
        {

            getFlightsWithSearchDate = getFlightsWithoutSearchDate.stream()
                    .filter(x -> x.getDepartureDate().isEqual(LocalDate.now()) || x.getDepartureDate().isAfter(LocalDate.now()))
                    .filter(x -> x.getNumberOfSeatsAvailable(travelClass) > noOfSeats)
                    .collect(Collectors.toList());

        }
        else
        {
            getFlightsWithSearchDate = getFlightsWithoutSearchDate.stream()
                    .filter(x -> x.getDepartureDate().isEqual(departureDate.get()))
                    .filter(x -> x.getNumberOfSeatsAvailable(travelClass) > noOfSeats)
                    .collect(Collectors.toList());
        }
        return getFlightsWithSearchDate;

    }


}



