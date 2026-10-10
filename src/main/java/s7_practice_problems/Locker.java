package s7_practice_problems;

public class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String initialCombination) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCombination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}