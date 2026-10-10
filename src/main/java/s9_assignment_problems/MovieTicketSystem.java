package s9_assignment_problems;

import java.util.Scanner;

interface Ticket {
    int CONVENIENCE_FEE = 20; // Convenience fee written in one place[cite: 20]
    double calculateAmount();
    String getSeatType();
}

abstract class BaseTicket implements Ticket {
    protected int count;

    public BaseTicket(int count) {
        this.count = count;
    }

    protected double calculateBaseTotal(double pricePerTicket) {
        return (pricePerTicket + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends BaseTicket {
    public RegularTicket(int count) { super(count); }
    @Override
    public double calculateAmount() { return calculateBaseTotal(150.0); } // Regular: 150 per ticket[cite: 20]
    @Override
    public String getSeatType() { return "REGULAR"; }
}

class PremiumTicket extends BaseTicket {
    public PremiumTicket(int count) { super(count); }
    @Override
    public double calculateAmount() { return calculateBaseTotal(250.0); } // Premium: 250 per ticket[cite: 20]
    @Override
    public String getSeatType() { return "PREMIUM"; }
}

class ReclinerTicket extends BaseTicket {
    public ReclinerTicket(int count) { super(count); }
    @Override
    public double calculateAmount() { return calculateBaseTotal(400.0); } // Recliner: 400 per ticket[cite: 20]
    @Override
    public String getSeatType() { return "RECLINER"; }
}

public class MovieTicketSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();
            if (type.equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } else if (type.equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } else if (type.equals("RECLINER")) {
                tickets[i] = new ReclinerTicket(count);
            }
        }
        scanner.close();

        double total = 0.0;
        for (Ticket t : tickets) {
            double amt = t.calculateAmount();
            total += amt;
            System.out.printf("%s: %.2f%n", t.getSeatType(), amt);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
