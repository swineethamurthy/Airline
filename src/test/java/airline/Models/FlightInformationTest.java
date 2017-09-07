package airline.Models;

import airline.MockFlightInformationRepository;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class FlightInformationTest {


    private MockFlightInformationRepository mockFlightInfoRepo = new MockFlightInformationRepository();

    @Test
    public void getNumberOfSeatsAvailable() throws Exception {
        FlightInformation flightInfo = mockFlightInfoRepo.getMockFlightInformationList().get(0);
        int availableSeats = flightInfo.getNumberOfSeatsAvailable(TravelClass.TravelType.ECONOMY);
        assertEquals(195,availableSeats);
    }

}