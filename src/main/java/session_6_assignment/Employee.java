package session_6_assignment;

import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Method to modify salary securely
    public void updateSalary(double newSalary) {
        if (newSalary >= 0) {
            this.salary = newSalary;
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Error: Salary cannot be negative.");
        }
    }

    public void displaySalary() {
        System.out.printf("Employee ID: %d | Name: %s | Current Salary: $%.2f\n", id, name, salary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Base Salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(id, name, salary);
        emp.displaySalary();

        System.out.print("Enter New Salary to Update: ");
        double newSalary = scanner.nextDouble();

        emp.updateSalary(newSalary);
        emp.displaySalary();

        scanner.close();
    }
}
