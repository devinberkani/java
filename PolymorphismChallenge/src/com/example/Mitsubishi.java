package com.example;

public class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "The Mitsubishi engine is starting";
    }

    @Override
    public String accelerate() {
        return "The Mitsubishi is accelerating";
    }

    @Override
    public String brake() {
        return "The Mitsubishi is braking";
    }

}
