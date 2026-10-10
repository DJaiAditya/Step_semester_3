package s9_practice_problems;

import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();
    public abstract String getShapeName();
    public String getOwner() { return owner; }
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; // Circle area = pi * radius * radius[cite: 25]
    }

    @Override
    public String getShapeName() {
        return "CIRCLE"; //[cite: 25]
    }
}

class RectanglePlot extends Plot {
    private double length, width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width; // Rectangle area = length x width[cite: 25]
    }

    @Override
    public String getShapeName() {
        return "RECTANGLE"; //[cite: 25]
    }
}

class TrianglePlot extends Plot {
    private double base, height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height; // Triangle area = 1/2 x base x height[cite: 25]
    }

    @Override
    public String getShapeName() {
        return "TRIANGLE"; //[cite: 25]
    }
}

public class GardenReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            if (shape.equals("CIRCLE")) {
                double radius = scanner.nextDouble();
                plots[i] = new CirclePlot(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                plots[i] = new RectanglePlot(owner, length, width);
            } else if (shape.equals("TRIANGLE")) {
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                plots[i] = new TrianglePlot(owner, base, height);
            }
        }
        scanner.close();

        double totalArea = 0.0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShapeName(), area); //[cite: 25]
        }
        System.out.printf("Total Area: %.2f%n", totalArea); //[cite: 25]
    }
}