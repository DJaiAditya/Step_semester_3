package S11_practice_problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeIdLookup {
    public static class Record {
        String employeeId;
        String department;

        public Record(String employeeId, String department) {
            this.employeeId = employeeId;
            this.department = department;
        }
    }

    public static Map<String, String> buildLookup(List<Record> records) {
        Map<String, String> lookup = new HashMap<>();
        for (Record r : records) {
            lookup.put(r.employeeId, r.department);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }
}