package bullscows;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SecretCode {

    private boolean errorThrown = false;
    private boolean isValidSecretCode;
    private final Scanner scanner = new Scanner(System.in);
    private int secretCodeLength;
    private int numberOfPossibleSymbols;
    private final ArrayList<Character> secretCode = new ArrayList<>();

    public SecretCode() {

        getSecretCodeChoices();
        getUserParameters();
        setValidSecretCode(false);

        while (!isValidSecretCode && !errorThrown) {
            setValidSecretCode(setSecretCode());
        }

        if (!errorThrown) {
            printGameStartMessage();
        }

//        // print the secret code
//        System.out.print("The random secret number is ");
//        for (int n : getSecretCode()) {
//            System.out.print(n);
//        }
//        System.out.print(".");
    }

    private void printGameStartMessage() {
        System.out.print("The secret is prepared: ");

        for (int i = 0; i < getSecretCodeLength(); i++) {
            System.out.print("*");
        }

        if (getNumberOfPossibleSymbols() <= 10) {
            System.out.println(" (0-" + (getNumberOfPossibleSymbols() - 1) + ").");
        } else {
            System.out.println(" (0-9, a-" + (getSecretCodeChoices().get(getNumberOfPossibleSymbols() - 1)) + ").");
        }

        System.out.println("Okay, let's start a game!");
    }

    protected ArrayList<Character> getSecretCodeChoices() {
        ArrayList<Character> secretCodeChoices = new ArrayList<>();

        char currChar = '0';

        for (int i = 0; i < 10; i++) {
            secretCodeChoices.add(currChar);
            currChar++;
        }

        currChar = 'a';

        for (int i = 0; i < 26; i++) {
            secretCodeChoices.add(currChar);
            currChar++;
        }

        return secretCodeChoices;
    }

    private void getUserParameters() {
        System.out.println("Input the length of the secret code:");

        boolean codeLengthValid = false;
        boolean numberOfParametersValid = false;

        String codeLengthString = "";
        int codeLength = 0;

//        while (!codeLengthValid) {
            try {
                codeLengthString = scanner.nextLine();
                codeLength = Integer.parseInt(codeLengthString);
                if (codeLength > 36) {
                    System.out.println("Error: can't generate a secret number with a length of " + codeLength + " because there aren't enough unique digits.");
                    setErrorThrown(true);
                } else if (codeLength < 1) {
                    System.out.println("Error: length of secret code must greater than 0.");
                    setErrorThrown(true);
                } else {
                    codeLengthValid = true;
                }
            } catch (Exception e) {
                System.out.println("Error: \"" + codeLengthString + "\" isn't a valid number.");
                setErrorThrown(true);
            }
//        }


        if (codeLengthValid) {
            System.out.println("Input the number of possible symbols in the code:");

            String numberOfParametersString = "";
            int numberOfParameters = 0;

//        while (!numberOfParametersValid) {
            try {
                numberOfParametersString = scanner.nextLine();
                numberOfParameters = Integer.parseInt(numberOfParametersString);
                if (numberOfParameters < codeLength) {
                    System.out.println("Error: it's not possible to generate a code with a length of " + codeLength + " with " + numberOfParameters + " unique symbols.");
                    setErrorThrown(true);
                } else if (numberOfParameters > 36) {
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    setErrorThrown(true);
                } else {
                    numberOfParametersValid = true;
                }
            } catch (Exception e) {
                System.out.println("Error: \"" + numberOfParametersString + "\" isn't a valid number.");
                setErrorThrown(true);
            }
//        }

            setSecretCodeLength(codeLength);
            setNumberOfPossibleSymbols(numberOfParameters);
        }
    }

    private ArrayList<Integer> getRandomSymbolIndices() {
        ArrayList<Integer> randomSymbolIndices = new ArrayList<>();
        Random random = new Random();

        int numberOfIndicesAdded = 0;
        while (numberOfIndicesAdded < getNumberOfPossibleSymbols()) {
            int randomNumber = random.nextInt(getNumberOfPossibleSymbols());
            if (!randomSymbolIndices.contains(randomNumber)) {
                randomSymbolIndices.add(randomNumber);
                numberOfIndicesAdded++;
            }
        }

        return randomSymbolIndices;
    }

//    private long getRandomNumber() {
//
//        // create array of (numberOfParameters) random numbers between 0 and 36
//        // fill secret code array up with (codeLength) characters based on their index from array mentioned above
//
//        Random random = new Random();
//        int upperBound = Integer.MAX_VALUE;
//        int lowerBound = Integer.MAX_VALUE - 1000000000;
//
//        return random.nextInt(upperBound - lowerBound) + lowerBound;
//    }

    private boolean setSecretCode() {

        ArrayList<Integer> randomSymbolIndices = getRandomSymbolIndices();

        for (int i = 0; i < getSecretCodeLength(); i++) {
            secretCode.add(getSecretCodeChoices().get(randomSymbolIndices.get(i)));
        }

        return true;

//        String pseudoRandomNumberString = String.valueOf(getRandomNumber());
//
//        for (int i = pseudoRandomNumberString.length() - 1; i >= 0; i--) {
//            if (secretCode.size() < getSecretCodeLength()) {
//                char currentNumberAsString = pseudoRandomNumberString.charAt(i);
//                int currentNumber = Character.getNumericValue(currentNumberAsString);
//                // make sure first digit isn't 0
//                if (i == pseudoRandomNumberString.length() - 1 && currentNumber == 0) {
//                    continue;
//                }
//                // add to secretCode array if number doesn't already exist
//                if (!secretCode.contains(currentNumber)) {
//                    secretCode.add(currentNumber);
//                }
//            } else {
//                break;
//            }
//        }
//
//        if (secretCode.size() < getSecretCodeLength()) {
//            secretCode.clear();
//            return false;
//        } else {
//            return true;
//        }
    }

    protected ArrayList<Character> getSecretCode() {
        return secretCode;
    }

    public int getSecretCodeLength() {
        return secretCodeLength;
    }

    public void setSecretCodeLength(int secretCodeLength) {
        this.secretCodeLength = secretCodeLength;
    }

    public int getNumberOfPossibleSymbols() {
        return numberOfPossibleSymbols;
    }

    public void setNumberOfPossibleSymbols(int numberOfPossibleSymbols) {
        this.numberOfPossibleSymbols = numberOfPossibleSymbols;
    }

    public boolean isValidSecretCode() {
        return isValidSecretCode;
    }

    public void setValidSecretCode(boolean validSecretCode) {
        isValidSecretCode = validSecretCode;
    }

    public boolean isErrorThrown() {
        return errorThrown;
    }

    public void setErrorThrown(boolean errorThrown) {
        this.errorThrown = errorThrown;
    }
}
