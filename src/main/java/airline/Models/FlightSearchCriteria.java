package airline.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Optional;

public class FlightSearchCriteria {
    @NotEmpty(message = "Please enter your source.")
    private String source;
    @NotEmpty(message = "Please enter your destination.")
    private String destination;
    @Min(value=1)
    private int noOfPassengers;
    private String departureDate;
    private Optional<LocalDate> departDate;
    private TravelClass.TravelType casttravelClass;
    @NotEmpty(message = "Please enter your travel class.")
    private String travelClass;

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
        this.casttravelClass = getEnumByString(travelClass);
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {

        if(departureDate.isEmpty() || departureDate == null) {
            this.departDate = null;
        }
        else
            this.departDate = Optional.of(LocalDate.parse(departureDate));

        this.departureDate = departureDate;
    }

    public Optional<LocalDate> getParsedDate()
    {
        return this.departDate;
    }

    public TravelClass.TravelType getParsedTravelClass()
    {
        return this.casttravelClass;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public TravelClass.TravelType getEnumByString(String code){
        for(TravelClass.TravelType e : TravelClass.TravelType.values())
        {
            if(code.equals(e.displayName()))
                return e;
        }
        return null;
    }

}
