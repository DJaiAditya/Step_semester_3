package s7_practice_problems;

// Class Name: PiggyBank
public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0; // Starts at 0 savings[cite: 1]
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(double amount) {
        // Rejects withdrawal larger than current savings[cite: 1]
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
        }
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }
}
