package main.java;

import java.util.HashMap;

public class LocationService {

    HashMap<String,Double> locationDistanceMap = new HashMap();

    public LocationService()
    {
        addLocationDistanceMapping();
    }

    private void addLocationDistanceMapping() {
        locationDistanceMap.put("Wakad-Kothrud",15.0);
        locationDistanceMap.put("Baner-Swargate",25.0);
    }

    public double getDistanceBetweenLocation(String source, String destination)
    {
        return locationDistanceMap.get(source+"-"+destination);
    }
}
