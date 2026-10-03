package session_6_practice;

public class CollegeStudent {
    // Static variables common to all students
    private static String collegeName = "National Institute of Technology";
    private static int totalEnrolledStudents = 0;

    // Instance variables specific to each student
    private int rollNumber;
    private String name;

    public CollegeStudent(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
        totalEnrolledStudents++;
    }

    public void displayStudentDetails() {
        System.out.println("College: " + collegeName + " | Roll No: " + rollNumber + " | Name: " + name);
    }

    public static void displayTotalStudents() {
        System.out.println("Total Enrolled Students at " + collegeName + ": " + totalEnrolledStudents);
    }

    public static void main(String[] args) {
        CollegeStudent student1 = new CollegeStudent(101, "Ethan");
        CollegeStudent student2 = new CollegeStudent(102, "Sophia");
        CollegeStudent student3 = new CollegeStudent(103, "Liam");

        System.out.println("--- Student Details ---");
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        student3.displayStudentDetails();

        System.out.println("\n--- College Enrollment Statistics ---");
        CollegeStudent.displayTotalStudents();
    }
}
