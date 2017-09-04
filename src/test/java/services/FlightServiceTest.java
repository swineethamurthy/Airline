package services;

import airline.Models.FlightInformation;
import airline.Services.FlightService;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class FlightServiceTest {

    @Test
    public void testSearchFlightsWithDepartureDate()
    {
        //Optional.of(LocalDate.now())
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");
        System.out.println(LocalDate.parse("2017-09-04"));
        FlightService flightService = new FlightService();
        System.out.println(Optional.of(LocalDate.now()));
        List<FlightInformation> flightInfoList = flightService.
                searchFlightsWithDepartureDate("Lkn","Mumbai", 1, Optional.of(LocalDate.now()) );
    }

}