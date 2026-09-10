package session_two_topic.assignment_problems;

import java.util.Scanner;

public class PINValidator {

    void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pin = sc.nextLine();

        PINValidator obj = new PINValidator();
        obj.checkPinLength(pin);
    }
}
