package com.example;

public class Main {
    public static void main(String[] args) {
//        //test customer class
//        Customer customer = new Customer("Devin", 5.00);
//        System.out.println(customer.getTransactions());
//        customer.addTransaction(3.0);
//        System.out.println(customer.getTransactions());
//
        //test branch class
        Branch branch = new Branch("Directions");
        branch.newCustomer("Billy", 10.0);
        System.out.println(branch.newCustomer("Bob", 10.0));

//        //test bank class
//        Bank bank = new Bank("National Australia Bank");
//
//        bank.addBranch("Adelaide");
//
//        bank.addCustomer("Adelaide", "Tim", 50.05);
//        bank.addCustomer("Adelaide", "Mike", 175.34);
//        bank.addCustomer("Adelaide", "Percy", 220.12);
//
//        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
//        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
//        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);
//
//        bank.listCustomers("Adelaide", false);


    }
}
