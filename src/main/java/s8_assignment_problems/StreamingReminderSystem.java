package s8_assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscriber {
    protected String name;
    protected LocalDate startDate;

    public Subscriber(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate getRenewalDate();
    public String getName() { return name; }
}

class BasicSubscriber extends Subscriber {
    public BasicSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate getRenewalDate() { return startDate.plusDays(30); } // Valid for 30 days[cite: 9, 10]
}

class StandardSubscriber extends Subscriber {
    public StandardSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate getRenewalDate() { return startDate.plusDays(90); } // Valid for 90 days[cite: 9, 10]
}

class PremiumSubscriber extends Subscriber {
    public PremiumSubscriber(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate getRenewalDate() { return startDate.plusDays(365); } // Valid for 365 days[cite: 9, 10]
}

public class StreamingReminderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Subscriber[] subscribers = new Subscriber[n];

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());
            if (planType.equals("BASIC")) {
                subscribers[i] = new BasicSubscriber(name, startDate);
            } else if (planType.equals("STANDARD")) {
                subscribers[i] = new StandardSubscriber(name, startDate);
            } else if (planType.equals("PREMIUM")) {
                subscribers[i] = new PremiumSubscriber(name, startDate);
            }
        }
        scanner.close();

        for (Subscriber s : subscribers) {
            LocalDate renewalDate = s.getRenewalDate();
            System.out.println(s.getName() + ": " + renewalDate); //[cite: 10]
        }
    }
}