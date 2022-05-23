package com.example;

public class Holden extends Car {
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "The Holden engine is starting";
    }

    @Override
    public String accelerate() {
        return "The Holden is accelerating";
    }

    @Override
    public String brake() {
        return "The Holden is braking";
    }

}
