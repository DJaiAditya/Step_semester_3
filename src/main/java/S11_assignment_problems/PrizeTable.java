package S11_assignment_problems;

public class PrizeTable {
    public static class Result {
        int[] sortedMarks;
        int swaps;

        public Result(int[] sortedMarks, int swaps) {
            this.sortedMarks = sortedMarks;
            this.swaps = swaps;
        }
    }

    public static Result prizeTable(int[] marks) {
        if (marks == null) return new Result(new int[0], 0);
        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        return new Result(marks, swaps);
    }
}