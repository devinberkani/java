package com.example;

public class Refrigerator extends Appliance {
    private int temperature;

    public Refrigerator(String make, String model) {
        super(make, model);
        this.temperature = 50;
    }

    public int getTemperature() {
        System.out.println("Refrigerator temperature is " + temperature);
        return temperature;
    }

    public void increaseTemperature() {
        this.temperature += 1;
        getTemperature();
    }

    public void decreaseTemperature() {
        this.temperature -= 1;
        getTemperature();
    }
}
