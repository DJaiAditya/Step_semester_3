package s8_practice_problems;

import java.util.Scanner;

abstract class DeliveryRequest {
    protected double weight;
    protected double distance;

    public DeliveryRequest(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getDeliveryType();
}

class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) { super(weight, distance); }
    @Override
    public double calculateFee() { return 5.0 + (0.50 * weight) + (0.10 * distance); } // Base $5, +0.50/kg, +0.10/km[cite: 13]
    @Override
    public String getDeliveryType() { return "STANDARD"; }
}

class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) { super(weight, distance); }
    @Override
    public double calculateFee() { return 15.0 + (1.00 * weight) + (0.20 * distance); } // Base $15, +1.00/kg, +0.20/km[cite: 13]
    @Override
    public String getDeliveryType() { return "EXPRESS"; }
}

class InternationalDelivery extends DeliveryRequest {
    private double customsFee;
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }
    @Override
    public double calculateFee() { return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee; } // Base $25, +2.00/kg, +0.50/km + customs[cite: 13]
    @Override
    public String getDeliveryType() { return "INTERNATIONAL"; }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        DeliveryRequest[] requests = new DeliveryRequest[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            if (type.equals("STANDARD")) {
                requests[i] = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                requests[i] = new ExpressDelivery(weight, distance);
            } else if (type.equals("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                requests[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (DeliveryRequest dr : requests) {
            double fee = dr.calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f%n", dr.getDeliveryType(), fee); //[cite: 13]
        }
        System.out.printf("Total: %.2f%n", grandTotal); //[cite: 13]
    }
}
