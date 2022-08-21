package bullscows;

import java.util.ArrayList;
import java.util.Scanner;
public class BullsAndCows {
    private boolean gameOver;
    // generate the secret code
    private final SecretCode secretCode = new SecretCode();
    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<Character> userGuess = new ArrayList<>();
    private int turnNumber = 1;

    public BullsAndCows() {
        setGameOver(false);

        while(!isGameOver()) {
            printTurn();
            getUserInput();
            gradeUserInput();
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }

    private void printTurn() {
        System.out.println("Turn " + getTurnNumber() + ":");
        setTurnNumber(getTurnNumber() + 1);
    }

    private void printGrade(int cowCount, int bullCount) {

        System.out.print("Grade: ");

        if (cowCount == 1 && bullCount == 1) {
            System.out.println(bullCount + " bull and " + cowCount + " cow. ");
        } else if (cowCount > 1 && bullCount > 1) {
            System.out.println(bullCount + " bulls and " + cowCount + " cows. ");
        } else if (bullCount == 1) {
            System.out.println(bullCount + " bull. ");
        } else if (bullCount > 1) {
            System.out.println(bullCount + " bulls. ");
        } else if (cowCount == 1) {
            System.out.println(cowCount + " cow. ");
        } else if (cowCount > 1) {
            System.out.println(cowCount + " cows. ");
        } else {
            System.out.println("None. ");
        }

//        // print the secret code
//        System.out.print("The secret code is ");
//        for (int n : secretCode.getSecretCode()) {
//            System.out.print(n);
//        }
//        System.out.print(".");
    }

    private void gradeUserInput() {
        int cowCount = 0;
        int bullCount = 0;

        for (int i = 0; i < getUserGuess().size(); i++) {
            char userGuessAtIndex = getUserGuess().get(i);
            char secretCodeAtIndex = secretCode.getSecretCode().get(i);
            // test for bulls - same number at same index
            if (userGuessAtIndex == secretCodeAtIndex) {
                bullCount++;
                // test for cows - same number at different index
            } else if (secretCode.getSecretCode().contains(userGuessAtIndex)) {
                cowCount++;
            }
        }

        // set game over if all bulls
        if (bullCount == secretCode.getSecretCodeLength()) {
            setGameOver(true);
        }

        // print out grade
        printGrade(cowCount, bullCount);
    }
    private void getUserInput() {
        ArrayList<Character> userInput = new ArrayList<>();

        // split next line of user input into string array
        String userInputString = scanner.nextLine();

        // convert to ints and add to userInputArr
        for (int i = 0; i < userInputString.length(); i++) {
            userInput.add(userInputString.charAt(i));
        }

        setUserGuess(userInput);
    }

    // getters and setters

    private ArrayList<Character> getUserGuess() {
        return userGuess;
    }

    private void setUserGuess(ArrayList<Character> userGuess) {
        this.userGuess = userGuess;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
}