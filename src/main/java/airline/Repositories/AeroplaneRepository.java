package airline.Repositories;

import airline.Models.Aeroplane;
import airline.Models.TravelClass;

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
        aeroplanes.add(new Aeroplane(1, "Boeing 777-200LR(77L)", getTravelClassDataForBoing()));
        aeroplanes.add(new Aeroplane(2, "Airbus A319" , getTravelClassDataFor319()));
        aeroplanes.add(new Aeroplane(3, "Airbus A321", getTravelClassDatafor321()));
        aeroplanes.add(new Aeroplane(4, "Boeing 777-200LR(77L)", getTravelClassDataForBoing()));
    }

    public List<TravelClass> getTravelClassDataForBoing()
    {
        List<TravelClass> travelClassList =  new ArrayList<TravelClass>();
        TravelClass classInfoForEconomy = new TravelClass(TravelClass.TravelType.ECONOMY, 195);
        TravelClass classInfoForBusiness = new TravelClass(TravelClass.TravelType.BUSINESS, 35);
        TravelClass classInfoForFirst = new TravelClass(TravelClass.TravelType.FIRST, 8);
        travelClassList.add(classInfoForEconomy);
        travelClassList.add(classInfoForBusiness);
        travelClassList.add(classInfoForFirst);
        return  travelClassList;
    }


    public List<TravelClass> getTravelClassDataFor319()
    {
        List<TravelClass> travelClassList =  new ArrayList<TravelClass>();
        TravelClass classInfoForEconomy = new TravelClass(TravelClass.TravelType.ECONOMY, 144);
        TravelClass classInfoForBusiness = new TravelClass(TravelClass.TravelType.BUSINESS, 0);
        TravelClass classInfoForFirst = new TravelClass(TravelClass.TravelType.FIRST, 0);
        travelClassList.add(classInfoForEconomy);
        travelClassList.add(classInfoForBusiness);
        travelClassList.add(classInfoForFirst);
        return  travelClassList;
    }

    public List<TravelClass> getTravelClassDatafor321()
    {
        List<TravelClass> travelClassList =  new ArrayList<TravelClass>();
        TravelClass classInfoForEconomy = new TravelClass(TravelClass.TravelType.ECONOMY, 25);
        TravelClass classInfoForBusiness = new TravelClass(TravelClass.TravelType.BUSINESS, 20);
        TravelClass classInfoForFirst = new TravelClass(TravelClass.TravelType.FIRST, 0);
        travelClassList.add(classInfoForEconomy);
        travelClassList.add(classInfoForBusiness);
        travelClassList.add(classInfoForFirst);
        return  travelClassList;
    }

}
