// ORIGINAL AI-GENERATED CODE (typical output from prompting an AI with:
// "Write a Java program for a simple Library System using OOP.
//  Include classes for Book and Member.")

class Book {
    public String title;
    public String author;
    public boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Member {
    public String name;
    public int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Flaw: this method reaches directly into Book's public field and
    // sets it with no check on the CURRENT state of the book.
    public void borrowBook(Book book) {
        book.isIssued = true;
        System.out.println(name + " borrowed " + book.title);
    }

    public void returnBook(Book book) {
        book.isIssued = false;
        System.out.println(name + " returned " + book.title);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("Clean Code", "Robert C. Martin");
        Member m1 = new Member("Ali", 1);
        Member m2 = new Member("Zara", 2);

        m1.borrowBook(b1);
        m2.borrowBook(b1); // BUG: two members can "borrow" the same physical book!

        // Anyone, anywhere, can also do this directly - bypassing Member entirely:
        b1.isIssued = false;
    }
}
