package task4.fixed;

public class Member {
    private final String name;
    private final int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        // Member now asks the Book to change its own state, instead of
        // reaching in and setting a public field directly.
        if (book.markIssued()) {
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println(name + " could NOT borrow " + book.getTitle()
                    + " - it is already issued to someone else.");
        }
    }

    public void returnBook(Book book) {
        if (book.markReturned()) {
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println(name + " tried to return " + book.getTitle()
                    + ", but it was not marked as issued.");
        }
    }
}
