# SC-Assignment-1-OOP

Software Construction - Assignment 01
Instructor: Engr. Rizwan Shah - UET Abbottabad Campus

## Structure
```
src/
  task1/                 -> DigitalWallet.java (Encapsulation)
  task2/                 -> Employee, Developer, SalesManager, Main.java (Inheritance & Polymorphism)
  task3/                 -> SmartDevice, SmartBulb, SmartThermostat, Main.java (Abstraction / Interfaces)
  task4/
    original/            -> LibrarySystem.java (unmodified AI-generated code, kept for comparison)
    fixed/                -> Book, Member, LibrarySystem.java (corrected version)
reflections/
  reflections.md          -> Written reflections for Tasks 1-3
  task4_critique.md        -> AI code review write-up for Task 4
```

## How to compile and run
From the project root:
```bash
# Task 1
javac -d out src/task1/DigitalWallet.java
java -cp out task1.DigitalWallet

# Task 2
javac -d out src/task2/*.java
java -cp out task2.Main

# Task 3
javac -d out src/task3/*.java
java -cp out task3.Main

# Task 4 - original (buggy) version
javac -d out src/task4/original/LibrarySystem.java
java -cp out LibrarySystem

# Task 4 - fixed version
javac -d out src/task4/fixed/*.java
java -cp out task4.fixed.LibrarySystem
```
