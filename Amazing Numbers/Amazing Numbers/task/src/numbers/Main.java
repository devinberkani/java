package numbers;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public enum NumberSearchType {
        BUZZNUMBER
    }

    static NumberSearchType currentSearchType;

    public static void main(String[] args) {

        System.out.println("Enter a natural number:");

        String userInput = scanner.nextLine();
        int userNumber = 0;

        // error handling to determine if input is a natural number - must be a number greater than 0
        boolean isValid = false;

        for (String input : userInput.split("")) {
            if (!input.matches("\\d+")) {
                isValid = false;
            } else {
                userNumber = Integer.parseInt(userInput);
                isValid = userNumber > 0;
            }
        }

        if (!isValid) {
            System.out.println("This number is not natural!");
        } else {
            oddOrEven(userNumber);
            buzzNumber(userNumber);
        }
    }

    // is number odd or even - true means even, false means odd
    static void oddOrEven (int userNumber) {
        if (userNumber % 2 == 0) {
            System.out.println("This number is Even.");
        } else {
            System.out.println("This number is Odd.");
        }
    }

    // is number a buzz number - must be divisible by 7 or end with 7
    static void buzzNumber(int userNumber) {
        currentSearchType = NumberSearchType.BUZZNUMBER;

        // find out if divisible by 7
        boolean isDivisibleBy7 = userNumber % 7 == 0;

        // find out if ends with 7
        int lastDigit = userNumber % 10;
        boolean endsWith7 = lastDigit == 7;

        // determine if it is a buzz number and provide explanation
        boolean isBuzzNumber;
        String explanation;


        // explanation logic
        if (isDivisibleBy7 && endsWith7) {
            isBuzzNumber = true;
            explanation = " is divisible by 7 and ends with 7.";
        } else if (isDivisibleBy7) {
            isBuzzNumber = true;
            explanation = " is divisible by 7.";
        } else if (endsWith7) {
            isBuzzNumber = true;
            explanation = " ends with 7.";
        } else {
            isBuzzNumber = false;
            explanation = " is neither divisible by 7 nor does it end with 7.";
        }

        // buzz number or not printout
        if (isBuzzNumber) {
            System.out.println("It is a Buzz number.");
        } else {
            System.out.println("It is not a Buzz number.");
        }

        // explanation printout
        System.out.println("Explanation:");
        System.out.println(userNumber + explanation);

    }

}
