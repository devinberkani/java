package com.example;

public class Appliance {
    private String make;
    private String model;

    public Appliance(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
