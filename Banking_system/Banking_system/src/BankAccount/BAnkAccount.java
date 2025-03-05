package BankAccount;

public class BAnkAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;
    private String password;

    public BAnkAccount(String accountNumber, double balance, String accountHolderName, String password) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.password = password;

    }
    public String getAccountNumber() {
        return accountNumber;

    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;

    }
    public  boolean authenticate( String password) {
        return this.password.equals(password);
    }
    public void calculateInterest(double annualInterest) {
        if (annualInterest > 0) {
            double interest = balance * annualInterest / 100;
            balance = balance + interest;
            System.out.println("The interest added is: " + interest + "% " + "New balance is: R" + balance);
        }
        else{
            System.out.println("Invalid interest");

        }

    }
    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);



    }
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;

            System.out.println("Deposited: R" + amount + " to " + accountNumber);
            System.out.println("Balance: R" + this.balance);
        }
        else {
            System.out.println("You can't deposit negative amount");
        }

    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawn: R" + amount + " to " + accountNumber);
            System.out.println("Balance: R" + this.balance);
        }
        else
        {
            System.out.println("Insufficient balance");
        }

    }
}
