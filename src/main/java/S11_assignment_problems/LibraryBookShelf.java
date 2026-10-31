package S11_assignment_problems;

import java.util.Arrays;

public class LibraryBookShelf {
    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) return;

        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
            System.out.println("After placing " + key + ":\n" + Arrays.toString(books));
        }
    }
}