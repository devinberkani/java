package com.example;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    //get account number
    public String getAccountNumber() {
        return this.accountNumber;
    }

    //set account number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        System.out.println("account number is set to " + getAccountNumber());
    }

    //get balance
    public double getBalance() {
        return this.balance;
    }

    //set balance
    public void setBalance(double balance){
        this.balance = balance;
    }

    //get customerName
    public String getCustomerName() {
        return this.customerName;
    }

    //set customerName
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        System.out.println("customer name is set to " + getCustomerName());
    }

    //get email
    public String getEmail() {
        return this.email;
    }

    //set email
    public void setEmail(String email) {
        this.email = email;
        System.out.println("customer email is set to " + getEmail());
    }

    //get phoneNumber
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    //set phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        System.out.println("phone number is set to " + getPhoneNumber());
    }

    //ADDITIONAL METHODS

    //deposit funds to balance
    public void depositFunds(double deposit) {
        setBalance(this.balance += deposit);
        System.out.println("Your balance is now " + this.balance);
    }

    //withdraw funds from balance
    public void withdrawFunds(double withdrawal) {
        if((this.balance - withdrawal) < 0) {
            System.out.println("Insufficient Funds");
        }
        setBalance(this.balance -= withdrawal);
        System.out.println("Your balance is now " + this.balance);
    }
}
