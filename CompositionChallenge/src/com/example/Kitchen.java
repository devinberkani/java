package com.example;

public class Kitchen {
    private Refrigerator refrigerator;
    private Dishwasher dishwasher;

    public Kitchen(Refrigerator refrigerator, Dishwasher dishwasher) {
        this.refrigerator = refrigerator;
        this.dishwasher = dishwasher;
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }

    public void pressDishwasherButton() {
        dishwasher.setDishWasherPower();
    }
}
