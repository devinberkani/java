package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        // initialize scanner
        Scanner scanner = new Scanner(System.in);

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
        printGameBoard(userInputArray);
    }

    public static void analyzeGameState(char[] array, int numOfRows, int numOfColumns) {

        // initialize game state array for all game states to be tracked and compared simultaneously
        int[] gameStateArray = new int[8];

        //***** all 16 win state combinations *****

        // horizontal win states -- double these to be able to track x and o win counts

        int topHorizontalWinCountX = 0;
        int midHorizontalWinCountX = 0;
        int bottomHorizontalWinCountX = 0;

        int topHorizontalWinCountO = 0;
        int midHorizontalWinCountO = 0;
        int bottomHorizontalWinCountO = 0;

        // vertical win states
        int leftVerticalWinCountX = 0;
        int midVerticalWinCountX = 0;
        int rightVerticalWinCountX = 0;

        int leftVerticalWinCountO = 0;
        int midVerticalWinCountO = 0;
        int rightVerticalWinCountO = 0;

        // diagonal win states
        int leftToRightDiagonalWinCountX = 0;
        int rightToLeftDiagonalWinCountX = 0;

        int leftToRightDiagonalWinCountO = 0;
        int rightToLeftDiagonalWinCountO = 0;

        //horizontal x

        // this part will have to be within a loop that adds up the counts for use below

        // if (array[0] == x && array[1] == x && array[2] == x)
        // if (array[3] == x && array[4] == x && array[5] == x)
        // if (array[6] == x && array[7] == x && array[8] == x)

        //horizontal o

        // if (array[0] == o && array[1] == o && array[2] == o)
        // if (array[3] == o && array[4] == o && array[5] == o)
        // if (array[6] == o && array[7] == o && array[8] == o)


        //***** track counts for the game *****

        // track pieces laid -- if index of array == X or O should count up by 1
        // if numOfPiecesLaid < 8, program should print "game not finished"
        // when this number == 8, gameIsOver should == true
        int numPiecesLaid = 0;
        boolean gameIsOver = false;

        //variable for counting gameBoard array index
        int arrayIndex = 0;

        // DETERMINE counts-- assess each game state scenario to add up counts for each above win state scenario
        for (int r = 0; r < numOfRows; r++) {
            for (int c = 0; c < numOfColumns; c++) {
                System.out.println(array[arrayIndex]);
                arrayIndex++;
            }
        }

        // ADD count totals to game state array - this is a separate loop

        //***** determine winner for the game -- do this in separate method? *****

        // ONLY IF gameIsOver == true (won't print "game not finished" anymore)
        // make sure there is only one winner by tracking number of wins (below winCount variable),
        // if there is only one, print the winner,
        // if there is more than one, print impossible,
        // if there is zero, print draw
        int winCount = 0;
    }

    public static void printGameBoard(char[] array) {
        // define number of rows and columns for game
        int numOfRows = 3;
        int numOfColumns = 3;

        //initialize game pieces array
        char[] gamePiecesArray = new char[9];

        //print top border
        System.out.println("---------");

        //variable for counting gameBoard array index
        int arrayIndex = 0;
        for (int r = 0; r < numOfRows; r++) {
            //print left sidebar
            String sidebarCharacter = "|";
            System.out.print(sidebarCharacter + " ");
            for (int c = 0; c < numOfColumns; c++) {
                gamePiecesArray[arrayIndex] = array[arrayIndex];
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

        //analyze game state
        analyzeGameState(gamePiecesArray, numOfRows, numOfColumns);
    }

}
