package s8_assignment_problems;

import java.util.Scanner;

abstract class BillItem {
    protected double amount;

    public BillItem(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getTypeName();
}

class StudentBill extends BillItem {
    public StudentBill(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 0.90; } // 10% discount[cite: 6]
    @Override
    public String getTypeName() { return "STUDENT"; }
}

class StaffBill extends BillItem {
    public StaffBill(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 0.95; } // 5% discount[cite: 6]
    @Override
    public String getTypeName() { return "STAFF"; }
}

class GuestBill extends BillItem {
    public GuestBill(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount + 10.0; } // Full amount plus 10 service charge[cite: 6]
    @Override
    public String getTypeName() { return "GUEST"; }
}

public class CanteenBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        BillItem[] bills = new BillItem[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if (type.equals("STUDENT")) {
                bills[i] = new StudentBill(amount);
            } else if (type.equals("STAFF")) {
                bills[i] = new StaffBill(amount);
            } else if (type.equals("GUEST")) {
                bills[i] = new GuestBill(amount);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (BillItem bill : bills) {
            double finalAmt = bill.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f%n", bill.getTypeName(), finalAmt); //[cite: 6]
        }
        System.out.printf("Total: %.2f%n", grandTotal); //[cite: 6]
    }
}