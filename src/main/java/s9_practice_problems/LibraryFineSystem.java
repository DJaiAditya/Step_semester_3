package s9_practice_problems;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();
    public String getTitle() { return title; }
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() {
        return daysLate * 2.0; // Books: 2 per day late[cite: 27]
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0); // DVDs: 5 per day late, up to a maximum of 50[cite: 27]
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) { super(title, daysLate); }
    @Override
    public double calculateFine() {
        return daysLate * 1.0; // Magazines: 1 per day late[cite: 27]
    }
}

public class LibraryFineSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            if (type.equals("BOOK")) {
                items[i] = new BookItem(title, daysLate);
            } else if (type.equals("DVD")) {
                items[i] = new DvdItem(title, daysLate);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new MagazineItem(title, daysLate);
            }
        }
        scanner.close();

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine); //[cite: 27]
        }
        System.out.printf("Total Fines: %.2f%n", totalFines); //[cite: 27]
    }
}