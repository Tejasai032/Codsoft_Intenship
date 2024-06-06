package JavaTasks;

import java.util.Scanner;

// Base class
class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("THE AMOUNT OF " + amount + " RUPEES IS DEPOSITED SUCCESSFULLY AND THE CURRENT BALANCE IS " + balance);
        } else {
            System.out.println("INVALID DEPOSIT AMOUNT");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("WITHDRAWAL AMOUNT OF " + amount + " RUPEES IS SUCCESSFUL AND CURRENT BALANCE IS " + balance);
        } else {
            System.out.println("INVALID WITHDRAWAL AMOUNT/INSUFFICIENT BALANCE");
        }
    }
}

// Derived class
class UserBankAccount extends BankAccount {

    public UserBankAccount(double initialBalance) {
        super(initialBalance);  // Call to the constructor of the base class
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Hello User, Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void procedure() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: Rs. ");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: Rs. ");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a GoodDay :)");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Atm_Interface {

    public static void main(String[] args) {
        UserBankAccount uba = new UserBankAccount(2000.0); 
        ATM atm = new ATM(uba);
        atm.procedure(); // Call the procedure to run the ATM operations
    }
}
