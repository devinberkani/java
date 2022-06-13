package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void calculateIngredients(int cupsOfCoffee) {
        // ingredients for one cup

        int water = 200; //ml
        int milk = 50; //ml
        int coffeeBeans = 15; //g

        int waterNeeded = water * cupsOfCoffee;
        int milkNeeded = milk * cupsOfCoffee;
        int coffeeBeansNeeded = coffeeBeans * cupsOfCoffee;

        System.out.println("For " + cupsOfCoffee + " cups of coffee you will need:");
        System.out.println(waterNeeded + " ml of water");
        System.out.println(milkNeeded + " ml of milk");
        System.out.println(coffeeBeansNeeded + " g of coffee beans");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        System.out.println("Write how many cups of coffee you will need: ");

        int cupsOfCoffee = scanner.nextInt();

        calculateIngredients(cupsOfCoffee);

    }
}
