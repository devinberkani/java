package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);

    static int waterHad = 400; // ml
    static int milkHad = 540; // ml
    static int coffeeBeansHad = 120; // g
    static int disposableCupsHad = 9; // cups
    static int moneyHad = 550; // $

    // array of all items to be given to and returned by methods

    static int[] coffeeMachineArray = {waterHad, milkHad, coffeeBeansHad, disposableCupsHad, moneyHad};

    static boolean isComplete = false;

    public enum Status {
        CHOOSING, BUYING, FILLING, TAKING, REMAINING, EXITING
    }

    public static void main(String[] args) {

        Status choose = Status.CHOOSING;
        Status buy = Status.BUYING;
        Status fill = Status.FILLING;
        Status take = Status.TAKING;
        Status remaining = Status.REMAINING;
        Status exit = Status.EXITING;

        Status currentState = choose;

        while (!isComplete) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");

            String action = scanner.nextLine();

            switch(action) {
                case "buy":
                    currentState = buy;
                    break;

                case "fill":
                    currentState = fill;
                    break;

                case "take":
                    currentState = take;
                    break;

                case "remaining":
                    currentState = remaining;
                    break;

                case "exit":
                    currentState = exit;
                    break;

                default:
                    System.out.println("Please choose a valid action");
                    break;
            }

            switch(currentState) {

                case BUYING:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeSelection = scanner.nextLine();
                    buyCoffee(coffeeSelection, coffeeMachineArray);
                    break;

                case FILLING:
                    fillCoffeeMachine(coffeeMachineArray);
                    break;

                case TAKING:
                    take(coffeeMachineArray);
                    break;

                case REMAINING:
                    printRemaining(coffeeMachineArray);
                    break;

                case EXITING:
                    isComplete = true;
                    break;

                default:
                    break;
            }

        }
    }

    public static void buyCoffee(String coffeeSelection, int[] coffeeMachineArray) {
        if(!coffeeSelection.equals("back")) { // as long as selection does not equal back, continue
            int waterUsed = 0;
            int milkUsed = 0;
            int coffeeBeansUsed = 0;
            int disposableCupsUsed = 1;
            int moneyCollected = 0;

            if (coffeeSelection.equals("1")) { // espresso
                waterUsed = 250;
                coffeeBeansUsed = 16;
                moneyCollected = 4;
            } else if (coffeeSelection.equals("2")) { // latte
                waterUsed = 350;
                milkUsed = 75;
                coffeeBeansUsed = 20;
                moneyCollected = 7;
            } else if (coffeeSelection.equals("3")) { // cappuccino
                waterUsed = 200;
                milkUsed = 100;
                coffeeBeansUsed = 12;
                moneyCollected = 6;
            }

            String inventoryCheck = isEnoughIngredients(coffeeMachineArray, waterUsed, milkUsed, coffeeBeansUsed, disposableCupsUsed);

            if (inventoryCheck == null) {
                System.out.println("I have enough resources, making you a coffee!");
                coffeeMachineArray[0] -= waterUsed;
                coffeeMachineArray[1] -= milkUsed;
                coffeeMachineArray[2] -= coffeeBeansUsed;
                coffeeMachineArray[3] -= disposableCupsUsed;
                coffeeMachineArray[4] += moneyCollected;
            } else {
                System.out.println(inventoryCheck);
            }
        }
    }

    public static String isEnoughIngredients(int[] coffeeMachineArray, int waterUsed, int milkUsed, int coffeeBeansUsed, int disposableCupsUsed) {
        int waterHad = coffeeMachineArray[0];
        int milkHad = coffeeMachineArray[1];
        int coffeeBeansHad = coffeeMachineArray[2];
        int disposableCupsHad = coffeeMachineArray[3];

        waterHad -= waterUsed;
        milkHad -= milkUsed;
        coffeeBeansHad -= coffeeBeansUsed;
        disposableCupsHad -= disposableCupsUsed;

        if (waterHad < 0) {
            return "Sorry, not enough water!";
        } else if (milkHad < 0) {
            return "Sorry, not enough milk!";
        } else if (coffeeBeansHad < 0) {
            return "Sorry, not enough coffee beans!";
        } else if (disposableCupsHad < 0) {
            return "Sorry, not enough disposable cups!";
        }
        return null;
    }

    public static void fillCoffeeMachine(int[] coffeeMachineArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");

        int waterAdded = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");

        int milkAdded = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");

        int coffeeBeansAdded = scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");

        int disposableCupsAdded = scanner.nextInt();

        coffeeMachineArray[0] += waterAdded;
        coffeeMachineArray[1] += milkAdded;
        coffeeMachineArray[2] += coffeeBeansAdded;
        coffeeMachineArray[3] += disposableCupsAdded;
    }

    public static void take(int[] coffeeMachineArray) {
        System.out.println("I gave you $" + coffeeMachineArray[4]);

        coffeeMachineArray[4] = 0;
    }

    public static void printRemaining(int[] coffeeMachineArray) {
        System.out.println("The coffee machine has:\n" +
                coffeeMachineArray[0] + " ml of water\n" +
                coffeeMachineArray[1] + " ml of milk\n" +
                coffeeMachineArray[2] + " g of coffee beans\n" +
                coffeeMachineArray[3] + " disposable cups\n" +
                "$" + coffeeMachineArray[4] + " of money");
    }
}
