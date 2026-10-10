package s8_practice_problems;

import java.util.Scanner;

abstract class Journey {
    protected double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getTransportType();
}

class BusJourney extends Journey {
    public BusJourney(double distance) { super(distance); }
    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance); // Base $2, plus $0.10 per km[cite: 15]
        return Math.min(10.0, fare); // Max fare $10[cite: 15]
    }
    @Override
    public String getTransportType() { return "BUS"; }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) { super(distance); }
    @Override
    public double calculateFare() { return 3.0 + (0.15 * distance); } // Base $3, plus $0.15 per km[cite: 15]
    @Override
    public String getTransportType() { return "TRAIN"; }
}

class MetroJourney extends Journey {
    private double peakHourFactor;
    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    @Override
    public double calculateFare() { return (1.50 + (0.20 * distance)) * peakHourFactor; } // Base $1.50, +$0.20/km multiplied by factor[cite: 15]
    @Override
    public String getTransportType() { return "METRO"; }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Journey[] journeys = new Journey[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            if (type.equals("BUS")) {
                journeys[i] = new BusJourney(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new TrainJourney(distance);
            } else if (type.equals("METRO")) {
                double factor = scanner.nextDouble();
                journeys[i] = new MetroJourney(distance, factor);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f%n", j.getTransportType(), fare); //[cite: 15, 16]
        }
        System.out.printf("Total: %.2f%n", grandTotal); //[cite: 16]
    }
}
