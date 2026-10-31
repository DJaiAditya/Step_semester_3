package S10_assignment_problems;

public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        int firstIdx = findFirstGreaterOrEqual(scores, low);
        if (firstIdx == -1) {
            return 0;
        }
        int lastIdx = findFirstGreaterThan(scores, high);
        if (lastIdx == -1) {
            lastIdx = scores.length;
        }
        return lastIdx - firstIdx;
    }

    private static int findFirstGreaterOrEqual(int[] scores, int target) {
        int low = 0, high = scores.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static int findFirstGreaterThan(int[] scores, int target) {
        int low = 0, high = scores.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}