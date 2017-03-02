package main.java;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Trip {
    private Cab cab;
    private String pickupLocation;
    private String dropLocation;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocationService locationService = new LocationService();

    public  Trip(Cab cab)
    {
        this.cab = cab;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void start(String source, String start)
    {
        pickupLocation = source;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        startTime = LocalDateTime.parse(start,formatter);
    }

    public void complete(String destination, String end)
    {
        this.dropLocation = destination;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        endTime = LocalDateTime.parse(end,formatter);

    }

    public double getDuration()
    {
        return Duration.between(startTime,endTime).toMinutes();
    }

    public double getDistance()
    {
        return locationService.getDistanceBetweenLocation(pickupLocation,dropLocation);
    }

    public Cab getCab() {
        return cab;
    }

    public double getEstimatedDuration() {
        return new Random(60).nextDouble();
    }
}
