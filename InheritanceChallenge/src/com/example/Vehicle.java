package com.example;

public class Vehicle {
    private boolean isMoving;
    private boolean isChangingGears;
    private boolean isTurning;
    private int speed;

    public Vehicle(boolean isMoving, boolean isChangingGears, boolean isTurning, int speed) {
        this.isMoving = isMoving;
        this.isChangingGears = isChangingGears;
        this.isTurning = isTurning;
        this.speed = speed;
    }
}
