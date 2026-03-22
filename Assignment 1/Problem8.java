// Create custom exception handling for bank withdrawal scenario

import java.util.Scanner;

// Custom Exception Class
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {

    private double balance;

    // Constructor
    BankAccount(double balance) {
        this.balance = balance;
    }

    // Withdraw Method
    void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Error: Insufficient balance! Available balance = " + balance
            );
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance = " + balance);
        }
    }
}

// Main Class
public class Problem8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter account balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        // Create account
        BankAccount account = new BankAccount(balance);

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}