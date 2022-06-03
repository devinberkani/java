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
        String[] gamePiecesArray = new String[9];

        //initialize user input array
        String[] userInputArray = new String[gamePiecesArray.length];

        //fill user input array
        for (int i = 0; i < gamePiecesArray.length; i++) {
            userInputArray[i] = scanner.next();
        }

        //***print game board***

        //print top border
        System.out.println("-----------");

        //variable for counting gameBoard array index
        int gameBoardIndex = 0;
        for (int r = 0; r < numOfRows; r++) {
            //print left sidebar
            String sidebarCharacter = "|";
            System.out.print(sidebarCharacter);
            for (int c = 0; c < numOfColumns; c++) {
                gamePiecesArray[gameBoardIndex] = userInputArray[gameBoardIndex]; // *****this needs to be changed to be user input
                System.out.print(" " + gamePiecesArray[gameBoardIndex] + " ");
                gameBoardIndex++;
            }
            //print right sidebar
            System.out.print(sidebarCharacter);
            //new line
            System.out.println();
        }
        //print bottom border
        System.out.println("-----------");
    }

}
