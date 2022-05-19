package com.example;

public class VipCustomer {
    private String name;
    private double creditLimit;
    private String email;


    public VipCustomer() {
        this("Tim", 1000, "tim@tim.com");
    }

    public VipCustomer(String name, String email) {
        this(name, 1000, email);
    }
    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}


