package S11_practice_problems;

public class WarehouseBinGridScan {
    public static class SummaryResult {
        int totalCount;
        int maxRow;
        int maxCol;

        public SummaryResult(int totalCount, int maxRow, int maxCol) {
            this.totalCount = totalCount;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }
    }

    public static SummaryResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new SummaryResult(0, -1, -1);
        }

        int totalCount = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = grid[i][j];
                totalCount += val;
                if (val > maxValue) {
                    maxValue = val;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new SummaryResult(totalCount, maxRow, maxCol);
    }
}