package S11_assignment_problems;

import java.util.Arrays;

public class HeightLineUp {
    public static void lineUp(int[] heights) {
        if (heights == null || heights.length <= 1) return;

        int n = heights.length;
        boolean swapped;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) {
                break;
            }
            pass++;
        }
    }
}