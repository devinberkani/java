package com.example;

public class Hamburger {
    //base variables
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    //additions
    private String addition1Name;
    private String addition2Name;
    private String addition3Name;
    private String addition4Name;
    private double addition1Price;
    private double addition2Price;
    private double addition3Price;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
        System.out.println(this.name + " hamburger on a " + this.breadRollType + " roll with " + this.meat + ", price is " + this.price);
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;
        this.price += this.addition1Price;
        System.out.println("Added " + this.addition1Name + " for an extra " + this.addition1Price);
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;
        this.price += this.addition2Price;
        System.out.println("Added " + this.addition2Name + " for an extra " + this.addition2Price);
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;
        this.price += this.addition3Price;
        System.out.println("Added " + this.addition3Name + " for an extra " + this.addition3Price);

    }

    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;
        this.price += this.addition4Price;
        System.out.println("Added " + this.addition4Name + " for an extra " + this.addition4Price);
    }

    public double itemizeHamburger() {
        return this.price;
    }

}
