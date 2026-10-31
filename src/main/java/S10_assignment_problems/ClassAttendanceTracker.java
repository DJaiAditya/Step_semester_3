package S10_assignment_problems;

public class ClassAttendanceTracker {
    public static class Summary {
        public int presentDays;
        public int longestStreak;

        public Summary(int presentDays, int longestStreak) {
            this.presentDays = presentDays;
            this.longestStreak = longestStreak;
        }
    }

    public static Summary attendanceSummary(int[] days) {
        int presentCount = 0;
        int currentStreak = 0;
        int maxStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        return new Summary(presentCount, maxStreak);
    }
}