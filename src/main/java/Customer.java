package main.java;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Customer {
    private String name;
    private ArrayList<Trip> rides = new ArrayList();
    private static DecimalFormat df = new DecimalFormat(".##");

    public Customer(String name)
    {
        this.name = name;
    }

    public String printReport()
    {
        StringBuilder report = new StringBuilder();
        report.append("Customer Name: "+ name);
        report.append("\n");

        double totalFare=0;
        for (Trip item : rides) {
            report.append("Trip from "+item.getPickupLocation()+" to "+item.getDropLocation());
            report.append("\n");
            report.append("Trip distance is "+item.getDistance()+"km");
            report.append("\n");
            report.append("Trip duration is "+item.getDuration()+"minutes");
            report.append("\n");

            double fare = 0;
            switch(item.getCab().getCabType())
            {
                case Cab.uberGo:{
                    fare = item.getCab().getMinimumFare() + item.getCab().getDurationCharge() * item.getDuration() + item.getCab().getDistanceCharge() * item.getDistance();
                }
                case Cab.uberX:{
                    fare = item.getCab().getMinimumFare() + item.getCab().getDurationCharge() * item.getDuration() + item.getCab().getDistanceCharge() * item.getDistance();
                }
                case Cab.uberSUV:{
                    fare = item.getCab().getMinimumFare() + item.getCab().getDurationCharge() * item.getDuration() + item.getCab().getDistanceCharge() * item.getDistance();
                }
            }
            // add service tax
            fare += fare * 4.2/100;

            // add swachh bharat tax
            fare += fare * 0.15/100;

            // add krushi kalyan tax
            fare += fare * 0.15/100;

            totalFare += fare;
            report.append("Fare for this trip is "+df.format(fare));
            report.append("\n");
        }
        report.append("Your total cab expenses are "+df.format(totalFare));
        return report.toString();
    }

    public double calculateFareEstimate(Trip trip)
    {
        double fare = 0;
        switch(trip.getCab().getCabType())
        {
            case Cab.uberGo:{
                fare = trip.getCab().getMinimumFare() + trip.getCab().getDurationCharge() * trip.getEstimatedDuration()
                        + trip.getCab().getDistanceCharge() * trip.getDistance();
            }
            case Cab.uberX:{
                fare = trip.getCab().getMinimumFare() + trip.getCab().getDurationCharge() * trip.getEstimatedDuration()
                        + trip.getCab().getDistanceCharge() * trip.getDistance();
            }
            case Cab.uberSUV:{
                fare = trip.getCab().getMinimumFare() + trip.getCab().getDurationCharge() * trip.getEstimatedDuration()
                        + trip.getCab().getDistanceCharge() * trip.getDistance();
            }
        }
        return fare;
    }

    public void completeRide(Trip trip)
    {
        rides.add(trip);
    }
}
