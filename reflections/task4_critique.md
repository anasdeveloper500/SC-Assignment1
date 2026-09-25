# Task 4 - AI Code Review

**Prompt used (exactly as given):**
"Write a Java program for a simple Library System using OOP. Include classes
for Book and Member."

**What the AI did well:**
It correctly split responsibilities into two classes, Book and Member, and
gave each one a constructor that initializes its own fields - a reasonable
first step toward OOP structure, and it correctly modeled a real-world
relationship (a Member acting on a Book).

**The flaw:**
Both classes used public fields (title, author, isIssued, name, memberId)
with no encapsulation, and borrowBook() blindly set `book.isIssued = true`
without first checking whether the book was already issued. That let two
different Members "successfully" borrow the same physical book at the same
time, and let any other class in the program flip a book's issued status
directly, bypassing Member entirely - the exact same kind of bug described
in Task 1.

**The fix:**
isIssued was made private, and Book now exposes markIssued()/markReturned()
methods that check the current state before changing it and report success
or failure back to the caller. Member calls these instead of touching the
field, so the double-borrow bug is now impossible and the book's state can
never be changed except through Book's own controlled methods.
