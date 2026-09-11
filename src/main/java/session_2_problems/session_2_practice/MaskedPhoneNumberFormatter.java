package session_2_problems.session_2_practice;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    String maskPhoneNumber(String phone) {

        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder result = new StringBuilder("XXXXXX");
        result.append("-");
        result.append(phone.substring(6));

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String phone = sc.nextLine();

        MaskedPhoneNumberFormatter obj = new MaskedPhoneNumberFormatter();
        System.out.println(obj.maskPhoneNumber(phone));
    }
}