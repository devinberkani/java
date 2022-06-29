package numbers;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isExiting = false;
    static boolean isValidInput = false;
    static long userNumber;

    static long listLength = 1; // so that all current methods work if this number is not provided

    public static void main(String[] args) {
        printMenu();
    }

    static void printMenu() {
        System.out.println("Welcome to Amazing Numbers!");

        do {
            System.out.println("Supported requests:\n" +
                    "- enter a natural number to know its properties;\n" +
                    "- enter two natural numbers to obtain the properties of the list:\n" +
                    "  * the first parameter represents a starting number;\n" +
                    "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                    "- separate the parameters with one space;\n" +
                    "- enter 0 to exit.");

            // handle errors
            long[] userInput = validateInput();

            if (userInput.length == 1) {
                userNumber = userInput[0];
            } else {
                userNumber = userInput[0];
                listLength = userInput[1];
            }

            if (userNumber == 0) {
                isExiting = true;
                System.out.println("Goodbye!");
            } else {
                printProperties();
                listLength = 1; // reset listLength
                isValidInput = false; // in order to prevent infinite loop
            }

            // THIS IS WHERE YOU CURRENTLY ARE - YOU JUST GOT TO THE POINT WHERE YOU RETURNED AN ARRAY OF INPUT (EITHER ONE OR TWO NUMBERS) THROUGH VALIDATION BACK TO THIS POINT, AND SET USERNUMBER AND LISTLENGTH VARIABLES (DEFAULTS VALUE FOR LISTLENGTH IS 1)
            // First, make it so that listLength is used in all current methods in a loop so that as the listLength scales up, you can process things to work as they are WITH CURRENT FORMATTING
            // Next, change the formatting to pass the tests (formatting is different when there are more numbers)

        } while (!isExiting);
    }

    static long[] validateInput() {
        // error handling to determine if input is a natural number - must be a number greater than 0
        boolean firstNumberValid;
        boolean secondNumberValid = false;

        // initialize array to be returned with user input
        long[] userInputArr = new long[0];

        while (!isValidInput) {

            System.out.print("Enter a request: ");

            String userInput = scanner.nextLine();
            String[] userInputArrS = userInput.split(" ");

            int userInputArrLength = userInputArrS.length;

            // check to make sure number(s) are natural

            if (userInputArrLength == 1) {
                firstNumberValid = Integer.parseInt(userInputArrS[0]) >= 0;
                isValidInput = Integer.parseInt(userInputArrS[0]) >= 0;
            } else {
                firstNumberValid = Integer.parseInt(userInputArrS[0]) >= 0;
                secondNumberValid = Integer.parseInt(userInputArrS[1]) > 0;
                isValidInput = Integer.parseInt(userInputArrS[0]) >= 0 && Integer.parseInt(userInputArrS[1]) > 0;
            }

            if (!isValidInput) {
                if (!firstNumberValid) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if (!secondNumberValid) {
                    System.out.println("The second parameter should be a natural number.");
                }
            } else {
                if (userInputArrLength == 1) {
                    userInputArr = new long[1];
                    userInputArr[0] = Long.parseLong(userInputArrS[0]);
                } else {
                    userInputArr = new long[2];
                    userInputArr[0] = Long.parseLong(userInputArrS[0]);
                    userInputArr[1] = Long.parseLong(userInputArrS[1]);
                }
            }
        }
        return userInputArr;
    }

    static void printProperties() {
        System.out.println("Properties of " + userNumber);

        oddOrEven();
        buzzNumber();
        duckNumber();
        palindromicNumber();
        gapfulNumber();
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
        long lastDigit = userNumber % 10;
        boolean endsWith7 = lastDigit == 7;

        // determine if it is a buzz number and provide explanation
        boolean isBuzzNumber;

        // determination logic
        if (isDivisibleBy7 && endsWith7) {
            isBuzzNumber = true;
        } else if (isDivisibleBy7) {
            isBuzzNumber = true;
        } else if (endsWith7) {
            isBuzzNumber = true;
        } else {
            isBuzzNumber = false;
        }

        // buzz number or not printout
        if (isBuzzNumber) {
            System.out.println("buzz: true");
        } else {
            System.out.println("buzz: false");
        }

    }

    // is number a duck number - must contain a 0 (doesn't count if it only begins with one)
    static void duckNumber() {
        String userInput = String.valueOf(userNumber);
        boolean isDuckNumber = false;

        // go through each number in input and look for zeros
        for (String num : userInput.split("")) {
            if (num.equals("0")) {
                isDuckNumber = true;
                break;
            }
        }

        if (isDuckNumber) {
            System.out.println("duck: true");
        } else {
            System.out.println("duck: false");
        }
    }

    // is number palindromic - must be the same if reversed
    static void palindromicNumber() {
        long originalNumber = userNumber;
        long reversed = 0;

        // run loop until originalNumber becomes 0
        while(originalNumber != 0) {

            // get last digit from originalNumber
            long lastDigit = originalNumber % 10;
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

    // is number gapful - at least 3 digits and is divisible by first and last digit
    static void gapfulNumber() {

        // get user number split into array
        String[] userNumberArr = Long.toString(userNumber).split("");
        int userNumberLength = userNumberArr.length;

        // get first and last number
        String firstNumber = userNumberArr[0];
        String lastNumber = userNumberArr[userNumberLength - 1];

        // concat them to get new number
        String firstAndLastS = firstNumber + lastNumber;
        int firstAndLast = Integer.parseInt(firstAndLastS);

        boolean isGapful = userNumberLength >= 3 && userNumber % firstAndLast == 0;

        if (isGapful) {
            System.out.println("gapful: true");
        } else {
            System.out.println("gapful: false");
        }

    }

}
