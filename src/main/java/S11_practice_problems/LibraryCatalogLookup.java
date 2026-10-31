package S11_practice_problems;
import java.util.List;

public class LibraryCatalogLookup {
    public static class BookRecord {
        String isbn;
        String title;

        public BookRecord(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static String findBook(List<BookRecord> catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            BookRecord current = catalog.get(mid);
            int cmp = current.isbn.compareTo(targetIsbn);

            if (cmp == 0) {
                return current.title;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Not Found";
    }
}