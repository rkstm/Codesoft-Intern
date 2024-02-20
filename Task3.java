// Atm 

import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Fethch the current balance
    public double getBalance() {
        return balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    // Constructor
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Display ATM menu
    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Perform user-selected actions-
    public void performAction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Current Balance: $" + bankAccount.getBalance());
                break;

            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;

            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;

            case 4:
                System.out.println("Exiting the ATM. Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial balance
        BankAccount bankAccount = new BankAccount(1000.0);
        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            atm.performAction(choice, scanner);
        }
    }
}