package S10_assignment_problems;

public class BusiestBusRow {
    public static class RowResult {
        public int rowIndex;
        public int total;

        public RowResult(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }
    }

    public static RowResult busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentTotal += grid[i][j];
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = i;
            }
        }
        return new RowResult(bestRow, maxTotal);
    }
}