package S11_assignment_problems;

public class DiceThrowTally {
    public static class DiceResult {
        int[] sortedRolls;

        public DiceResult(int[] sortedRolls) {
            this.sortedRolls = sortedRolls;
        }
    }

    public static DiceResult diceSort(int[] rolls) {
        int[] count = new int[7]; // index 0 unused, 1 to 6 for dice faces

        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }

        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v < 6 ? " " : ""));
        }
        System.out.println();

        int[] sortedRolls = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sortedRolls[index++] = v;
            }
        }

        return new DiceResult(sortedRolls);
    }
}