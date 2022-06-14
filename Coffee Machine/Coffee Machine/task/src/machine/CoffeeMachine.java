package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static int numOfCups(int water, int milk, int coffeeBeans, int waterHad, int milkHad, int coffeeBeansHad) {
        int numOfCups = 0;
        while (waterHad >= water && milkHad >= milk && coffeeBeansHad >= coffeeBeans) {
            waterHad -= water;
            milkHad -= milk;
            coffeeBeansHad -= coffeeBeans;
            numOfCups++;
        }
        return numOfCups;
    }

    public static void calculateIngredients(int cupsOfCoffee, int waterHad, int milkHad, int coffeeBeansHad) {
        // ingredients for one cup

        int water = 200; //ml
        int milk = 50; //ml
        int coffeeBeans = 15; //g

//        int waterNeeded = water * cupsOfCoffee;
//        int milkNeeded = milk * cupsOfCoffee;
//        int coffeeBeansNeeded = coffeeBeans * cupsOfCoffee;

        int numOfCups = numOfCups(water, milk, coffeeBeans, waterHad, milkHad, coffeeBeansHad);

        int extraCups = numOfCups - cupsOfCoffee;

        if (numOfCups < cupsOfCoffee) {
            System.out.println("No, I can only make " + numOfCups + " cups(s) of coffee");
        } else if (numOfCups == cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        }

//        System.out.println("For " + cupsOfCoffee + " cups of coffee you will need:");
//        System.out.println(waterNeeded + " ml of water");
//        System.out.println(milkNeeded + " ml of milk");
//        System.out.println(coffeeBeansNeeded + " g of coffee beans");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");

        System.out.println("Write how many ml of water the coffee machine has: ");

        int waterHad = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");

        int milkHad = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");

        int coffeeBeansHad = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");

        int cupsOfCoffee = scanner.nextInt();

        calculateIngredients(cupsOfCoffee, waterHad, milkHad, coffeeBeansHad);

    }
}
