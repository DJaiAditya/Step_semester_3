package session_6_assignment;

import java.util.Scanner;

public class EmployeeProfile {
    private String name;
    private String department;
    private double salary;

    // Default constructor
    public EmployeeProfile() {
        this.name = "Unknown";
        this.department = "Unassigned";
        this.salary = 0.0;
    }

    // Constructor with name and department (Intern)
    public EmployeeProfile(String name, String department) {
        this.name = name;
        this.department = department;
        this.salary = 15000.0; // Default stipend for interns
    }

    // Constructor with all details
    public EmployeeProfile(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void displayProfile() {
        System.out.println("Name: " + name + " | Department: " + department + " | Salary: $" + salary);
    }

    public static void main(String[] args) {
        // Demonstrating Constructor Overloading
        EmployeeProfile emp1 = new EmployeeProfile();
        EmployeeProfile emp2 = new EmployeeProfile("Alice", "Marketing");
        EmployeeProfile emp3 = new EmployeeProfile("Bob", "Engineering", 75000.0);

        System.out.println("--- Employee Profiles ---");
        emp1.displayProfile();
        emp2.displayProfile();
        emp3.displayProfile();
    }
}
