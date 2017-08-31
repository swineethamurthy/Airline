package airline;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepository {

    private List<Place> places = new ArrayList<Place>();
    public  PlaceRepository()
    {
        populatePlaces();
    }

    public void addPlace(Place place)
    {
        places.add(place);
    }

    public void removePlace(Place place)
    {
        places.remove(place);
    }

    public List<Place> getPlaces()
    {
        return places;
    }

    public void populatePlaces()
    {
        places.add(new Place("Hyd"));
        places.add(new Place("Mumbai"));
        places.add(new Place("Lkn"));

    }
}