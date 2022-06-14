package machine;

import java.util.Scanner;

public class CoffeeMachine {

    //***YOU ARE STILL ON STAGE 4/6, JUST FINISHED TESTING BUYING ESPRESSO, STILL EARLY IN STAGE

    public static int[] buyCoffee(int coffeeSelection, int[] coffeeMachineArray) {
        int waterUsed = 0;
        int milkUsed = 0;
        int coffeeBeansUsed = 0;
        int disposableCupsUsed = 1;
        int moneyCollected = 0;

        if (coffeeSelection == 1) { // espresso
            waterUsed = 250;
            coffeeBeansUsed = 16;
            moneyCollected = 4;
        } else if (coffeeSelection == 2) { //latte
            waterUsed = 350;
            milkUsed = 75;
            coffeeBeansUsed = 20;
            moneyCollected = 7;
        } else if (coffeeSelection == 3) { //cappuccino
            waterUsed = 200;
            milkUsed = 100;
            coffeeBeansUsed = 12;
            moneyCollected = 6;
        }

        coffeeMachineArray[0] -= waterUsed;
        coffeeMachineArray[1] -= milkUsed;
        coffeeMachineArray[2] -= coffeeBeansUsed;
        coffeeMachineArray[3] -= disposableCupsUsed;
        coffeeMachineArray[4] += moneyCollected;

        return coffeeMachineArray;
    }

    public static void printMenu() {
        Scanner scanner = new Scanner(System.in);

        int waterHad = 400; // ml
        int milkHad = 540; // ml
        int coffeeBeansHad = 120; // g
        int disposableCupsHad = 9; // cups
        int moneyHad = 550; // $

        // array of all items to be given to and returned by methods

        int[] coffeeMachineArray = {waterHad, milkHad, coffeeBeansHad, disposableCupsHad, moneyHad};

        System.out.println("The coffee machine has:\n" +
                        coffeeMachineArray[0] + " ml of water\n" +
                        coffeeMachineArray[1] + " ml of milk\n" +
                        coffeeMachineArray[2] + " g of coffee beans\n" +
                        coffeeMachineArray[3] + " disposable cups\n" +
                        "$" + coffeeMachineArray[4] + " of money");

        System.out.println("Write action (buy, fill, take)");

        String action = scanner.nextLine();

        if (action.equalsIgnoreCase("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            int coffeeSelection = scanner.nextInt();
            coffeeMachineArray = buyCoffee(coffeeSelection, coffeeMachineArray);
        } else if (action.equalsIgnoreCase("fill")) {

        } else if (action.equalsIgnoreCase("take")) {

        } else {
            //put error here
        }

        System.out.println("The coffee machine has:\n" +
                coffeeMachineArray[0] + " ml of water\n" +
                coffeeMachineArray[1] + " ml of milk\n" +
                coffeeMachineArray[2] + " g of coffee beans\n" +
                coffeeMachineArray[3] + " disposable cups\n" +
                "$" + coffeeMachineArray[4] + " of money");

    }

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
        printMenu();
    }
}
