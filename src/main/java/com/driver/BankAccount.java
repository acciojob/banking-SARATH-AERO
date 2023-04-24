package com.driver;

import java.security.GeneralSecurityException;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int num = digits;
        int total = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }
        if (total == sum) {
            return String.valueOf(digits);
        } else {
            throw new GenerateAccountNumber("Account Number can not be generated");
        }

    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance - amount < minBalance)
            throw new Exception("Insufficient Balance");
        else
            balance = balance - amount;
    }

}

class GenerateAccountNumber extends Exception {
    public GenerateAccountNumber(String message1) {
        super(message1);
    }
}
class Balance extends Exception {
    public Balance(String message1) {
        super(message1);
    }
}