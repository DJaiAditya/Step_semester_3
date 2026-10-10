package s9_assignment_problems;

import java.util.Scanner;

interface SaverModeSupported {
    double applySaverMode(double units);
}

abstract class Appliance {
    protected double hours;
    protected boolean saverRequested;

    public Appliance(double hours, boolean saverRequested) {
        this.hours = hours;
        this.saverRequested = saverRequested;
    }

    public abstract double getPowerRating();
    public abstract String getApplianceName();

    public double calculateUnits() {
        return (getPowerRating() * hours) / 1000.0; // Units(kWh) = power * hours / 1000[cite: 24]
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverRequested) { super(hours, saverRequested); }
    @Override
    public double getPowerRating() { return 150.0; } // Fridge 150 W[cite: 24]
    @Override
    public String getApplianceName() { return "FRIDGE"; }
}

class AcAppliance extends Appliance implements SaverModeSupported {
    public AcAppliance(double hours, boolean saverRequested) { super(hours, saverRequested); }
    @Override
    public double getPowerRating() { return 1500.0; } // AC 1500 W[cite: 24]
    @Override
    public String getApplianceName() { return "AC"; }
    @Override
    public double applySaverMode(double units) { return units * 0.75; } // Reduced by 25%[cite: 24]
}

class TvAppliance extends Appliance {
    public TvAppliance(double hours, boolean saverRequested) { super(hours, saverRequested); }
    @Override
    public double getPowerRating() { return 100.0; } // TV 100 W[cite: 24]
    @Override
    public String getApplianceName() { return "TV"; }
}

class WasherAppliance extends Appliance implements SaverModeSupported {
    public WasherAppliance(double hours, boolean saverRequested) { super(hours, saverRequested); }
    @Override
    public double getPowerRating() { return 500.0; } // Washer 500 W[cite: 24]
    @Override
    public String getApplianceName() { return "WASHER"; }
    @Override
    public double applySaverMode(double units) { return units * 0.75; } // Reduced by 25%[cite: 24]
}

public class ApplianceEnergySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        double totalCost = 0.0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");

            Appliance app = null;
            if (type.equals("FRIDGE")) {
                app = new Fridge(hours, saver);
            } else if (type.equals("AC")) {
                app = new AcAppliance(hours, saver);
            } else if (type.equals("TV")) {
                app = new TvAppliance(hours, saver);
            } else if (type.equals("WASHER")) {
                app = new WasherAppliance(hours, saver);
            }

            if (app != null) {
                if (saver && !(app instanceof SaverModeSupported)) {
                    System.out.println(app.getApplianceName() + ": saver mode not supported");
                    continue;
                }

                double units = app.calculateUnits();
                if (saver && app instanceof SaverModeSupported) {
                    units = ((SaverModeSupported) app).applySaverMode(units);
                }

                double cost = units * 8.0; // Cost = units * 8[cite: 24]
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getApplianceName(), units, cost);
            }
        }
        scanner.close();
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
