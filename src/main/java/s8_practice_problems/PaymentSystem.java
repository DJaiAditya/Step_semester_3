package s8_practice_problems;

import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
    public abstract String getPaymentType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.02; } // 2% processing fee[cite: 11]
    @Override
    public String getPaymentType() { return "CARD"; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.01; } // 1% processing fee[cite: 11]
    @Override
    public String getPaymentType() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount; } // No processing fee[cite: 11]
    @Override
    public String getPaymentType() { return "BANKTRANSFER"; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else if (type.equals("BANKTRANSFER")) {
                payments[i] = new BankTransferPayment(amount);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Payment p : payments) {
            double adjusted = p.calculateAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f%n", p.getPaymentType(), adjusted); //[cite: 11]
        }
        System.out.printf("Total: %.2f%n", grandTotal); //[cite: 11]
    }
}