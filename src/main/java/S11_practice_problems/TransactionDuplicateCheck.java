package S11_practice_problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionDuplicateCheck {
    public static boolean hasDuplicate(List<String> transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }
}