package s8_assignment_problems;

import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();
    public String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override
    public double calculateBonus() { return monthlySalary * 0.10; } // 10% of monthly salary[cite: 8, 9]
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override
    public double calculateBonus() { return monthlySalary * 0.05; } // 5% of monthly salary[cite: 9]
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) { super(name, monthlySalary); }
    @Override
    public double calculateBonus() { return 2000.0; } // Fixed bonus of 2,000[cite: 9]
}

public class BonusCalculatorSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            if (type.equals("FULLTIME")) {
                employees[i] = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employees[i] = new PartTimeEmployee(name, salary);
            } else if (type.equals("INTERN")) {
                employees[i] = new Intern(name, salary);
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f%n", e.getName(), bonus); //[cite: 9]
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal); //[cite: 9]
    }
}
