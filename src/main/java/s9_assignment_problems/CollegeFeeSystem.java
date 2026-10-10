package s9_assignment_problems;

import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0; // Transport fee kept in one place[cite: 21, 22]
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();
    public String getName() { return name; }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) { super(name); }
    @Override
    public double calculateFee() { return 40000.0 + TRANSPORT_FEE; } // Tuition 40000 + transport fee[cite: 22]
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    @Override
    public double calculateFee() { return 40000.0 + 60000.0; } // Tuition 40000 + hostel fee 60000[cite: 22]
}

class ScholarStudent extends Student implements BusUser {
    public ScholarStudent(String name) { super(name); }
    @Override
    public double calculateFee() { return 20000.0 + TRANSPORT_FEE; } // Half normal tuition (20000) + transport fee[cite: 22]
}

public class CollegeFeeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String token1 = scanner.next();
            String token2 = scanner.next();
            String name;
            String type;
            if (token2.equals("SCHOLAR") || token2.equals("SCHOLARSHIP")) {
                type = token1 + "_" + token2;
                name = scanner.next();
            } else if (token1.equals("DAY") && token2.equals("SCHOLAR")) {
                type = "DAY_SCHOLAR";
                name = scanner.next();
            } else {
                type = token1;
                name = token2;
            }

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else if (type.equals("SCHOLAR") || type.equals("DAY_SCHOLAR")) { // fallback
                students[i] = new ScholarStudent(name);
            }
        }
        // Handle input scanning carefully if format varies
        scanner.close();
    }
}
