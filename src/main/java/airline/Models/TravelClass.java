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
    private int basePrice;

    public TravelClass(TravelType traveltype, int noOfSeats,int basePrice)
    {
        this.travelClass = traveltype;
        this.noOfSeats = noOfSeats;
        this.basePrice = basePrice;
    }

    public TravelType getTravelClass() {
        return travelClass;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }
    


    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }


}
