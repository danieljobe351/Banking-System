import Bank.Bank;
import BankAccount.BAnkAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Banking System Mneu ==== ");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account");
            System.out.println("5. Transfer Money");
            System.out.println("6. Calculate annual rate");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");

            input.nextLine();

            int choice = input.nextInt();
            switch (choice) {
                case 1 :{
                    System.out.println("Enter account number: ");
                    String account = input.nextLine();
                    System.out.println("Enter account holder name: ");
                    String holderName = input.nextLine();
                    System.out.println("set your account password: ");
                    String password = input.nextLine();
                    System.out.println("Enter initial money: R");
                    double money = input.nextDouble();
                    bank.createAccount(account,password,money,holderName);


                }
                case 2 :{
                    System.out.println("Enter account number: ");
                    String account = input.nextLine();
                    BAnkAccount accounT = bank.getAccount(account);
                    if (accounT == null) {
                        System.out.println("Account not found");
                    }else {
                        System.out.println("Enter amount to deposit: R");
                        double deposit = input.nextDouble();
                        accounT.deposit(deposit);

                    }
                }
                case 3 :{
                    System.out.println("Enter account number: ");

                    String account = input.nextLine();
                    BAnkAccount acoounT = bank.getAccount(account);
                    if (acoounT == null) {
                        System.out.println("Account not found");
                    }
                    else {
                        System.out.println("Enter amount to withdraw: R");
                        double withdraw = input.nextDouble();

                    }
                }
                case 4 :{
                    System.out.println("Enter account number: ");
                    String account = input.nextLine();
                    BAnkAccount acoounT = bank.getAccount(account);
                    if (acoounT == null) {
                        System.out.println("Account not found");
                    }
                    else {
                        acoounT.display();
                    }
                }
                case 5 :{
                    System.out.println("Enter sender account number: ");
                    String Saccount = input.nextLine();
                    System.out.println("Enter sender account password: ");
                    String password = input.nextLine();
                    System.out.println("Enter receiver account number: ");
                    String receiver = input.nextLine();

                    System.out.println("Enter amount to transfer: R");
                    double amount = input.nextDouble();

                    bank.transfer(Saccount,receiver,amount,password);

                }
                case 7 :{
                    System.out.println("Exiting system. Goodbye!");
                    break;
                }
                case 6:{
                    System.out.println("Enter account number: ");
                    String account = input.nextLine();
                    System.out.println("Enter account password: ");
                    String password = input.nextLine();
                    BAnkAccount acoounT = bank.getAccount(account);

                    bank.getAccount(account);
                     if(bank.authenticate(acoounT,password)){
                         System.out.println("Enter annual interest rate (%): ");
                         double interestRate = input.nextDouble();
                         acoounT.calculateInterest(interestRate);
                         bank.saveAccountToFile();

                     }
                     else {
                         System.out.println("Account authentication failed");

                     }

                }
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}