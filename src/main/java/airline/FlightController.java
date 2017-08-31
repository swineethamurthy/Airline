package airline;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rajashrk on 8/8/17.
 */
@RestController
public class FlightController {

    @RequestMapping("/getFlights")
    public String getFlights() {
        return "flightSearch";
    }


}
