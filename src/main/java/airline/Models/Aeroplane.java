package airline.Models;

public class Aeroplane {

    private int aeroplaneId;
    private String modelNumber;
    private int noOfSeats;


    public Aeroplane(int aeroplaneId, String modelNumber, int noOfSeats)
    {
        this.aeroplaneId = aeroplaneId;
        this.modelNumber = modelNumber;
        this.noOfSeats = noOfSeats;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }





}
