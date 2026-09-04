package session_one_topic.assignment_problems;

import java.util.Scanner;

public class P3 {

    static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++)
            System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        printNumbersUpToN(n);
    }
}