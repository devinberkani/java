package com.example;

public class Dishwasher extends Appliance {
    private int waterPressureSetting;
    private boolean dishWasherPower;

    public Dishwasher(String make, String model) {
        super(make, model);
        this.waterPressureSetting = 75;
        this.dishWasherPower = false;
    }

    public int getWaterPressureSetting() {
        return waterPressureSetting;
    }

    public void increaseWaterPressure() {
        this.waterPressureSetting += 1;
        System.out.println("Water pressure is now " + waterPressureSetting);
    }

    public void decreaseWaterPressure() {
        this.waterPressureSetting -= 1;
        System.out.println("Water pressure is now " + waterPressureSetting);
    }

    public void setDishWasherPower() {
        this.dishWasherPower = !dishWasherPower;
        String dishwasherOnOrOff = "";
        if(dishWasherPower) {
            dishwasherOnOrOff = "on";
        } else {
            dishwasherOnOrOff = "off";
        }
        System.out.println("Dishwasher is now " + dishwasherOnOrOff);
    }
}
