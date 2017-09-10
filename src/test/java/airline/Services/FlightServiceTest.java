package airline.Services;

import airline.MockFlightInformationRepository;
import airline.MockSearchCriteriaRepository;
import airline.Models.FlightInformation;
import airline.Models.FlightSearchCriteria;
import airline.Repositories.FlightInformationRepository;
import airline.Repositories.PlaceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    private MockFlightInformationRepository mockFlightInfoRepo = new MockFlightInformationRepository();

    @MockBean
    @Qualifier("FlightsRepository")
    private FlightInformationRepository flightInfoRepo;
    @MockBean
    @Qualifier("PlacesRepository")
    private PlaceRepository placeRepository;

    private List<FlightInformation> listOfMockFlights = mockFlightInfoRepo.getMockFlightInformationList();
    MockSearchCriteriaRepository obj= new MockSearchCriteriaRepository();

    @Test
    public void testSearchFlightsWithSourceAndDestination() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlightsWithSourceAndDestination("LKN", "BOM");
        assertEquals(2, flightInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndDefaultNumberOfPassengers() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flighInfoList=flightService.searchFlights(obj.readTestData("testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndDefaultNumberOfPassengers"));
        assertEquals(1, flighInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndNumberOfPassengers() throws Exception {
        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flighInfoList=flightService.searchFlights(obj.readTestData("testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndNumberOfPassengers"));
        assertEquals(0, flighInfoList.size());
    }


    @Test
    public void testSearchFlightsWithSourceAndDestinationWithDepartureDateAndNumberOfPassengers() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flighInfoList=flightService.searchFlights(obj.readTestData("testSearchFlightsWithSourceAndDestinationWithDepartureDateAndNumberOfPassengers"));
        assertEquals(0, flighInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithDepartureDateAndDefaultNumberOfPassengers() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flighInfoList=flightService.searchFlights(obj.readTestData("testSearchFlightsWithSourceAndDestinationWithDepartureDateAndDefaultNumberOfPassengers"));
        assertEquals(0, flighInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithDepartureDateAndNumberOfPassengersBusinessClass() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flighInfoList=flightService.searchFlights(obj.readTestData("testSearchFlightsWithSourceAndDestinationWithDepartureDateAndNumberOfPassengersBusinessClass"));
        assertEquals(0, flighInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithDepartureDateAndDefaultNumberOfPassengersBusinessClass() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flighInfoList=flightService.searchFlights(obj.readTestData("testSearchFlightsWithSourceAndDestinationWithDepartureDateAndDefaultNumberOfPassengersBusinessClass"));
        assertEquals(0, flighInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndNumberOfPassengersBusinessClass() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flighInfoList=flightService.searchFlights(obj.readTestData("testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndNumberOfPassengersBusinessClass"));
        assertEquals(1, flighInfoList.size());
    }







}