package oops;

/**
 * ENCAPSULATION: The process of wrapping data (variables) and code (methods) 
 * together as a single unit. 
 * Key Benefits: Data Hiding, Security, and Ease of Testing.
 */
class BankAccount {
    
    // 1. DATA SECURITY (Private variables)
    // Variables are private so they cannot be accessed directly from outside the class.
    // This prevents unauthorized or accidental modification of sensitive data.
    private int account_number;
    private double balance;
    private String transactionHistory = "--- Transaction History ---\n"; 

    // Constructor: Used to initialize the object with valid data
    BankAccount(int accNo, double bal) {
        this.account_number = accNo;
        this.balance = bal;
        this.transactionHistory += "Account [" + accNo + "] opened with: " + bal + "\n";
    }

    // 2. ACCESSORS (Getters)
    // Provides "Read-Only" access to private fields.
    public int getAccountNumber() {
        return this.account_number;
    }

    public double getBankBalance() {
        return this.balance;
    }

    // 3. MUTATORS (Setters/Action Methods with Validation)
    // Encapsulation allows us to control HOW data is changed.
    // We add validation logic to ensure the internal state remains consistent.
    
    public void depositAmount(double amount) {
        if(amount > 0) {
            this.balance += amount;
            // Maintaining internal state (History) automatically
            this.transactionHistory += "Deposited: " + amount + " | Balance: " + this.balance + "\n";
            System.out.println("Success: Deposited " + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public void withdrawAmount(double amount) {
        // Business Logic Validation: Ensure amount is positive and balance is sufficient
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            this.transactionHistory += "Withdrew: " + amount + " | Balance: " + this.balance + "\n";
            System.out.println("Success: Withdrawn " + amount);
        } else if (amount > this.balance) {
            System.out.println("Error: Insufficient funds for withdrawal.");
        } else {
            System.out.println("Error: Invalid withdrawal amount.");
        }
    }

    // Displaying the internal state through a controlled method
    public void showHistory() {
        System.out.println("\n" + transactionHistory);
        System.out.println("Final Closing Balance: " + this.balance);
        System.out.println("---------------------------\n");
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        // Object creation using parameterized constructor
        BankAccount acc1 = new BankAccount(123456, 500.99);

        // ❌ Not allowed since balance is private
        // acc1.balance = 5000.67;

        // Interacting with the object through its public interface (methods)
        System.out.println("Action 1: Depositing Funds");
        acc1.depositAmount(499.01);

        System.out.println("\nAction 2: Withdrawing Funds");
        acc1.withdrawAmount(200);

        // Viewing the results
        // Note: We cannot do 'acc1.balance = -5000' because it is private. 
        // This is the core strength of Encapsulation.
        acc1.showHistory();
    }
}