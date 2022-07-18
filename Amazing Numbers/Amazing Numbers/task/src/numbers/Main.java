package numbers;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static boolean isExiting = false;
    static boolean isValidInput = false;
    static int userNumber;

    public static void main(String[] args) {
        printMenu();
    }

    static void printMenu() {
        System.out.println("Welcome to Amazing Numbers!");

        do {
            System.out.println("Supported requests:\n" +
                    "- enter a natural number to know its properties;\n" +
                    "- enter 0 to exit.");

            // handle errors
            userNumber = ValidateInput();

            if (userNumber == 0) {
                isExiting = true;
                System.out.println("Goodbye!");
            } else {
                printProperties(userNumber);
                isValidInput = false; // in order to prevent infinite loop
            }

        } while (!isExiting);
    }

    static int ValidateInput() {
        // error handling to determine if input is a natural number - must be a number greater than 0
        while (!isValidInput) {

            System.out.print("Enter a request: ");

            String userInput = scanner.nextLine();

            for (String input : userInput.split("")) {
                if (!input.matches("\\d+")) {
                    isValidInput = false;
                    break;
                } else {
                    isValidInput = true;
                }
            }
            if (!isValidInput) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else {
                userNumber = Integer.parseInt(userInput);
                isValidInput = userNumber >= 0;
            }
        }
        return userNumber;
    }

    static void printProperties(int userNumber) {
        System.out.println("Properties of " + userNumber);

        oddOrEven();
        buzzNumber();
        duckNumber();
        palindromicNumber();
    }

    // is number odd or even - true means even, false means odd
    static void oddOrEven () {
        if (userNumber % 2 == 0) {
            System.out.println("even: true");
            System.out.println("odd: false");
        } else {
            System.out.println("even: false");
            System.out.println("odd: true");
        }
    }

    // is number a buzz number - must be divisible by 7 or end with 7
    static void buzzNumber() {

        // find out if divisible by 7
        boolean isDivisibleBy7 = userNumber % 7 == 0;

        // find out if ends with 7
        int lastDigit = userNumber % 10;
        boolean endsWith7 = lastDigit == 7;

        // determine if it is a buzz number and provide explanation
        boolean isBuzzNumber;
//        String explanation;


        // determination logic
        if (isDivisibleBy7 && endsWith7) {
            isBuzzNumber = true;
//            explanation = " is divisible by 7 and ends with 7.";
        } else if (isDivisibleBy7) {
            isBuzzNumber = true;
//            explanation = " is divisible by 7.";
        } else if (endsWith7) {
            isBuzzNumber = true;
//            explanation = " ends with 7.";
        } else {
            isBuzzNumber = false;
//            explanation = " is neither divisible by 7 nor does it end with 7.";
        }

        // buzz number or not printout
        if (isBuzzNumber) {
            System.out.println("buzz: true");
        } else {
            System.out.println("buzz: false");
        }

//        // explanation printout
//        System.out.println("Explanation:");
//        System.out.println(userNumber + explanation);

    }

    // is number a duck number - must contain a 0 (doesn't count if it only begins with one)
    static void duckNumber() {
        String userInput = String.valueOf(userNumber);
        boolean isDuckNumber = false;

        // go through each number in input and look for zeros
        for (String num : userInput.split("")) {
            if (num.equals("0")) {
                isDuckNumber = true;
            }
        }

        if (isDuckNumber) {
            System.out.println("duck: true");
        } else {
            System.out.println("duck: false");
        }
    }

    static void palindromicNumber() {
        int originalNumber = userNumber;
        int reversed = 0;

        // run loop until originalNumber becomes 0
        while(originalNumber != 0) {

            // get last digit from originalNumber
            int lastDigit = originalNumber % 10;
            reversed = reversed * 10 + lastDigit;

            //remove the last digit from originalNumber;
            originalNumber /= 10;
        }

        boolean isPalindrome = userNumber == reversed;

        if (isPalindrome) {
            System.out.println("palindromic: true");
        } else {
            System.out.println("palindromic: false");
        }
    }

}
