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

        //***** track counts for the game *****

        // track pieces laid -- if index of array == X or O should count up by 1
        // if numOfPiecesLaid < 8, program should print "game not finished"
        // when this number == 8, gameIsOver should == true

        int xPiecesLaid = 0;
        int oPiecesLaid = 0;
        int numPiecesLaid = 0;
        boolean gameIsOver = false;

        // DETERMINE counts -- assess each game state scenario to add up counts for numPiecesLaid and each above win state scenario
        //variable for counting gameBoard array index
        int arrayIndex = 0;
        for (int r = 0; r < numOfRows; r++) {
            for (int c = 0; c < numOfColumns; c++) {
                if (array[arrayIndex] == 'X') {
                    xPiecesLaid++;
                    numPiecesLaid++;
                }
                if (array[arrayIndex] == 'O') {
                    oPiecesLaid++;
                    numPiecesLaid++;
                }
                arrayIndex++;
            }
        }

        //***** all 16 win state combinations *****

        // horizontal win states
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

        // x win count
        int xWinCount = 0;

        // y win count
        int oWinCount = 0;

        // total win count
        int totalWinCount = 0;

        //horizontal x win logic

         if (array[0] == 'X' && array[1] == 'X' && array[2] == 'X')  {
             topHorizontalWinCountX++;
             xWinCount++;
         }

         if (array[3] == 'X' && array[4] == 'X' && array[5] == 'X') {
             midHorizontalWinCountX++;
             xWinCount++;
         }

         if (array[6] == 'X' && array[7] == 'X' && array[8] == 'X') {
             bottomHorizontalWinCountX++;
             xWinCount++;
         }

        // vertical x win logic

        if (array[0] == 'X' && array[3] == 'X' && array[6] == 'X')  {
            leftVerticalWinCountX++;
            xWinCount++;
        }

        if (array[1] == 'X' && array[4] == 'X' && array[7] == 'X') {
            midVerticalWinCountX++;
            xWinCount++;
        }

        if (array[2] == 'X' && array[5] == 'X' && array[8] == 'X') {
            rightVerticalWinCountX++;
            xWinCount++;
        }

        // diagonal x win logic

        if (array[0] == 'X' && array[4] == 'X' && array[8] == 'X')  {
            leftToRightDiagonalWinCountX++;
            xWinCount++;
        }

        if (array[2] == 'X' && array[4] == 'X' && array[6] == 'X') {
            rightToLeftDiagonalWinCountX++;
            xWinCount++;
        }

        //horizontal o win logic

        if (array[0] == 'O' && array[1] == 'O' && array[2] == 'O')  {
            topHorizontalWinCountO++;
            oWinCount++;
        }

        if (array[3] == 'O' && array[4] == 'O' && array[5] == 'O') {
            midHorizontalWinCountO++;
            oWinCount++;
        }

        if (array[6] == 'O' && array[7] == 'O' && array[8] == 'O') {
            bottomHorizontalWinCountO++;
            oWinCount++;
        }

        // vertical o win logic

        if (array[0] == 'O' && array[3] == 'O' && array[6] == 'O')  {
            leftVerticalWinCountO++;
            oWinCount++;
        }

        if (array[1] == 'O' && array[4] == 'O' && array[7] == 'O') {
            midVerticalWinCountO++;
            oWinCount++;
        }

        if (array[2] == 'O' && array[5] == 'O' && array[8] == 'O') {
            rightVerticalWinCountO++;
            oWinCount++;
        }

        // diagonal o win logic

        if (array[0] == 'O' && array[4] == 'O' && array[8] == 'O')  {
            leftToRightDiagonalWinCountO++;
            oWinCount++;
        }

        if (array[2] == 'O' && array[4] == 'O' && array[6] == 'O') {
            rightToLeftDiagonalWinCountO++;
            oWinCount++;
        }

        // game over logic
        if (numPiecesLaid == 9 || Math.abs(xPiecesLaid - oPiecesLaid) > 1 || Math.abs(xPiecesLaid - oPiecesLaid) < 0 || xWinCount > 0 || oWinCount > 0) {
            gameIsOver = true;
        } else {
            System.out.println("Game not finished");
        }

        // initialize game state arrays for all game states to be tracked and compared simultaneously
        int[] gameStateArrayX = {topHorizontalWinCountX, midHorizontalWinCountX, bottomHorizontalWinCountX, leftVerticalWinCountX, midVerticalWinCountX, rightVerticalWinCountX, leftToRightDiagonalWinCountX, rightToLeftDiagonalWinCountX};

        int[] gameStateArrayO = {topHorizontalWinCountO, midHorizontalWinCountO, bottomHorizontalWinCountO, leftVerticalWinCountO, midVerticalWinCountO, rightVerticalWinCountO, leftToRightDiagonalWinCountO, rightToLeftDiagonalWinCountO};

        //***** ADD count totals to game state arrays - determine winner for the game -- *****

        if (gameIsOver) {
            for (int i = 0; i < gameStateArrayX.length; i++) {
                totalWinCount += gameStateArrayX[i];
                totalWinCount += gameStateArrayO[i];
            }
            if (totalWinCount > 1 || Math.abs(xPiecesLaid - oPiecesLaid) > 1 || Math.abs(xPiecesLaid - oPiecesLaid) < 0) {
                System.out.println("Impossible");
            } else if (xWinCount == 1) {
                System.out.println("X wins");
            } else if (oWinCount == 1) {
                System.out.println("O wins");
            } else {
                System.out.println("Draw");
            }
        }

        // ONLY IF gameIsOver == true (won't print "game not finished" anymore)
        // make sure there is only one winner by tracking number of wins (below winCount variable),
        // if there is only one, print the winner,
        // if there is more than one, print impossible,
        // if there is zero, print draw
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
