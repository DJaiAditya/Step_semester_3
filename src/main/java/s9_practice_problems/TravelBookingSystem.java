package s9_practice_problems;

import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;
    protected static final double BOOKING_FEE = 50.0; // Booking fee of 50 written in one place[cite: 29]

    public TravelBooking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();
    public abstract String getModeName();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distance) { super(distance); }
    @Override
    public double calculateBaseFare() { return distance * 2.0; } // Bus fare: 2 per km[cite: 29]
    @Override
    public String getModeName() { return "BUS"; }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distance) { super(distance); }
    @Override
    public double calculateBaseFare() { return distance * 1.5; } // Train fare: 1.5 per km[cite: 29]
    @Override
    public String getModeName() { return "TRAIN"; }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distance) { super(distance); }
    @Override
    public double calculateBaseFare() { return 2500.0 + (distance * 4.0); } // Flight fare: 2500 plus 4 per km[cite: 29]
    @Override
    public String getModeName() { return "FLIGHT"; }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else if (mode.equals("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            }
        }
        scanner.close();

        for (TravelBooking tb : bookings) {
            double total = tb.calculateTotal();
            System.out.printf("%s: %.2f%n", tb.getModeName(), total); //[cite: 29]
        }
    }
}
