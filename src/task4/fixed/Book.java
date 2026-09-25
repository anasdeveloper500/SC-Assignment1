package task4.fixed;

/**
 * FIXED VERSION - Task 4
 * Fields are now private. isIssued can only change through the two
 * controlled methods below, and each one validates the current state
 * before acting, which closes the double-borrow bug.
 */
public class Book {
    private final String title;
    private final String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    /** Returns true only if the book was actually available to be issued. */
    public boolean markIssued() {
        if (isIssued) {
            return false; // already out - cannot be borrowed twice
        }
        isIssued = true;
        return true;
    }

    /** Returns true only if the book was actually out and is now returned. */
    public boolean markReturned() {
        if (!isIssued) {
            return false;
        }
        isIssued = false;
        return true;
    }
}
