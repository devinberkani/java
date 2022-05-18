package com.example;

public class Main {
    public static void main(String[] args) {
        //write code below
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber("1234567890");
        System.out.println("confirming account number is " + bankAccount.getAccountNumber());

        bankAccount.setBalance(1000);
        System.out.println("confirming balance is " + bankAccount.getBalance());

        bankAccount.setCustomerName("Devin Berkani");
        System.out.println("confirming customer name is " + bankAccount.getCustomerName());

        bankAccount.setEmail("devin@example.com");
        System.out.println("confirming email is " + bankAccount.getEmail());

        bankAccount.setPhoneNumber("1234567890");
        System.out.println("confirming phone number is " + bankAccount.getPhoneNumber());

        bankAccount.depositFunds(500);
        System.out.println("after depositing $500, confirming new balance is " + bankAccount.getBalance());

        bankAccount.withdrawFunds(1000);
        System.out.println("after withdrawing $1000, confirming new balance is " + bankAccount.getBalance());

    }
}
