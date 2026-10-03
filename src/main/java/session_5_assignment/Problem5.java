package session_5_assignment;

import java.util.Arrays;

public class Problem5 {

    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        @Override
        public int compareTo(Player other) {
            // Sort by fantasy points / batting average descending
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    // Rule 1: Established players based only on matches played (e.g., threshold = 10)
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Combined rule for newer players (e.g., threshold = 5 matches and not injured)
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] tempDraftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            boolean eligible = isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured);
            if (eligible) {
                tempDraftable[count++] = p;
            }
        }

        Player[] draftable = Arrays.copyOf(tempDraftable, count);
        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].getName());
            if (i < draftable.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] squad = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(squad));
    }
}
