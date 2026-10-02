package session_5_practice;

import java.util.Arrays;

public class TopThreePodiumFinder {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int s : scores) {
            if (s > first) {
                third = second;
                second = first;
                first = s;
            } else if (s > second) {   // also handles a tie with first
                third = second;
                second = s;
            } else if (s > third) {
                third = s;
            }
        }
        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] result = findTopThreeScores(new int[]{45, 82, 79, 90, 33, 90, 61});
        System.out.println(Arrays.toString(result));   // [90, 90, 82]
    }
}