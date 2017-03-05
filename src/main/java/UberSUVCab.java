package main.java;

public class UberSUVCab implements CabType {
    @Override
    public double calculateFare(double distance, double duration) {
        return 80 + (2 * duration) + (14 * distance);
    }
}
