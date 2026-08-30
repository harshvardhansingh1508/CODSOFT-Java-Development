package Task3_ATMInterface;

public class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            return true;
        }

        return false;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}