package main.java;

public class UberXCab implements CabType {
    @Override
    public double calculateFare(double distance, double duration) {
        return 45 + (1.5 * duration) + (9 * distance);
    }
}
