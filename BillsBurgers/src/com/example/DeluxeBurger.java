package com.example;

public class DeluxeBurger extends Hamburger {

    String name = "Deluxe";
    String meat = "Sausage & Bacon";
    double price = 14.54;
    String breadRollType = "White";

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 19.10, "White");
        double chipsPrice = 2.75;
        price += chipsPrice;
        System.out.println("Added Chips for an extra " + chipsPrice);
        double drinkPrice = 1.81;
        price += drinkPrice;
        System.out.println("Added Drink for an extra " + drinkPrice);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot add additional items to deluxe burger");
    }
}
