package session_6_practice;
public class LibraryCard {
    private String studentName;
    private String cardId;
    private int booksIssued;

    public LibraryCard(String studentName, String cardId, int booksIssued) {
        this.studentName = studentName;
        this.cardId = cardId;
        this.booksIssued = booksIssued;
    }

    public void setBooksIssued(int booksIssued) {
        this.booksIssued = booksIssued;
    }

    public void displayCardInfo() {
        System.out.println("Student: " + studentName + " | Card ID: " + cardId + " | Books Issued: " + booksIssued);
    }

    public static void main(String[] args) {
        // Original Library Card object
        LibraryCard card1 = new LibraryCard("Alice", "LIB991", 2);

        // Reference pointing to the same object
        LibraryCard card2 = card1;

        System.out.println("--- Initial State ---");
        System.out.print("Card 1 Reference: ");
        card1.displayCardInfo();
        System.out.print("Card 2 Reference: ");
        card2.displayCardInfo();

        // Modifying books issued using card2 reference
        System.out.println("\nUpdating books issued to 4 using card2 reference...");
        card2.setBooksIssued(4);

        System.out.println("\n--- State After Modification ---");
        System.out.print("Card 1 Reference: ");
        card1.displayCardInfo();
        System.out.print("Card 2 Reference: ");
        card2.displayCardInfo();
    }
}