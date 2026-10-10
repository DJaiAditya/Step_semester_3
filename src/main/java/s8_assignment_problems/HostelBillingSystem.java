package s8_assignment_problems;

import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getRoomType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }
    @Override
    public double calculateBill() { return units * 8.0; } // 8 per unit[cite: 8]
    @Override
    public String getRoomType() { return "SINGLE"; }
}

class SharedRoom extends Room {
    private int occupants;
    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    @Override
    public double calculateBill() { return (units * 6.0) / occupants; } // 6 per unit, divided equally[cite: 8]
    @Override
    public String getRoomType() { return "SHARED"; }
}

class AcRoom extends Room {
    public AcRoom(int units) { super(units); }
    @Override
    public double calculateBill() { return (units * 10.0) + 200.0; } // 10 per unit, plus fixed charge of 200[cite: 8]
    @Override
    public String getRoomType() { return "AC"; }
}

public class HostelBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = scanner.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                rooms[i] = new AcRoom(units);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", r.getRoomType(), bill); //[cite: 8]
        }
        System.out.printf("Total: %.2f%n", grandTotal); //[cite: 8]
    }
}