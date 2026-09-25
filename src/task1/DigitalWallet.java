package task1;

/**
 * Task 1: The 'Broken Vault' - Encapsulation
 *
 * Fields are private (data hiding). The pin is set once via the constructor
 * and never exposed again. balance can only change through controlled
 * methods that enforce business rules.
 */
public class DigitalWallet {

    private final String accountHolder;
    private double balance;
    private final String pinCode; // never exposed via a getter

    public DigitalWallet(String accountHolder, double initialBalance, String pinCode) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        if (pinCode == null || pinCode.length() != 4) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits.");
        }
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.pinCode = pinCode; // set once, forever private
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Note: there is deliberately NO getPinCode() method.

    /**
     * Only succeeds if the PIN matches AND there are sufficient funds.
     * Returns false instead of throwing, so a wrong PIN attempt does not
     * crash the calling program (important in a real banking app).
     */
    public boolean withdraw(double amount, String enteredPin) {
        if (amount <= 0) {
            return false;
        }
        if (!this.pinCode.equals(enteredPin)) {
            return false;
        }
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
    }

    // Simple demo / manual test harness
    public static void main(String[] args) {
        DigitalWallet wallet = new DigitalWallet("Ayesha Khan", 5000.0, "4521");

        System.out.println("Starting balance: " + wallet.getBalance());

        boolean wrongPin = wallet.withdraw(1000, "0000");
        System.out.println("Withdraw with wrong PIN succeeded? " + wrongPin);
        System.out.println("Balance after wrong PIN attempt: " + wallet.getBalance());

        boolean tooMuch = wallet.withdraw(999999, "4521");
        System.out.println("Withdraw more than balance succeeded? " + tooMuch);

        boolean correct = wallet.withdraw(1500, "4521");
        System.out.println("Withdraw with correct PIN succeeded? " + correct);
        System.out.println("Balance after valid withdrawal: " + wallet.getBalance());

        wallet.deposit(300);
        System.out.println("Balance after deposit: " + wallet.getBalance());
    }
}
