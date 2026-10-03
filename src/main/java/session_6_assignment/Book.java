package session_6_assignment;

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private double price;

    // Constructor to initialize state
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to apply discount
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            this.price -= this.price * (percentage / 100.0);
        }
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.printf("Price: $%.2f\n", price);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Original Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Discount Percentage: ");
        double discount = scanner.nextDouble();

        Book book = new Book(title, author, price);
        book.applyDiscount(discount);

        System.out.println("\n--- Updated Book Details ---");
        book.displayDetails();

        scanner.close();
    }
}
