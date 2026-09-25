# Reflections

## Task 1 - Encapsulation
If accountHolder, balance, and pinCode were public fields, any other class in
the codebase could write `wallet.balance = 999999999;` or
`wallet.balance = -500;` directly, with no validation and no audit trail.
In a real banking app this means a bug in a totally unrelated module (say, a
UI screen or a logging class) could accidentally set a customer's balance to
a negative number or fabricate money out of nowhere, and there would be no
single place in the code responsible for catching it. Worse, since pinCode
would also be public, any class that receives a Wallet object could read the
PIN in plain text - a serious security leak. Encapsulation fixes this by
forcing every change to go through withdraw()/deposit(), which is the one
place the balance-can't-be-negative rule is enforced.

## Task 2 - Polymorphism
When the loop does `e.calculatePay()` on a variable declared as type
Employee, Java does not decide which method to run at compile time based on
the declared type - it uses **dynamic method dispatch** at runtime, based on
the actual object stored in that variable. So when `e` is really pointing at
the `Developer` object "Bilal Ahmed", the JVM looks at Bilal's actual class
(Developer) and runs Developer's overridden calculatePay(), which adds
techAllowance. On the very next loop iteration, when `e` is now pointing at
the `SalesManager` object "Sara Malik", the JVM runs SalesManager's version
instead, which adds the commission. The Employee reference type only decides
what methods are *available* to call (the contract); the object's real class
decides *which version actually runs*. That's why one loop, written once,
correctly produces different pay formulas for Bilal and Sara without any
if/else or type-checking code.

## Task 3 - Abstraction / Interfaces
We used an interface instead of a base SmartDevice class with inheritance
because SmartBulb and SmartThermostat don't actually share any reusable
state or behavior - a bulb's brightness logic and a thermostat's temperature
logic have nothing in common to inherit. All we want to guarantee is that
every device in the system can be turned on, turned off, and report its
status, regardless of how differently each device implements those actions
internally. An interface lets unrelated classes make that same promise
without being forced into a shared parent class (Java only allows single
inheritance, so if SmartBulb ever needed to extend something else, class
inheritance would block that). This gives the software architect the
freedom to write code like `List<SmartDevice> devices` and loop over
completely different hardware types safely, while each concrete class stays
free to add its own unique methods (setBrightness, setTemperature) beyond
the contract.
