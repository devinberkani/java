package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        // initialize scanner
        Scanner scanner = new Scanner(System.in);

        // define number of rows and columns for game
        int numOfRows = 3;
        int numOfColumns = 3;

        //initialize game pieces array
        char[] gamePiecesArray = new char[9];

        //prompt user for input
        System.out.print("Enter cells: ");

        //save user input as String
        String userInput = scanner.next();

        //initialize user input array
        char[] userInputArray = new char[9];
        for (int i = 0; i < userInput.length(); i++) {
            userInputArray[i] = userInput.charAt(i);
        }

        //***print game board***

        //print top border
        System.out.println("---------");

        //variable for counting gameBoard array index
        int arrayIndex = 0;
        for (int r = 0; r < numOfRows; r++) {
            //print left sidebar
            String sidebarCharacter = "|";
            System.out.print(sidebarCharacter + " ");
            for (int c = 0; c < numOfColumns; c++) {
                gamePiecesArray[arrayIndex] = userInputArray[arrayIndex];
                System.out.print(gamePiecesArray[arrayIndex] + " ");
                arrayIndex++;
            }
            //print right sidebar
            System.out.print(sidebarCharacter);
            //new line
            System.out.println();
        }
        //print bottom border
        System.out.println("---------");
    }

}
