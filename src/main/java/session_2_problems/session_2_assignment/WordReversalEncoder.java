package session_2_problems.session_2_assignment;

import java.util.Scanner;

public class WordReversalEncoder {

    String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder reverse = new StringBuilder(word);
            result.append(reverse.reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        WordReversalEncoder obj = new WordReversalEncoder();
        System.out.println(obj.reverseEachWord(sentence));
    }
}