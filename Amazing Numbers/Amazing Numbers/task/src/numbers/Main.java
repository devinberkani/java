package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isExiting = false;
    static boolean isValidInput = false;
    static long userNumber;
    static long listLength = 1; // so that all current methods work if this number is not provided
    static long userInputArrLength;

    public static void main(String[] args) {
        printMenu();
    }

    static void printMenu() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        do {

            // handle errors - get input array
            long[] userInput = validateInput();
            userInputArrLength = userInput.length;

            if (userInputArrLength == 1) {
                userNumber = userInput[0];
            } else {
                userNumber = userInput[0];
                listLength = userInput[1];
            }

            if (userNumber == 0) {
                isExiting = true;
                System.out.println("Goodbye!");
            } else {
                long printsLeft = listLength; // number of times to print properties
                while (printsLeft > 0) {
                    printProperties(printsLeft);
                    userNumber++; // add one to the userNumber after every print
                    printsLeft--;
                }
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
        boolean firstNumberValid = false;
        boolean secondNumberValid = false;

        // initialize array to be returned with user input
        long[] userInputArr = new long[0];

        while (!isValidInput) {

            System.out.print("Enter a request: ");

            String userInput = scanner.nextLine();

            String[] userInputArrS = userInput.split(" ");

            int userInputArrLength = userInputArrS.length;

            // check to make sure input is a number

            if (userInputArrS[0].matches("\\d+")) {

                // check to make sure number(s) are natural

                if (userInputArrLength == 1) {
                    firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    isValidInput = Long.parseLong(userInputArrS[0]) >= 0;
                } else {
                    firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    secondNumberValid = Long.parseLong(userInputArrS[1]) > 0;
                    isValidInput = Long.parseLong(userInputArrS[0]) >= 0 && Long.parseLong(userInputArrS[1]) > 0;
                }
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

    static void printProperties(long printsLeft) {

        if (userInputArrLength == 1) {
            System.out.println("Properties of " + userNumber);
            System.out.println(buzzNumber());
            System.out.println(duckNumber());
            System.out.println(palindromicNumber());
            System.out.println(gapfulNumber());
            System.out.println(oddOrEven());
        } else {
            List<String> properties = new ArrayList<>();
            properties.add(buzzNumber());
            properties.add(duckNumber());
            properties.add(palindromicNumber());
            properties.add(gapfulNumber());
            properties.add(oddOrEven());
            // remove nulls
            properties.removeIf(Objects::isNull);
            if (printsLeft > 0) {
                System.out.print(userNumber + " is "); // complete this
                for (String p : properties) {
                    System.out.print(p);
                    if (properties.indexOf(p) != properties.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();

            }
        }
    }

    // is number odd or even - true means even, false means odd
    static String oddOrEven () {

        if (userInputArrLength == 1) {
            if (userNumber % 2 == 0) {
                return "even: true \n" +
                        "odd: false";
            } else {
                return "even: false \n" +
                        "odd: true";
            }
        } else {
            if (userNumber % 2 == 0) {
                return "even";
            } else {
                return "odd";
            }
        }
    }

    // is number a buzz number - must be divisible by 7 or end with 7
    static String buzzNumber() {

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
            if (userInputArrLength == 1) {
                return "buzz: true";
            } else {
                return "buzz";
            }
        } else {
            if (userInputArrLength == 1) {
                return "buzz: false";
            } else {
                return null;
            }
        }

    }

    // is number a duck number - must contain a 0 (doesn't count if it only begins with one)
    static String duckNumber() {
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
            if (userInputArrLength == 1) {
                return "duck: true";
            } else {
                return "duck";
            }
        } else {
            if (userInputArrLength == 1) {
                return "duck: false";
            } else {
                return null;
            }
        }
    }

    // is number palindromic - must be the same if reversed
    static String palindromicNumber() {
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
            if (userInputArrLength == 1) {
                return "palindromic: true";
            } else {
                return "palindromic";
            }
        } else {
            if (userInputArrLength == 1) {
                return "palindromic: false";
            } else {
                return null;
            }
        }
    }

    // is number gapful - at least 3 digits and is divisible by first and last digit
    static String gapfulNumber() {

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
            if (userInputArrLength == 1) {
                return "gapful: true";
            } else {
                return "gapful";
            }
        } else {
            if (userInputArrLength == 1) {
                return "gapful: false";
            } else {
                return null;
            }
        }

    }

}
