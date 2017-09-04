package airline.Repositories;

import airline.Models.Aeroplane;

import java.util.ArrayList;
import java.util.List;

public class AeroplaneRepository {
    private List<Aeroplane> aeroplanes = new ArrayList<Aeroplane>();
    public  AeroplaneRepository()
    {
        populateAeroplanes();
    }


    public List<Aeroplane> getAeroplanes()
    {
        return aeroplanes;
    }

    public void populateAeroplanes()
    {
        aeroplanes.add(new Aeroplane(1, "Boeing 777-200LR(77L)", 100));
        aeroplanes.add(new Aeroplane(2, "Airbus A319 V2", 500));
        aeroplanes.add(new Aeroplane(3, "Airbus A321", 100));
        aeroplanes.add(new Aeroplane(4, "Boeing 777-200LR(77L)", 200));


    }

}
