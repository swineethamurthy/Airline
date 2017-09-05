package airline.Models;

public class TravelClass {
    public enum TravelType {

        ECONOMY("Economy"),
        FIRST("First Class"),
        BUSINESS("Business Class");

        private String displayName;

        TravelType(String displayName) {
            this.displayName = displayName;
        }

        public String displayName() { return displayName; }

        @Override public String toString() { return displayName; }
    }

    private TravelType travelClass;
    private int noOfSeats;

    public TravelClass(TravelType traveltype, int noOfSeats)
    {
        this.travelClass = traveltype;
        this.noOfSeats = noOfSeats;
    }

    public TravelType getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelType travelClass) {
        this.travelClass = travelClass;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

}
