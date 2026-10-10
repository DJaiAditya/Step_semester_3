package s8_assignment_problems;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getVehicleType();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    @Override
    public double calculateCharge() { return hours * 10.0; } // 10 per hour[cite: 7]
    @Override
    public String getVehicleType() { return "BIKE"; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    @Override
    public double calculateCharge() {
        if (hours <= 1) return 30.0; // 30 for the first hour[cite: 7]
        return 30.0 + (hours - 1) * 20.0; // plus 20 for each additional hour[cite: 7]
    }
    @Override
    public String getVehicleType() { return "CAR"; }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0); // 50 per hour, minimum charge of 100[cite: 7]
    }
    @Override
    public String getVehicleType() { return "TRUCK"; }
}

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } else if (type.equals("TRUCK")) {
                vehicles[i] = new Truck(hours);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f%n", v.getVehicleType(), charge); //[cite: 7]
        }
        System.out.printf("Total: %.2f%n", grandTotal); //[cite: 7]
    }
}
