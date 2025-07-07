/**
 * A fully-encapsulated bank-account model.
 */
public final class BankAccount {

    /* ---------- private state (not accessible outside) ---------- */
    private final String owner;      // immutable once set
    private double balance;          // mutable, but guarded

    /* ---------- constructor ---------- */
    public BankAccount(String owner, double openingBalance) {
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.owner   = owner;
        this.balance = openingBalance;
    }

    /* ---------- public read-only accessors ---------- */
    public String getOwner()   { return owner; }
    public double getBalance() { return balance; }

    /* ---------- public behaviour (the only way to change state) ---------- */
    public void deposit(double amount) {
        validatePositive(amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        validatePositive(amount);
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    /* ---------- private helpers ---------- */
    private static void validatePositive(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
    }
}
