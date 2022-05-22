package com.example;

class Burger {
    private int buns;
    private int mayo;
}

class HealthyBurger extends Burger {

}

class BurgerFactory {
    public Burger createBurger() {
        return new Burger();
    }
}

class HealthyBurgerFactory extends BurgerFactory {

    @Override
    public HealthyBurger createBurger() {
        return new HealthyBurger();
    }
}