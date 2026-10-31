package S10_practice_problems;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        StringBuilder sb = new StringBuilder(word);
        String reverse = sb.reverse().toString();

        if (word.equals(reverse)) {
            System.out.println(word + " - palindrome");
        } else {
            System.out.println(reverse + " - not a palindrome");
        }
    }
}