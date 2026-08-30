package Task3_ATMInterface;

import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner sc;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    // Display ATM menu
    public void showMenu() {

        int choice;

        do {
            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + account.checkBalance());
    }

    // Deposit
    public void deposit(double amount) {

        if (account.deposit(amount)) {
            System.out.println("₹" + amount + " deposited successfully.");
            System.out.println("New Balance: ₹" + account.checkBalance());
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw
    public void withdraw(double amount) {

        if (account.withdraw(amount)) {
            System.out.println("₹" + amount + " withdrawn successfully.");
            System.out.println("Remaining Balance: ₹" + account.checkBalance());
        } else {
            if (amount > account.checkBalance()) {
                System.out.println("Insufficient balance!");
            } else {
                System.out.println("Invalid withdrawal amount!");
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        // Initial account balance
        BankAccount account = new BankAccount(10000);

        // Create ATM and connect it to bank account
        ATM atm = new ATM(account);

        // Start ATM
        atm.showMenu();
    }
}