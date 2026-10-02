package session_5_practice;

import java.util.Arrays;

public class PlacementDriveEngine {

    public static void main(String[] args) {
        Candidate[] batch = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(Candidate.shortlistAndRank(batch));
        // 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}

class Candidate implements Comparable<Candidate> {
    // Eligibility thresholds (chosen to match the sample)
    private static final double CGPA_DIRECT = 7.5;      // CGPA alone is enough
    private static final double CGPA_BORDERLINE = 6.5;  // minimum CGPA for combined check
    private static final int CODING_MIN = 60;           // strong coding score for borderline CGPA

    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // composite = CGPA * 10 + codingScore * 0.5
    public double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    // CGPA-only quick filter
    static boolean isEligible(double cgpa) {
        return cgpa >= CGPA_DIRECT;
    }

    // Combined filter for borderline CGPA
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= CGPA_BORDERLINE && codingScore >= CODING_MIN;
    }

    @Override
    public int compareTo(Candidate other) {
        // descending by composite score
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) count++;
        }

        Candidate[] shortlisted = new Candidate[count];
        int idx = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted[idx++] = c;
            }
        }

        Arrays.sort(shortlisted);   // ranking done purely via compareTo

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ")
                    .append(shortlisted[i].name)
                    .append(" (")
                    .append(String.format("%.1f", shortlisted[i].getCompositeScore()))
                    .append(")");
        }
        return sb.toString();
    }
}
