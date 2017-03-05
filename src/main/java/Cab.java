package main.java;

public class Cab {
     public static final int uberGo = 1;
     public static final int uberX = 2;
     public static final int uberSUV = 3;
    private int cabTypeCode;
    private CabType cabType;

    public Cab(int cabTypeCode)
     {
         this.cabTypeCode = cabTypeCode;
         cabType =  createCabType(cabTypeCode);
     }

    public double calculateFare(double distance, double duration) {
        double fare = cabType.calculateFare(distance,duration);
        fare += taxonFare(fare);
        return fare;
    }

    private double taxonFare(double fare) {
        return serviceTax(fare) + cleanIndiaTax(fare) + krishiTax(fare);
    }

    public CabType createCabType(int cabType)
    {
        switch(cabType)
        {
            case uberGo:{
              return new UberGoCab();
            }
            case uberX:{
                return  new UberXCab();
            }
            case uberSUV:{
                return  new UberSUVCab();
            }
        }
        return null;
    }

    private double krishiTax(double fare) {
        return fare * 0.15/100;
    }

    private double cleanIndiaTax(double fare) {
        return fare * 0.15/100;
    }

    private double serviceTax(double fare) {
        return fare * 4.2/100;
    }

    public double calculateFareEstimate(double distance, double duration)
    {
        return cabType.calculateFare(distance,duration);
    }
}
