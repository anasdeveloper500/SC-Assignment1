package task4.fixed;

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("Clean Code", "Robert C. Martin");
        Member m1 = new Member("Ali", 1);
        Member m2 = new Member("Zara", 2);

        m1.borrowBook(b1);   // succeeds
        m2.borrowBook(b1);   // correctly rejected - book already out

        m1.returnBook(b1);   // succeeds
        m2.borrowBook(b1);   // now succeeds, book is free again

        // b1.isIssued = false;  // <-- this line no longer even compiles,
        // because isIssued is private. That is the point of the fix.
    }
}
