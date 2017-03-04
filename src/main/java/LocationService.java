package main.java;

import java.util.HashMap;

public class LocationService {

    HashMap<String,Double> locationDistanceMap = new HashMap();
    HashMap<String,Double> locationTimeMap = new HashMap();

    public LocationService()
    {
        addLocationDistanceMapping();
        addLocationTimeMapping();
    }

    private void addLocationDistanceMapping() {
        locationDistanceMap.put("Wakad-Kothrud",15.0);
        locationDistanceMap.put("Pashan-Kothrud",10.0);
        locationDistanceMap.put("Katraj-Swargate",7.0);
        locationDistanceMap.put("Baner-Swargate",25.0);
    }

    private void addLocationTimeMapping() {
        locationTimeMap.put("Wakad-Kothrud",60.0);
        locationTimeMap.put("Pashan-Kothrud",30.0);
        locationTimeMap.put("Katraj-Swargate",30.0);
        locationTimeMap.put("Baner-Swargate",60.0);
    }

    public double getDistanceBetweenLocation(String source, String destination)
    {
        return locationDistanceMap.get(source+"-"+destination);
    }

    public double getEstimatedTime(String source, String destination)
    {
        return locationTimeMap.get(source+"-"+destination);
    }
}
