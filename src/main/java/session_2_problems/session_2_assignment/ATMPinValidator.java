package session_2_problems.session_2_assignment;

import java.util.Scanner;

public class ATMPinValidator {

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

        ATMPinValidator obj = new ATMPinValidator();
        obj.checkPinLength(pin);
    }
}