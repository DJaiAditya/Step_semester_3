package S10_practice_problems;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        boolean prime = true;

        if (num <= 1) {
            prime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }
        }

        if (prime) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " is not prime");
        }
    }
}