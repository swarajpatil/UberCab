package main.java;

public class UberGoCab implements CabType {
    @Override
    public double calculateFare(double distance, double duration) {
        return 40 + (1 * duration) + (6 * distance);
    }
}
