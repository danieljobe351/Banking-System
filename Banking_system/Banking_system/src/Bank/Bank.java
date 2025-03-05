package Bank;

import BankAccount.BAnkAccount;

import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, BAnkAccount>accounts = new HashMap<>();
    private static final String FILE_NAME = "accounts.txt";
    private BAnkAccount currentAccount;
    public Bank() {
        loadFromFile();
    }
    public void createAccount(String accountNumber, String password, double balance,String accountholder) {
        if(accounts.containsKey(accountNumber))
        {
            System.out.println("Account number already exists");
        }
        else{
            BAnkAccount account = new BAnkAccount(accountNumber,balance,accountholder,password);
            accounts.put(accountNumber, account);
            saveAccountToFile();
            System.out.println("Account created");
        }

    }
    public BAnkAccount getAccount(String accountNumber)
    {
        return accounts.get(accountNumber);
    }
    public boolean authenticate(String accountN, String password) {
        BAnkAccount account = accounts.get(accountN);

        if(account != null && account.authenticate(password))
        {
            currentAccount = account;
            return true;
        }
        else {
            return true;
        }

    }
    public BAnkAccount getCurrentAccount() {
        return currentAccount;
    }
    public boolean isAdmin()
    {
        return currentAccount!=null && currentAccount.getAccountNumber().equals("Admin");

    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount, String fromPassword) {
        BAnkAccount sender = accounts.get(fromAccountNumber);
        BAnkAccount receiver = accounts.get(toAccountNumber);

        if(authenticate(sender,fromPassword))
        {
            if(sender != null && receiver != null)
            {
                if(sender.getBalance() >=amount)
                {
                    sender.withdraw(amount);
                    receiver.deposit(amount);
                    saveAccountToFile();
                    System.out.println("Account transfer successful");

                }
            }else {
                System.out.println("One or more accounts are not available");
            }
        }else {
            System.out.println("Authentication failed. Invalid password");
        }

    }
    public void saveAccountToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for( BAnkAccount account : accounts.values())
            {
                writer.write(account.getAccountNumber() + "," + account.getAccountHolderName() + "," + account.getBalance() + "," + account.authenticate(""));
                writer.newLine();
            }
        }catch (IOException e)
        {
            System.out.println("Error while saving accounts to file: " +
                    e.getMessage());
        }

    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if(!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while((line = reader.readLine()) !=null)
            {
                String[] tokens = line.split(",");
                if(tokens.length == 4) {
                    String accountNumber = tokens[0];
                    String accountHolder = tokens[1];
                    double balance = Double.parseDouble(tokens[2]);
                    String password = tokens[3];

                    accounts.put(accountNumber, new BAnkAccount(accountNumber, balance, accountHolder, password));
                }

            }


        }catch(IOException e)
        {
            System.out.println("Error loading accounts from file: " + e.getMessage());
        }

    }
}
