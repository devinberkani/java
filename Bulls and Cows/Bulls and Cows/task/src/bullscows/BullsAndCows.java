package bullscows;

import java.util.ArrayList;
import java.util.Scanner;
public class BullsAndCows {

    // generate the secret code
    private final SecretCode secretCode = new SecretCode();
    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<Integer> userGuess = new ArrayList<>();

    public BullsAndCows() {
//        getUserInput();
//        gradeUserInput();
    }

    private void printGrade(int cowCount, int bullCount) {

        System.out.print("Grade: ");

        if (cowCount > 0 && bullCount > 0) {
            System.out.print(bullCount + " bull(s) and " + cowCount + " cow(s). ");
        } else if (bullCount > 0) {
            System.out.print(bullCount + " bull(s). ");
        } else if (cowCount > 0) {
            System.out.print(cowCount + " cow(s). ");
        } else {
            System.out.print("None. ");
        }

        // print the secret code
        System.out.print("The secret code is ");
        for (int n : secretCode.getSecretCode()) {
            System.out.print(n);
        }
        System.out.print(".");
    }

    private void gradeUserInput() {
        int cowCount = 0;
        int bullCount = 0;

        for (int i = 0; i < getUserGuess().size(); i++) {
            int userGuessAtIndex = getUserGuess().get(i);
            int secretCodeAtIndex = secretCode.getSecretCode().get(i);
            // test for bulls - same number at same index
            if (userGuessAtIndex == secretCodeAtIndex) {
                bullCount++;
                // test for cows - same number at different index
            } else if (secretCode.getSecretCode().contains(userGuessAtIndex)) {
                cowCount++;
            }
        }
        // print out grade
        printGrade(cowCount, bullCount);
    }
    private void getUserInput() {
        ArrayList<Integer> userInput = new ArrayList<>();

        // split next line of user input into string array
        String[] userInputStringArr = scanner.nextLine().split("");

        // convert to ints and add to userInputArr
        for (String s : userInputStringArr) {
            userInput.add(Integer.parseInt(s));
        }

        setUserGuess(userInput);
    }

    // getters and setters

    private ArrayList<Integer> getUserGuess() {
        return userGuess;
    }

    private void setUserGuess(ArrayList<Integer> userGuess) {
        this.userGuess = userGuess;
    }
}
