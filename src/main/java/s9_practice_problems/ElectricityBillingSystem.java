package s9_practice_problems;

import java.util.Scanner;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getConnectionType();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) { super(units); }
    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0; // 5 per unit for the first 100 units[cite: 28]
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0); // and 7 per unit after that[cite: 28]
        }
    }
    @Override
    public String getConnectionType() { return "HOME"; }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) { super(units); }
    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0; // 8 per unit plus a fixed charge of 100[cite: 28]
    }
    @Override
    public String getConnectionType() { return "SHOP"; }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) { super(units); }
    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0); // 6 per unit, with a minimum bill of 1000[cite: 28]
    }
    @Override
    public String getConnectionType() { return "FACTORY"; }
}

public class ElectricityBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if (type.equals("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else if (type.equals("FACTORY")) {
                connections[i] = new FactoryConnection(units);
            }
        }
        scanner.close();

        double total = 0.0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", c.getConnectionType(), bill); //[cite: 28]
        }
        System.out.printf("Total: %.2f%n", total); //[cite: 28]
    }
}
