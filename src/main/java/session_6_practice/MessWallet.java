package session_6_practice;

import java.util.Scanner;

public class MessWallet {
    private int studentId;
    private String studentName;
    private double balance;

    public MessWallet(int studentId, String studentName, double initialBalance) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.balance = Math.max(initialBalance, 0.0);
    }

    public void topUp(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("Successfully added $%.2f. New Balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Error: Top-up amount must be positive.");
        }
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deduction amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
        } else {
            this.balance -= amount;
            System.out.printf("Successfully deducted $%.2f. Remaining Balance: $%.2f\n", amount, balance);
        }
    }

    public void displayWallet() {
        System.out.printf("Student ID: %d | Name: %s | Current Balance: $%.2f\n", studentId, studentName, balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        MessWallet wallet = new MessWallet(id, name, balance);
        wallet.displayWallet();

        System.out.print("\nEnter Top-Up Amount: ");
        double topUpAmount = scanner.nextDouble();
        wallet.topUp(topUpAmount);

        System.out.print("\nEnter Meal Deduction Amount: ");
        double mealAmount = scanner.nextDouble();
        wallet.deduct(mealAmount);

        System.out.println("\n--- Final Status ---");
        wallet.displayWallet();

        scanner.close();
    }
}