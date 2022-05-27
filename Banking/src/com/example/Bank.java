package com.example;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        Branch branch = findBranch(branchName);
        if(branch == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            boolean result = branch.newCustomer(customerName, initialTransaction);
            return result;
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            boolean result = branch.addCustomerTransaction(customerName, transaction);
            return result;
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            for(int customerCount = 0; customerCount < branch.getCustomers().size(); customerCount++) {
                System.out.println("Customer: " + branch.getCustomers().get(customerCount).getName() + "[" + (customerCount + 1) + "]");
                if(printTransactions) {
                System.out.println("Transactions");
                int transactionListLength = branch.getCustomers().get(customerCount).getTransactions().size();
                for (int transactionCount = 0; transactionCount < transactionListLength; transactionCount++) {
                    double specificTransaction = branch.getCustomers().get(customerCount).getTransactions().get(transactionCount);
                    System.out.println("[" + (transactionCount + 1) + "]  Amount " + specificTransaction);
                }
                }
            }
            return true;
        }
        return false;
    }

    private Branch findBranch(String branch) {
        for(int i = 0; i < branches.size(); i++) {
            String branchName = branches.get(i).getName();
            if (branchName == branch) {
                return this.branches.get(i);
            }

        }
        return null;
    }

}
