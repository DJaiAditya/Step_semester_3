package s9_assignment_problems;

import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
    public abstract String getParcelType();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override
    public double calculateCharge() { return 40.0 + (10.0 * weight); } // Standard: 40 plus 10 per kg[cite: 21]
    @Override
    public String getParcelType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override
    public double calculateCharge() { return 80.0 + (15.0 * weight); } // Express: 80 plus 15 per kg[cite: 21]
    @Override
    public double calculateInsurance(double declaredValue) { return declaredValue * 0.02; } // 2% of declared value[cite: 21]
    @Override
    public String getParcelType() { return "EXPRESS"; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override
    public double calculateCharge() { return (40.0 + (10.0 * weight)) + 50.0; } // Standard charge plus handling fee 50[cite: 21]
    @Override
    public double calculateInsurance(double declaredValue) { return declaredValue * 0.02; } // 2% of declared value[cite: 21]
    @Override
    public String getParcelType() { return "FRAGILE"; }
}

public class ParcelShippingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            if (type.equals("STANDARD")) {
                parcels[i] = new StandardParcel(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, declaredValue);
            } else if (type.equals("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, declaredValue);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = 0.0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).calculateInsurance(p.declaredValue);
            }
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.getParcelType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
