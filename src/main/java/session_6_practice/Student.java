package session_6_practice;
import java.util.Scanner;

public class Student {
    private String name;
    private double cgpa;
    private String status;

    public Student(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
        this.status = "Pending";
    }

    public void updateStatus(boolean isPlaced) {
        if (isPlaced) {
            this.status = "Placed";
        } else {
            this.status = "Unplaced";
        }
    }

    public void displayDetails() {
        System.out.println("Student Name : " + name);
        System.out.printf("CGPA         : %.2f\n", cgpa);
        System.out.println("Status       : " + status);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();

        Student student = new Student(name, cgpa);

        System.out.print("Is the student placed? (true/false): ");
        boolean isPlaced = scanner.nextBoolean();

        student.updateStatus(isPlaced);

        System.out.println("\n--- Placement Record ---");
        student.displayDetails();

        scanner.close();
    }
}