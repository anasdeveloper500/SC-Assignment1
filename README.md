
## Task 1 — The 'Broken Vault' (Encapsulation)
Refactors a public-field `DigitalWallet` into a properly encapsulated class.
`pinCode` is set once via the constructor and never exposed again; `balance`
can never go negative; `withdraw()` only succeeds if the PIN matches and
funds are sufficient.

**Run:**
```bash
javac -d out src/task1/DigitalWallet.java
java -cp out task1.DigitalWallet
```

## Task 2 — The 'Evolving Workforce' (Inheritance & Polymorphism)
`Developer` and `SalesManager` both extend `Employee` and override
`calculatePay()`. A single `List<Employee>` holding both subtypes proves
runtime polymorphism — the correct pay formula is chosen based on each
object's actual class, not its declared type.

**Run:**
```bash
javac -d out src/task2/*.java
java -cp out task2.Main
```

## Task 3 — 'Design by Contract' (Abstraction)
`SmartDevice` is an interface guaranteeing `turnOn()`, `turnOff()`, and
`getStatus()`. `SmartBulb` and `SmartThermostat` implement it independently
and each adds its own unique method (`setBrightness`, `setTemperature`),
proving an interface can unify unrelated classes without forcing shared
inheritance.

**Run:**
```bash
javac -d out src/task3/*.java
java -cp out task3.Main
```

## Task 4 — The AI Code Review (Meta-Learning)
An AI was prompted with: *"Write a Java program for a simple Library System
using OOP. Include classes for Book and Member."* The result used public
fields and let two members "borrow" the same book simultaneously. The fixed
version encapsulates `isIssued` behind `markIssued()`/`markReturned()`
guard methods, closing the double-borrow bug. Full critique in
`reflections/task4_critique.md`.

**Run (original, buggy):**
```bash
javac -d out src/task4/original/LibrarySystem.java
java -cp out LibrarySystem
```

**Run (fixed):**
```bash
javac -d out src/task4/fixed/*.java
java -cp out task4.fixed.LibrarySystem
```

## Requirements
- JDK 17+ (or whatever your course's `javac -source`/`-target` requires)

## Key Takeaways
- Public fields let any class bypass an object's own validation rules —
  encapsulation closes that hole by forcing every state change through
  controlled methods.
- Polymorphism resolves *which* overridden method runs at runtime, based on
  the object's actual class, not the variable's declared type.
- Interfaces let unrelated classes share a behavioral contract without the
  constraints of single-class inheritance.
- Reviewing AI-generated code with an OOP lens — checking encapsulation and
  state-guarding logic, not just "does it compile" — catches real bugs
  before they ship.

