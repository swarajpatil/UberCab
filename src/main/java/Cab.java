package main.java;

public class Cab {
     public static final int uberGo = 1;
     public static final int uberX = 2;
     public static final int uberSUV = 3;
    private int cabType;

    public Cab(int cabType)
     {
         this.cabType = cabType;
     }

    public int getCabType() {
        return cabType;
    }

    public double getMinimumFare() {
        double minimumFare = 0;
        switch (cabType) {
            case Cab.uberGo: {
                minimumFare = 40 ;
            }
            case Cab.uberX: {
                minimumFare = 45 ;
            }
            case Cab.uberSUV: {
                minimumFare = 80;
            }
        }
        return minimumFare;
    }

    public double getDurationCharge() {
        double durationCharge = 0;
        switch (cabType) {
            case Cab.uberGo: {
                durationCharge = 1;
            }
            case Cab.uberX: {
                durationCharge = 1.5;
            }
            case Cab.uberSUV: {
                durationCharge =  2;
            }
        }
        return durationCharge;
    }

    public double getDistanceCharge() {
        double distanceCharge = 0;
        switch (cabType) {
            case Cab.uberGo: {
                distanceCharge = 6 ;
            }
            case Cab.uberX: {
                distanceCharge = 9;
            }
            case Cab.uberSUV: {
                distanceCharge = 14;
            }
        }
        return distanceCharge;
    }
}
