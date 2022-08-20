package bullscows;

import java.util.ArrayList;
import java.util.Scanner;

public class SecretCode {

    private boolean isValidSecretCode;
    private final Scanner scanner = new Scanner(System.in);
    private int userInputSecretCodeLength;
    private final ArrayList<Integer> secretCode = new ArrayList<>();

    public SecretCode() {

        getSecretCodeLengthFromUser();
        setValidSecretCode(false);

        while (!isValidSecretCode) {
            setValidSecretCode(setSecretCode());
        }

        // print the secret code
        System.out.print("The random secret number is ");
        for (int n : getSecretCode()) {
            System.out.print(n);
        }
        System.out.print(".");
    }

    private void getSecretCodeLengthFromUser() {
        int codeLength = scanner.nextInt();
        while (codeLength > 10) {
            System.out.println("Error: can't generate a secret number with a length of " + codeLength + " because there aren't enough unique digits.");
            codeLength = scanner.nextInt();
        }
        setUserInputSecretCodeLength(codeLength);
    }

    private long getRandomNumber() {
        long pseudoRandomNumber = System.nanoTime();

        while (pseudoRandomNumber < getUserInputSecretCodeLength()) {
            pseudoRandomNumber = System.nanoTime();
        }

        return pseudoRandomNumber;
    }

    // generate secret code of numbers between 0-9
    private boolean setSecretCode() {

        String pseudoRandomNumberString = String.valueOf(getRandomNumber());

        for (int i = pseudoRandomNumberString.length() - 1; i >= 0; i--) {
            if (secretCode.size() < getUserInputSecretCodeLength()) {
                char currentNumberAsString = pseudoRandomNumberString.charAt(i);
                int currentNumber = Character.getNumericValue(currentNumberAsString);
                // make sure first digit isn't 0
                if (i == pseudoRandomNumberString.length() - 1 && currentNumber == 0) {
                    continue;
                }
                // add to secretCode array if number doesn't already exist
                if (!secretCode.contains(currentNumber)) {
                    secretCode.add(currentNumber);
                }
            } else {
                break;
            }
        }

        if (secretCode.size() < getUserInputSecretCodeLength()) {
            secretCode.clear();
            return false;
        } else {
            return true;
        }

//        Random random = new Random();
//        int upperBound = 10;
//
//        // fill secretCode array
//        for (int i = 0; i < 4; i++) {
//            secretCode.add(random.nextInt(upperBound));
//        }
    }

    protected ArrayList<Integer> getSecretCode() {
        return secretCode;
    }

    public int getUserInputSecretCodeLength() {
        return userInputSecretCodeLength;
    }

    public void setUserInputSecretCodeLength(int userInputSecretCodeLength) {
        this.userInputSecretCodeLength = userInputSecretCodeLength;
    }

    public boolean isValidSecretCode() {
        return isValidSecretCode;
    }

    public void setValidSecretCode(boolean validSecretCode) {
        isValidSecretCode = validSecretCode;
    }
}
