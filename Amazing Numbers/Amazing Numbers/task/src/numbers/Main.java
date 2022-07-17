package numbers;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// ******************** ALL THAT NEEDS DONE IS INCLUDING LOGIC FOR EXCLUDING PROPERTIES FROM SEARCHES AS WELL AS SPECIFYING THE "-" SYMBOL IN MUTUALLY EXCLUSIVE PROPERTY SEARCHES -- SEE NOTES BELOW @ lines 211 and 81

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isExiting = false;
    static boolean isValidInput = false;
    static long userNumber;

    static long userNumberCopy;
    static long listLength = 1; // so that all current methods work if this number is not provided

    static String propertySearchOne; // first property being searched for

    static String propertySearchTwo; // second property being searched for
    static List<String> userProperties = new ArrayList<>(); // array to hold all properties user is searching for
    static long userInputArrLength;

    // available properties for user input
    static String[] availableProperties = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SUNNY", "SQUARE", "JUMPING", "EVEN", "ODD", "HAPPY", "SAD"};

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
                "- two natural numbers and properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        do {

            // handle errors - get input array
            List<Long> userInput = validateInput();
            userInputArrLength = userInput.size();

            if (userInputArrLength == 1) {
                userNumber = userInput.get(0);
            } else if (userInputArrLength == 2) {
                userNumber = userInput.get(0);
                listLength = userInput.get(1);
            } else {
                userNumber = userInput.get(0);
                listLength = userInput.get(1);
                for (int i = 2; i < userInput.size(); i++) {
                    userProperties.add(availableProperties[Integer.parseInt(userInput.get(i).toString())]);
                }
            }

            if (userNumber == 0) {
                isExiting = true;
                System.out.println("Goodbye!");
            } else {
                long printsLeft = listLength; // number of times to print properties
                if (userInputArrLength == 1 || userInputArrLength == 2) {
                    while (printsLeft > 0) {
                        userNumberCopy = userNumber; // make a copy of current number (in case it's changed)
                        printProperties(printsLeft);
                        userNumber = userNumberCopy; // go back to what it was
                        userNumber++; // add one to the userNumber after every print
                        printsLeft--;
                    }
                } else {

                    while (printsLeft > 0) {

                        boolean allNotNull = true;
                        // create separate boolean flag for whether there is a property match from exclusion array? if so this could be put into logic as counting as null?

                        // list of method returns from the properties being searched for
                        List<String> methodReturnList = new ArrayList<>();

                        for (String property : userProperties) {

                            methodReturnList.add(methodReturn(property));

                        }

                        for (String currentMethodResult : methodReturnList) {

                            if (currentMethodResult == null) {
                                allNotNull = false;
                                break;
                            }

                        }

                        if (allNotNull) {
                            printProperties(printsLeft);
                            printsLeft--;
                        }

                        userNumber++; // add one to the userNumber after every print
                    }

                }
                listLength = 1; // reset listLength
                isValidInput = false; // in order to prevent infinite loop
                userProperties.clear(); // reset list
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
        } else if (method.equalsIgnoreCase("HAPPY")) {
            return happyNumber();
        } else if (method.equalsIgnoreCase("SAD")) {
            return sadNumber();
        } else {
            return null;
        }
    }

    static List<Long> validateInput() {

        // initialize array to be returned with user input
        List<Long> userInputArr = new ArrayList<>();

        while (!isValidInput) {

            // error handling to determine if input is a natural number - must be a number greater than 0
            boolean firstNumberValid = false; // number input
            boolean secondNumberValid = false; // list length input
            boolean invalidSearchFound = false;
            boolean allSearchInputValid = false; // all types of numbers being searched for
            int invalidSearchCount = 0; // count for invalid searches
            boolean notMutuallyExclusive = false; // flag for mutually exclusive properties - specific ones below
            boolean evenAndOdd = false;
            boolean sunnyAndSquare = false;
            boolean duckAndSpy = false;
            boolean happyAndSad = false;

            System.out.print("Enter a request: ");

            String userInput = scanner.nextLine();

            String[] userInputArrS = userInput.split(" ");

            int userInputArrLength = userInputArrS.length;

            // check to make sure input is a number

            //userInputArrS[0].matches("\\d+")

            if (!userInputArrS[0].equals("")) {

                // array to keep track of property search indexes used to catch mutually exclusive properties
                List<Integer> propertySearchIndices = new ArrayList<>();

                // create array of incorrect inputs
                List<String> invalidPropertySearches = new ArrayList<>();

                // check to make sure number(s) are natural

                if (userInputArrLength == 1) { // only searching for info on one number
                    if (userInputArrS[0].matches("\\d+")) {
                        firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    }
                    isValidInput = firstNumberValid;
                } else if (userInputArrLength == 2) { // searching for info on list of numbers
                    if (userInputArrS[0].matches("\\d+")) {
                        firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    }
                    if (userInputArrS[1].matches("\\d+")) {
                        secondNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    }
                    isValidInput = firstNumberValid && secondNumberValid;
                } else { // searching for specific info on list of numbers
                    if (userInputArrS[0].matches("\\d+")) {
                        firstNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    }
                    if (userInputArrS[1].matches("\\d+")) {
                        secondNumberValid = Long.parseLong(userInputArrS[0]) >= 0;
                    }
                    for (int i = 2; i < userInputArrLength; i++) {
                        for (int j = 0; j < availableProperties.length; j++) {
                            // going to need to create an additional array of all properties with the "-" symbol to match with
                            // add additional if statement here based on whether a user input matches with "-" symbol -- add these properties to a separate list/array (static?) -- this will also prevent these searches from getting caught by invalid search flag
                            if (userInputArrS[i].equalsIgnoreCase(availableProperties[j])) {
                                propertySearchIndices.add(j);
                                break;
                            } else if (j == availableProperties.length - 1) {
                                invalidSearchFound = true; // add invalid input to invalid searches array
                                break;
                            }
                        }
                        if (invalidSearchFound) {
                            allSearchInputValid = false;
                            invalidSearchCount++;
                            invalidPropertySearches.add(userInputArrS[i]); // add invalid input to invalid searches array
                            invalidSearchFound = false;
                        } else if (invalidSearchCount == 0) {
                            allSearchInputValid = true;
                        }

                        // catch mutually exclusive properties
                        if ((propertySearchIndices.contains(8) && propertySearchIndices.contains(9))) {
                            notMutuallyExclusive = false;
                            evenAndOdd = true;
                        } else if ((propertySearchIndices.contains(5) && propertySearchIndices.contains(6))) {
                            notMutuallyExclusive = false;
                            sunnyAndSquare = true;
                        } else if ((propertySearchIndices.contains(1) && propertySearchIndices.contains(4))) {
                            notMutuallyExclusive = false;
                            duckAndSpy = true;
                        } else if ((propertySearchIndices.contains(10) && propertySearchIndices.contains(11))) {
                            notMutuallyExclusive = false;
                            happyAndSad = true;
                        }
                        else {
                            notMutuallyExclusive = true;
                        }
                        isValidInput = firstNumberValid && secondNumberValid && allSearchInputValid && notMutuallyExclusive;
                    }
                }

                if (!isValidInput) {
                    if (!firstNumberValid) {
                        System.out.println("The first parameter should be a natural number or zero.");
                    } else if (!secondNumberValid) {
                        System.out.println("The second parameter should be a natural number.");
                    } else if (!allSearchInputValid) {
                        if (invalidPropertySearches.size() == 1) {
                            System.out.println("The property [" + invalidPropertySearches.get(0).toUpperCase() + "] is wrong.");
                            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                        } else {
                            System.out.print("The properties [");
                            for (int i = 0; i < invalidPropertySearches.size(); i++) {
                                if (i != invalidPropertySearches.size() - 1) {
                                    System.out.print(invalidPropertySearches.get(i).toUpperCase() + ", ");
                                } else {
                                    System.out.print(invalidPropertySearches.get(i).toUpperCase());
                                }
                            }
                            System.out.println("] are wrong.");
                            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                        }
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
                        } else if (happyAndSad) {
                            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                                    "There are no numbers with these properties.");
                        }
                    }
                } else {
                    // add the number/number of numbers being searched for

                    // variable to track propertySearchIndices size
                    int propertySearchIndicesSize = propertySearchIndices.size();
                    for (int i = 0; i < (userInputArrLength - propertySearchIndicesSize); i++) {
                        userInputArr.add(Long.parseLong(userInputArrS[i]));
                    }
                    // add the property searches being searched for

                    for (int i = 0; i < propertySearchIndicesSize; i++) {
                        userInputArr.add(Long.parseLong(propertySearchIndices.get(i).toString()));
                    }
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
            System.out.println(happyNumber());
            System.out.println(sadNumber());
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
            properties.add(happyNumber());
            properties.add(sadNumber());
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

        // boolean flag for jumping number
        boolean isJumpingNumber = false;

        // get user number split into array
        String[] userNumberArr = Long.toString(userNumber).split("");
        int userNumberLength = userNumberArr.length;

        // handle big numbers under specific circumstances
        int firstNumber = Integer.parseInt(userNumberArr[0]);
        int secondNumber = 0;
        if (userNumberLength > 1) {
            secondNumber = Integer.parseInt(userNumberArr[1]);
        }
        if (userNumberLength > 9 && userProperties.size() > 0 && secondNumber != (firstNumber + 1) && secondNumber != firstNumber - 1) {
            userNumber+= 1000000;
            userNumberArr = Long.toString(userNumber).split("");
            userNumberLength = userNumberArr.length;
        }

        if (userNumberLength == 1) {
            isJumpingNumber = true;
        } else {
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

    // find happy and sad numbers - is happy if squaring individual digits results in 1 in the end, else is sad
    static String happyNumber() {

        // boolean flag for happy number
        boolean isHappyNumber = false;

        // get user number split into array
        String[] userNumberArr = Long.toString(userNumber).split("");
        int userNumberLength = userNumberArr.length;

        // variable to track result of calculations
        int result = 0;

        while(true) {
            for (String s : userNumberArr) {
                int currentNumber = Integer.parseInt(s);
                result += (currentNumber * currentNumber);
            }
            // update result array
            userNumberArr = Integer.toString(result).split("");
            if (result == 1) {
                isHappyNumber = true;
                break;
            } else if (result == 4) {
                break;
            } else {
                result = 0;
            }
        }
        if (isHappyNumber) {
            if (userInputArrLength == 1) {
                return "happy: true";
            } else {
                return "happy";
            }
        } else {
            if (userInputArrLength == 1) {
                return "happy: false";
            } else {
                return null;
            }
        }
    }

    static String sadNumber() {

        // boolean flag for happy number
        boolean isSadNumber = false;

        // get user number split into array
        String[] userNumberArr = Long.toString(userNumber).split("");
        int userNumberLength = userNumberArr.length;

        // variable to track result of calculations
        int result = 0;

        while(true) {
            for (String s : userNumberArr) {
                int currentNumber = Integer.parseInt(s);
                result += (currentNumber * currentNumber);
            }
            // update result array
            userNumberArr = Integer.toString(result).split("");
            if (result == 1) {
                break;
            } else if (result == 4) {
                isSadNumber = true;
                break;
            } else {
                result = 0;
            }
        }
        if (isSadNumber) {
            if (userInputArrLength == 1) {
                return "sad: true";
            } else {
                return "sad";
            }
        } else {
            if (userInputArrLength == 1) {
                return "sad: false";
            } else {
                return null;
            }
        }
    }
}
