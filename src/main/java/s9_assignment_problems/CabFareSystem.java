package s9_assignment_problems;

import java.util.Scanner;

interface NightServiceable {
    double applyNightService(double fare);
}

abstract class Cab {
    protected double distance;
    protected String time;

    public Cab(double distance, String time) {
        this.distance = distance;
        this.time = time;
    }

    public abstract double calculateFare();
    public abstract String getCabType();

    protected double applyMinimum(double fare) {
        return Math.max(100.0, fare); // Never less than 100[cite: 23]
    }
}

class MiniCab extends Cab {
    public MiniCab(double distance, String time) { super(distance, time); }
    @Override
    public double calculateFare() {
        return applyMinimum(distance * 10.0); // Mini: 10 per km[cite: 22, 23]
    }
    @Override
    public String getCabType() { return "MINI"; }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double distance, String time) { super(distance, time); }
    @Override
    public double calculateFare() {
        double fare = applyMinimum(distance * 14.0); // Sedan: 14 per km[cite: 23]
        if (time.equals("NIGHT")) {
            fare = applyNightService(fare);
        }
        return fare;
    }
    @Override
    public double applyNightService(double fare) { return fare * 1.20; } // Adds 20% to fare[cite: 23]
    @Override
    public String getCabType() { return "SEDAN"; }
}

class SuvCab extends Cab implements NightServiceable {
    public SuvCab(double distance, String time) { super(distance, time); }
    @Override
    public double calculateFare() {
        double fare = applyMinimum(distance * 18.0); // SUV: 18 per km[cite: 23]
        if (time.equals("NIGHT")) {
            fare = applyNightService(fare);
        }
        return fare;
    }
    @Override
    public double applyNightService(double fare) { return fare * 1.20; } // Adds 20% to fare[cite: 23]
    @Override
    public String getCabType() { return "SUV"; }
}

public class CabFareSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            if (type.equals("MINI") && time.equals("NIGHT")) {
                System.out.println("MINI: night service not available");
                continue;
            }

            Cab cab = null;
            if (type.equals("MINI")) {
                cab = new MiniCab(km, time);
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab(km, time);
            } else if (type.equals("SUV")) {
                cab = new SuvCab(km, time);
            }

            if (cab != null) {
                double fare = cab.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
            }
        }
        scanner.close();
        System.out.printf("Total: %.2f%n", total);
    }
}
