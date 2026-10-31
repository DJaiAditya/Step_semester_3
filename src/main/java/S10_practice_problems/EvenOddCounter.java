package S10_practice_problems;

import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        int[] arr = {3, 8, 12, 5, 7, 10};

        int even = 0;
        int odd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}