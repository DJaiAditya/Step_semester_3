package session_6_assignment;

public class CompanyEmployee {
    // Static variable shared across all instances
    private static int totalEmployeeCount = 0;
    private static String companyName = "Bright Horizon Tech";

    // Instance variables
    private int empId;
    private String name;

    public CompanyEmployee(int empId, String name) {
        this.empId = empId;
        this.name = name;
        totalEmployeeCount++; // Increment total count whenever a new employee is created
    }

    public void displayEmployeeDetails() {
        System.out.println("Company: " + companyName + " | ID: " + empId + " | Name: " + name);
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + ": " + totalEmployeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee emp1 = new CompanyEmployee(101, "Alex");
        CompanyEmployee emp2 = new CompanyEmployee(102, "Sarah");
        CompanyEmployee emp3 = new CompanyEmployee(103, "David");

        System.out.println("--- Employee Details ---");
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        emp3.displayEmployeeDetails();

        System.out.println("\n--- Company Statistics ---");
        CompanyEmployee.displayTotalEmployees();
    }
}