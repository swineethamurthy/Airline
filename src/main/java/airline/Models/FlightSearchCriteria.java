package airline.Models;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Optional;

public class FlightSearchCriteria {
    private String source;
    private String destination;
    private int noOfPassengers;
    private String departureDate;
    private Optional<LocalDate> departDate;


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

    public boolean isNull(Field field) {
            try {
                Object value = field.get(this);
                if (value != null) {
                    return false;
                }
            }
            catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        return true;

    }


}
