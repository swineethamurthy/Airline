package airline.Controllers;

import airline.Models.FlightInformation;
import airline.Models.FlightSearchCriteria;
import airline.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;
    public FlightController()
    {

    }

    @RequestMapping("/")
    public String populateCitiesList(Model model)
    {
        model.addAttribute("cities",flightService.getPlaces());
        model.addAttribute( "flightSearchCriteria", new FlightSearchCriteria());
        return "flightSearch";
    }

    @RequestMapping(value = "/searchFlights" , method = RequestMethod.POST)
    public String searchFlights(@ModelAttribute(value="flightSearchCriteria") FlightSearchCriteria flightSearchCriteria, Model model)
    {

        model.addAttribute("cities",flightService.getPlaces());
        model.addAttribute("flights",flightService.searchFlights(flightSearchCriteria.getSource(),
                flightSearchCriteria.getDestination(),
                flightSearchCriteria.getNoOfPassengers());
        return "flightSearch";
    }


}
