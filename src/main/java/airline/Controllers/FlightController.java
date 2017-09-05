package airline.Controllers;

import airline.Models.FlightSearchCriteria;
import airline.Models.TravelClass;
import airline.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
        model.addAttribute("travelClasses",flightService.getTravelClasses());
        model.addAttribute( "flightSearchCriteria", new FlightSearchCriteria());
        return "flightSearch";
    }

    @RequestMapping(value = "/searchFlights" , method = RequestMethod.POST)
    public String searchFlights(@Valid @ModelAttribute(value="flightSearchCriteria") FlightSearchCriteria flightSearchCriteria,
                                BindingResult result,
                                        Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("cities", flightService.getPlaces());
            model.addAttribute("travelClasses",flightService.getTravelClasses());
        }
        else {
            FlightSearchCriteria obj = new FlightSearchCriteria();
            TravelClass.TravelType o = obj.getEnumByString("Economy");

            model.addAttribute("cities", flightService.getPlaces());
            model.addAttribute("travelClasses",flightService.getTravelClasses());
            model.addAttribute("flights", flightService.searchFlightsWithDepartureDate(
                    flightSearchCriteria.getSource(),
                    flightSearchCriteria.getDestination(),
                    flightSearchCriteria.getNoOfPassengers(),
                    flightSearchCriteria.getParsedDate(),
                    flightSearchCriteria.getEnumByString(flightSearchCriteria.getTravelClass())));
        }
        return "flightSearch";
    }


}
