package session_one_topic.assignment_problems;

import java.util.Scanner;

public class P4 {

    static void sumOfNaturalNumbers(int n) {
        int i = 1, sum = 0;

        while (i <= n) {
            sum += i;
            i++;
        }

        System.out.println("Sum = " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        sumOfNaturalNumbers(n);
    }
}