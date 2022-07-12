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

    static String propertySearchOne; // first property being searched for

    static String propertySearchTwo; // second property being searched for
    static long userInputArrLength;

    // available properties for user input
    static String[] availableProperties = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SUNNY", "JUMPING", "SQUARE", "EVEN", "ODD"};

    public static void main(String[] args) {
        printMenu();
    }

    static void printMenu() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties; \n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        do {

            // handle errors - get input array
            long[] userInput = validateInput();
            userInputArrLength = userInput.length;

            if (userInputArrLength == 1) {
                userNumber = userInput[0];
            } else if (userInputArrLength == 2) {
                userNumber = userInput[0];
                listLength = userInput[1];
            } else if (userInputArrLength == 3) {
                userNumber = userInput[0];
                listLength = userInput[1];
                propertySearchOne = availableProperties[(int)userInput[2]];
            } else if (userInputArrLength == 4) {
                userNumber = userInput[0];
                listLength = userInput[1];
                propertySearchOne = availableProperties[(int)userInput[2]];
                propertySearchTwo = availableProperties[(int)userInput[3]];
            }

            if (userNumber == 0) {
                isExiting = true;
                System.out.println("Goodbye!");
            } else {
                long printsLeft = listLength; // number of times to print properties
                if (userInputArrLength == 1 || userInputArrLength == 2) {
                    while (printsLeft > 0) {
                        printProperties(printsLeft);
                        userNumber++; // add one to the userNumber after every print
                        printsLeft--;
                    }
                } else if (userInputArrLength == 3) {

                    List<String> userProperties = new ArrayList<>(); // array to hold all properties user is searching for
                    userProperties.add(propertySearchOne);

                    // variables to store methods to be used
                    String methodOne = null;

                    while (printsLeft > 0) {

                        for (String property : userProperties) {
                            if (property.equalsIgnoreCase(propertySearchOne)) {
                                methodOne = methodReturn(propertySearchOne);
                            }
                        }
                        if (methodOne != null) {
                            printProperties(printsLeft);
                            printsLeft--;
                        }
                        userNumber++; // add one to the userNumber after every print
                    }

                } else if (userInputArrLength == 4) {

                    List<String> userProperties = new ArrayList<>(); // array to hold all properties user is searching for
                    userProperties.add(propertySearchOne);
                    userProperties.add(propertySearchTwo);

                    // variables to store methods to be used
                    String methodOne = null;
                    String methodTwo = null;

                    while (printsLeft > 0) {

                        for (String property : userProperties) {

                            if (property.equalsIgnoreCase(propertySearchOne)) {
                                methodOne = methodReturn(propertySearchOne);
                            }
                            if (property.equalsIgnoreCase(propertySearchTwo)) {
                                methodTwo = methodReturn(propertySearchTwo);
                            }
                        }
                        if (methodOne != null && methodTwo != null) {
                            printProperties(printsLeft);
                            printsLeft--;
                        }
                        userNumber++; // add one to the userNumber after every print
                    }

                }
                listLength = 1; // reset listLength
                isValidInput = false; // in order to prevent infinite loop
            }

        } while (!isExiting);
    }

    static String methodReturn(String method) {

        if (method.equalsIgnoreCase("BUZZ")) {
            return buzzNumber();
        } else if (method.equalsIgnoreCase("DUCK")) {
            return duckNumber();
        } else if (method.equalsIgnoreCase("PALINDROMIC")) {
            return palindromicNumber();
        } else if (method.equalsIgnoreCase("GAPFUL")) {
            return gapfulNumber();
        } else if (method.equalsIgnoreCase("SPY")) {
            return spyNumber();
        } else if (method.equalsIgnoreCase("SUNNY")) {
            return sunnyNumber();
        } else if (method.equalsIgnoreCase("SQUARE")) {
            return squareNumber();
        } else if (method.equalsIgnoreCase("JUMPING")) {
            return jumpingNumber();
        } else if (method.equalsIgnoreCase("EVEN")) {
            return evenNumber();
        } else if (method.equalsIgnoreCase("ODD")) {
            return oddNumber();
        } else {
            return null;
        }
    }

    static long[] validateInput() {

        // initialize array to be returned with user input
        long[] userInputArr = new long[0];

        int firstPropertyIndex = 0; // index to be used to reference first property being searched for
        int secondPropertyIndex = 0; // index to be used to reference second property being searched for

        while (!isValidInput) {

            // error handling to determine if input is a natural number - must be a number greater than 0
            boolean firstNumberValid = false; // number input
            boolean secondNumberValid = false; // list length input
            boolean thirdInputValid = false; // type of numbers being searched for
            boolean fourthInputValid = false; // second type of numbers being searched for
            boolean notMutuallyExclusive = false; // flag for mutually exclusive properties - specific ones below
            boolean evenAndOdd = false;
            boolean sunnyAndSquare = false;
            boolean duckAndSpy = false;

            System.out.print("Enter a request: ");

            String userInput = scanner.nextLine();

            String[] userInputArrS = userInput.split(" ");

            int userInputArrLength = userInputArrS.length;

            // check to make sure input is a number

            if (userInputArrS[0].matches("\\d+")) {

                // check to make sure number(s) are natural

                if (userInputArrLength == 1) { // only searching for info on one number
                    firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    isValidInput = firstNumberValid;
                } else if (userInputArrLength == 2) { // searching for info on list of numbers
                    firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    secondNumberValid = Long.parseLong(userInputArrS[1]) > 0;
                    isValidInput = firstNumberValid && secondNumberValid;
                } else if (userInputArrLength == 3) { // searching for specific info on list of numbers
                    firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    secondNumberValid = Long.parseLong(userInputArrS[1]) > 0;
                    for (int i = 0; i < availableProperties.length; i++) {
                        if (userInputArrS[2].equalsIgnoreCase(availableProperties[i])) {
                            firstPropertyIndex = i;
                            thirdInputValid = true;
                            break;
                        }
                    }
                    isValidInput = firstNumberValid && secondNumberValid && thirdInputValid;
                } else if (userInputArrLength == 4) { // searching for specific info on list of numbers - second property
                    firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    secondNumberValid = Long.parseLong(userInputArrS[1]) > 0;
                    for (int i = 0; i < availableProperties.length; i++) {
                        if (userInputArrS[2].equalsIgnoreCase(availableProperties[i])) {
                            firstPropertyIndex = i;
                            thirdInputValid = true;
                        }
                        if (userInputArrS[3].equalsIgnoreCase(availableProperties[i])) {
                            secondPropertyIndex = i;
                            fourthInputValid = true;
                        }
                    }
                    // catch mutually exclusive properties
                    if ((firstPropertyIndex == 7 && secondPropertyIndex == 8) || (firstPropertyIndex == 8 && secondPropertyIndex == 7)) {
                        evenAndOdd = true;
                    } else if ((firstPropertyIndex == 5 && secondPropertyIndex == 6) || (firstPropertyIndex == 6 && secondPropertyIndex == 5)) {
                        sunnyAndSquare = true;
                    } else if ((firstPropertyIndex == 1 && secondPropertyIndex == 4) || (firstPropertyIndex == 4 && secondPropertyIndex == 1)) {
                        duckAndSpy = true;
                    } else {
                        notMutuallyExclusive = true;
                    }
                    isValidInput = firstNumberValid && secondNumberValid && thirdInputValid && fourthInputValid && notMutuallyExclusive;
                }
            }

            if (!isValidInput) {
                if (!firstNumberValid) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if (!secondNumberValid) {
                    System.out.println("The second parameter should be a natural number.");
                } else if (userInputArrLength == 4 && !thirdInputValid && !fourthInputValid) {
                    System.out.println("The properties [" + userInputArrS[2].toUpperCase() + ", " + userInputArrS[3].toUpperCase() + "] are wrong.");
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
                } else if (!thirdInputValid) {
                    System.out.println("The property [" + userInputArrS[2].toUpperCase() + "] is wrong.");
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
                } else if (!fourthInputValid) {
                    System.out.println("The property [" + userInputArrS[3].toUpperCase() + "] is wrong.");
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
                } else if (!notMutuallyExclusive) {
                    if (evenAndOdd) {
                        System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\n" +
                                "There are no numbers with these properties.");
                    } else if (sunnyAndSquare) {
                        System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]\n" +
                                "There are no numbers with these properties.");
                    } else if (duckAndSpy) {
                        System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                                "There are no numbers with these properties.");
                    }
                }
            } else {
                if (userInputArrLength == 1) {
                    userInputArr = new long[1];
                    userInputArr[0] = Long.parseLong(userInputArrS[0]);
                } else if (userInputArrLength == 2) {
                    userInputArr = new long[2];
                    userInputArr[0] = Long.parseLong(userInputArrS[0]);
                    userInputArr[1] = Long.parseLong(userInputArrS[1]);
                } else if (userInputArrLength == 3) {
                    userInputArr = new long[3];
                    userInputArr[0] = Long.parseLong(userInputArrS[0]);
                    userInputArr[1] = Long.parseLong(userInputArrS[1]);
                    userInputArr[2] = firstPropertyIndex;
                } else if (userInputArrLength == 4) {
                    userInputArr = new long[4];
                    userInputArr[0] = Long.parseLong(userInputArrS[0]);
                    userInputArr[1] = Long.parseLong(userInputArrS[1]);
                    userInputArr[2] = firstPropertyIndex;
                    userInputArr[3] = secondPropertyIndex;
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
            System.out.println(spyNumber());
            System.out.println(sunnyNumber());
            System.out.println(squareNumber());
            System.out.println(jumpingNumber());
            System.out.println(oddOrEven());
        } else {
            List<String> properties = new ArrayList<>();
            properties.add(buzzNumber());
            properties.add(duckNumber());
            properties.add(palindromicNumber());
            properties.add(gapfulNumber());
            properties.add(spyNumber());
            properties.add(sunnyNumber());
            properties.add(squareNumber());
            properties.add(jumpingNumber());
            properties.add(oddOrEven());
            // remove nulls
            properties.removeIf(Objects::isNull);
            if (printsLeft > 0) {
                System.out.print(userNumber + " is ");
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

        if (userNumber % 2 == 0) {
            return evenNumber();
        } else {
            return oddNumber();
        }
    }

    static String evenNumber() {
        if (userInputArrLength == 1) {
            if (userNumber % 2 == 0) {
                return "even: true \n" +
                        "odd: false";
            } else {
                return null;
            }
        } else {
            if (userNumber % 2 == 0) {
                return "even";
            } else {
                return null;
            }
        }
    }

    static String oddNumber() {
        if (userInputArrLength == 1) {
            if (userNumber % 2 != 0) {
                return "even: false \n" +
                        "odd: true";
            } else {
                return null;
            }
        } else {
            if (userNumber % 2 != 0) {
                return "odd";
            } else {
                return null;
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

    // is number spy - sum of all digits equal to product of all digits
    static String spyNumber() {

        // get user number split into array
        String[] userNumberArr = Long.toString(userNumber).split("");
        int userNumberLength = userNumberArr.length;

        // variables to track sum, product totals, and boolean flag
        int sumTotal = 0;
        int productTotal = 1;

        // get sum and product totals
        for (String s : userNumberArr) {
            sumTotal += Integer.parseInt(s);
            productTotal *= Integer.parseInt(s);
        }

        boolean isSpy = sumTotal == productTotal;

        if (isSpy) {
            if (userInputArrLength == 1) {
                return "spy: true";
            } else {
                return "spy";
            }
        } else {
            if (userInputArrLength == 1) {
                return "spy: false";
            } else {
                return null;
            }
        }

    }

    // is number sunny - N + 1 equals a perfect square
    static String sunnyNumber() {

        // test number to compare to squared result
        double testNumber = Math.sqrt(userNumber + 1);
        boolean isSunny = testNumber == (int) testNumber;

        if (isSunny) {
            if (userInputArrLength == 1) {
                return "sunny: true";
            } else {
                return "sunny";
            }
        } else {
            if (userInputArrLength == 1) {
                return "sunny: false";
            } else {
                return null;
            }
        }
    }

    // is number square
    static String squareNumber() {
        double testNumber = Math.sqrt(userNumber);
        boolean isSquare = testNumber == (int) testNumber;

        if (isSquare) {
            if (userInputArrLength == 1) {
                return "square: true";
            } else {
                return "square";
            }
        } else {
            if (userInputArrLength == 1) {
                return "square: false";
            } else {
                return null;
            }
        }
    }

    // is jumping number - adjacent digits inside number differ by 1
    static String jumpingNumber() {

        // *******************this takes a long time to complete, this is as far as you gotten -- remmber that the way you have it now you are modifying the user number which probably won't work long term

        // boolean flag for jumping number
        boolean isJumpingNumber = false;

        // get user number split into array
        String[] userNumberArr = Long.toString(userNumber).split("");
        int userNumberLength = userNumberArr.length;

        // handle big numbers
        int firstNumber = Integer.parseInt(userNumberArr[0]);
        int secondNumber = Integer.parseInt(userNumberArr[1]);
        if (userNumberLength > 9 && secondNumber != (firstNumber + 1) && secondNumber != firstNumber - 1) {
            userNumber+= 1000000;
            userNumberArr = Long.toString(userNumber).split("");
            userNumberLength = userNumberArr.length;
        }

        for (int i = 0; i < userNumberLength; i++) {
            int currentNumber = Integer.parseInt(userNumberArr[i]);
            if (i != userNumberLength - 1) {
                int nextNumber = Integer.parseInt(userNumberArr[i + 1]);
                if (nextNumber == (currentNumber + 1) || nextNumber == (currentNumber - 1)) {
                    isJumpingNumber = true;
                } else {
                    isJumpingNumber = false;
                    break;
                }
            } else {
                break;
            }
        }

        if (isJumpingNumber) {
            if (userInputArrLength == 1) {
                return "jumping: true";
            } else {
                return "jumping";
            }
        } else {
            if (userInputArrLength == 1) {
                return "jumping: false";
            } else {
                return null;
            }
        }

    }

}
