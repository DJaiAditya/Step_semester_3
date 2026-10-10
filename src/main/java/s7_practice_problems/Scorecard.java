package s7_practice_problems;
public class Scorecard {
    private boolean[] answers;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.answers = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean result) {
        if (recordedCount < answers.length) {
            answers[recordedCount] = result;
            recordedCount++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }
}