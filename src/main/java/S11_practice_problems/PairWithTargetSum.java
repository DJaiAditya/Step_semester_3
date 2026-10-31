package S11_practice_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (visited.contains(complement)) {
                return true;
            }
            visited.add(num);
        }
        return false;
    }
}