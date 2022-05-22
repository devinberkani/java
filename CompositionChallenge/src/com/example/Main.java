package com.example;

public class Main {
    public static void main(String[] args) {
        //write code below
        Refrigerator refrigerator = new Refrigerator("Kenmore", "PP6900");
        Dishwasher dishwasher = new Dishwasher("Whirlpool", "XXX6969693000");

        Kitchen kitchen = new Kitchen(refrigerator, dishwasher);

        kitchen.pressDishwasherButton();
        kitchen.pressDishwasherButton();
        kitchen.getRefrigerator().getTemperature();
        kitchen.getRefrigerator().decreaseTemperature();
        kitchen.getRefrigerator().increaseTemperature();

    }
}
