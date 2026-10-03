package session_6_practice;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    // Default constructor
    public Course() {
        this.courseCode = "GEN100";
        this.courseName = "General Orientation";
        this.credits = 1;
    }

    // Overloaded constructor with code and name (defaults credits to 3)
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = 3;
    }

    // Overloaded constructor with all parameters
    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void displayCourse() {
        System.out.println("Code: " + courseCode + " | Name: " + courseName + " | Credits: " + credits);
    }

    public static void main(String[] args) {
        Course course1 = new Course();
        Course course2 = new Course("CS201", "Data Structures");
        Course course3 = new Course("CS401", "Machine Learning", 4);

        System.out.println("--- Course Details ---");
        course1.displayCourse();
        course2.displayCourse();
        course3.displayCourse();
    }
}