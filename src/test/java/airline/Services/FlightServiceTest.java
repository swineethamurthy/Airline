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

    @Test
    public void ReadData()
    {
        MockSearchCriteriaRepository obj = new MockSearchCriteriaRepository();
        obj.readTestData();
    }

    @Test
    public void testSearchFlightsWithSourceAndDestination() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlightsWithSourceAndDestination("LKN", "BOM");
        assertEquals(2, flightInfoList.size());
    }

    @Test
    public void testSearchFlights() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        FlightSearchCriteria searchCriteria=new FlightSearchCriteria();
        searchCriteria.setSource("LKN");
        searchCriteria.setDestination("BOM");
        searchCriteria.setNoOfPassengers(2);
        searchCriteria.setDepartureDate("2017-09-08");
        searchCriteria.setTravelClass("ECONOMY");

        List<FlightInformation> flightInfoList = flightService.searchFlights(searchCriteria);
        assertEquals(0, flightInfoList.size());
    }


    /*@Test
    public void testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndDefaultNumberOfPassengers() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlights("LKN", "BOM",1, null, TravelClass.TravelType.ECONOMY);
        assertEquals(1, flightInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndNumberOfPassengers() throws Exception {
        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlights("LKN", "BOM",28, null, TravelClass.TravelType.ECONOMY);
        assertEquals(0, flightInfoList.size());
    }


    @Test
    public void testSearchFlightsWithSourceAndDestinationWithDepartureDateAndNumberOfPassengers() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlights("LKN", "BOM",28, Optional.of(LocalDate.now()), TravelClass.TravelType.ECONOMY);
        assertEquals(0, flightInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithDepartureDateAndDefaultNumberOfPassengers() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlights("LKN", "BOM",1, Optional.of(LocalDate.now()), TravelClass.TravelType.ECONOMY);
        assertEquals(0, flightInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithDepartureDateAndNumberOfPassengersBusinessClass() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlights("LKN", "BOM",24, Optional.of(LocalDate.now()), TravelClass.TravelType.ECONOMY);
        assertEquals(0, flightInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithDepartureDateAndDefaultNumberOfPassengersBusinessClass() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlights("LKN", "BOM",1, Optional.of(LocalDate.now()), TravelClass.TravelType.BUSINESS);
        assertEquals(0, flightInfoList.size());
    }

    @Test
    public void testSearchFlightsWithSourceAndDestinationWithNullDepartureDateAndNumberOfPassengersBusinessClass() throws Exception {

        Mockito.when(flightInfoRepo.getFlightInformation()).thenReturn(listOfMockFlights);
        List<FlightInformation> flightInfoList = flightService.searchFlights("LKN", "BOM",8, null, TravelClass.TravelType.BUSINESS);
        assertEquals(1, flightInfoList.size());
    }

    @Test
    public void searchFlightsWithDepartureDate() throws Exception {
    }*/

    /* Mock Repository */



}