package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount > maxWithdrawalLimit)
            throw new WidthrawLimit("Maximum Withdraw Limit Exceed");
        if(getBalance() - amount < 0)
            throw new InsufBalance("Insufficient Balance");
        setBalance(getBalance() - amount);

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return getBalance() * rate * 1;

    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double power = times * years;
        return Math.pow(getBalance() * (1 + (rate / times)), power);
    }

}

class WidthrawLimit extends Exception {
    public WidthrawLimit(String message) {
        super(message);
    }
}

class InsufBalance extends Exception {
    public InsufBalance(String message) {
        super(message);
    }
}
