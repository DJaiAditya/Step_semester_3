package s8_practice_problems;
import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();
    public abstract String getQuestionType();
}

class McqQuestion extends Question {
    public McqQuestion(String qt, String ca, String sa, int pts) { super(qt, ca, sa, pts); }
    @Override
    public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0; // Full points if exact match[cite: 14]
    }
    @Override
    public String getQuestionType() { return "MCQ"; }
}

class TfQuestion extends Question {
    public TfQuestion(String qt, String ca, String sa, int pts) { super(qt, ca, sa, pts); }
    @Override
    public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0; // Full points if exact match[cite: 14]
    }
    @Override
    public String getQuestionType() { return "TF"; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String qt, String ca, String sa, int pts) { super(qt, ca, sa, pts); }
    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        for (String kw : keywords) {
            String trimmedKw = kw.trim();
            if (!trimmedKw.isEmpty() && studentAnswer.toLowerCase().contains(trimmedKw.toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75; // 75% of points if at least two keywords[cite: 14]
        if (matchCount == 1) return points * 0.50; // 50% if one keyword[cite: 14]
        return 0.0;
    }
    @Override
    public String getQuestionType() { return "ESSAY"; }
}

public class ExaminationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        Question[] questions = new Question[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);

            // Simple parsing assuming quoted strings or space separation
            String remaining = line.substring(firstSpace + 1);
            // Parse tokens handling quotes or simple splits
            String[] parts = parseLine(remaining);
            String qt = parts[0];
            String ca = parts[1];
            String sa = parts[2];
            int pts = Integer.parseInt(parts[3]);

            if (type.equals("MCQ")) {
                questions[i] = new McqQuestion(qt, ca, sa, pts);
            } else if (type.equals("TF")) {
                questions[i] = new TfQuestion(qt, ca, sa, pts);
            } else if (type.equals("ESSAY")) {
                questions[i] = new EssayQuestion(qt, ca, sa, pts);
            }
        }
        scanner.close();

        double overallScore = 0.0;
        for (Question q : questions) {
            double score = q.grade();
            overallScore += score;
            System.out.printf("%s: %.2f%n", q.getQuestionType(), score); //[cite: 14]
        }
        System.out.printf("Total Score: %.2f%n", overallScore); //[cite: 14]
    }

    private static String[] parseLine(String text) {
        java.util.List<String> list = new java.util.ArrayList<>();
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("\"([^\"]*)\"|([^\\s]+)").matcher(text);
        while (m.find()) {
            if (m.group(1) != null) {
                list.add(m.group(1));
            } else {
                list.add(m.group(2));
            }
        }
        return list.toArray(new String[0]);
    }
}
