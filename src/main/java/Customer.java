package main.java;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Trip> trips = new ArrayList();
    private static DecimalFormat decimalFormat = new DecimalFormat(".##");

    public Customer(String name)
    {
        this.name = name;
    }

    public String printReport()
    {
        StringBuilder report = new StringBuilder();
        report.append(header());
        report.append(tripDetails());
        report.append(footer());
        return report.toString();
    }

    private String footer() {
        return "\nYour total cab expenses are "+ decimalFormat.format(calculateTotal());
    }

    private String header() {
        StringBuilder header = new StringBuilder();
        header.append("Customer Name: "+ name);
        header.append("\n");
        return header.toString();
    }

    private String tripDetails() {
        StringBuilder tripDetails = new StringBuilder();
        for (Trip trip : trips) {
            tripDetails.append("\nTrip from "+trip.getPickupLocation()+" to "+trip.getDropLocation());
            tripDetails.append("\n");
            tripDetails.append("Trip distance is "+trip.getDistance()+" Km");
            tripDetails.append("\n");
            tripDetails.append("Trip duration is "+trip.getDuration()+" Minutes");
            tripDetails.append("\n");

            tripDetails.append("Fare for this trip is "+ decimalFormat.format(trip.calculatatefare(trip.getDistance(), trip.getDuration())));
            tripDetails.append("\n");
        }
        return tripDetails.toString();
    }

    private double calculateTotal()
    {
        double total = 0;
        for (Trip trip : trips) {
            total += trip.calculatatefare(trip.getDistance(),trip.getDuration());
        }
        return total;
    }

    public void completeTrip(Trip trip)
    {
        trips.add(trip);
    }
}
