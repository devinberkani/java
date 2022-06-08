package tictactoe;

import java.util.Scanner;

public class Main {

    // initialize scanner
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here

        // define number of rows and columns for game
        int numOfRows = 3;
        int numOfColumns = 3;

        // initialize user input array
        char[][] userInputArray = new char[numOfRows][numOfColumns];
        for (int r = 0; r < userInputArray.length; r++) {
            for (int c = 0; c < userInputArray[r].length; c++) {
                userInputArray[r][c] = ' ';
            }
        }

        boolean endOfGame = false;
        boolean isPlayerX = true;


        while(!endOfGame) {

            //***print game board***
            endOfGame = printGameBoard(userInputArray, numOfRows, numOfColumns);

            if(endOfGame) {
                break;
            }

            //modify game pieces array based on user coordinate input
            enterCoordinates(userInputArray, numOfRows, numOfColumns, isPlayerX);

            // switches between X and O every time method is called
            isPlayerX = !isPlayerX;
        }

    }

    public static void enterCoordinates(char[][] array, int numOfRows, int numOfColumns, boolean isPlayerX) {
        // define user's piece

        char playerPiece = 'X';

        if(!isPlayerX) {
            playerPiece = 'O';
        }

        // get coordinates from user
        int rowPlacement = 0;
        int columnPlacement = 0;
        boolean isValid = false;

        //error logic

        do {
            System.out.print("Enter the coordinates: ");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            } else {
                rowPlacement = scanner.nextInt();
                columnPlacement = scanner.nextInt();
                if (rowPlacement < 1 || rowPlacement > 3 || columnPlacement < 1 || columnPlacement > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    scanner.nextLine();
                } else {
                    int xCoordinate = rowPlacement - 1;
                    int yCoordinate = columnPlacement - 1;
                    char attemptedPlacement = array[xCoordinate][yCoordinate];
                    if (attemptedPlacement == 'X' || attemptedPlacement == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                        scanner.nextLine();
                    } else {
                        array[xCoordinate][yCoordinate] = playerPiece;
                        isValid = true;
                    }
                }
            }
        } while (!isValid);

//        printGameBoard(array, numOfRows, numOfColumns);

    }
    public static boolean analyzeGameState(char[][] array, int numOfRows, int numOfColumns) {

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
                if (array[r][c] == 'X') {
                    xPiecesLaid++;
                    numPiecesLaid++;
                }
                if (array[r][c] == 'O') {
                    oPiecesLaid++;
                    numPiecesLaid++;
                }
//                arrayIndex++;
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

         if (array[0][0] == 'X' && array[0][1] == 'X' && array[0][2] == 'X')  {
             topHorizontalWinCountX++;
             xWinCount++;
         }

         if (array[1][0] == 'X' && array[1][1] == 'X' && array[1][2] == 'X') {
             midHorizontalWinCountX++;
             xWinCount++;
         }

         if (array[2][0] == 'X' && array[2][1] == 'X' && array[2][2] == 'X') {
             bottomHorizontalWinCountX++;
             xWinCount++;
         }

        // vertical x win logic

        if (array[0][0] == 'X' && array[1][0] == 'X' && array[2][0] == 'X')  {
            leftVerticalWinCountX++;
            xWinCount++;
        }

        if (array[0][1] == 'X' && array[1][1] == 'X' && array[2][1] == 'X') {
            midVerticalWinCountX++;
            xWinCount++;
        }

        if (array[0][2] == 'X' && array[1][2] == 'X' && array[2][2] == 'X') {
            rightVerticalWinCountX++;
            xWinCount++;
        }

        // diagonal x win logic

        if (array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X')  {
            leftToRightDiagonalWinCountX++;
            xWinCount++;
        }

        if (array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X') {
            rightToLeftDiagonalWinCountX++;
            xWinCount++;
        }

        //horizontal o win logic

        if (array[0][0] == 'O' && array[0][1] == 'O' && array[0][2] == 'O')  {
            topHorizontalWinCountO++;
            oWinCount++;
        }

        if (array[1][0] == 'O' && array[1][1] == 'O' && array[1][2] == 'O') {
            midHorizontalWinCountO++;
            oWinCount++;
        }

        if (array[2][0] == 'O' && array[2][1] == 'O' && array[2][2] == 'O') {
            bottomHorizontalWinCountO++;
            oWinCount++;
        }

        // vertical o win logic

        if (array[0][0] == 'O' && array[1][0] == 'O' && array[2][0] == 'O')  {
            leftVerticalWinCountO++;
            oWinCount++;
        }

        if (array[0][1] == 'O' && array[1][1] == 'O' && array[2][1] == 'O') {
            midVerticalWinCountO++;
            oWinCount++;
        }

        if (array[0][2] == 'O' && array[1][2] == 'O' && array[2][2] == 'O') {
            rightVerticalWinCountO++;
            oWinCount++;
        }

        // diagonal o win logic

        if (array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O')  {
            leftToRightDiagonalWinCountO++;
            oWinCount++;
        }

        if (array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O') {
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

        return gameIsOver;
        // ONLY IF gameIsOver == true (won't print "game not finished" anymore)
        // make sure there is only one winner by tracking number of wins (below winCount variable),
        // if there is only one, print the winner,
        // if there is more than one, print impossible,
        // if there is zero, print draw
    }

    public static boolean printGameBoard(char[][] array, int numOfRows, int numOfColumns) {

        //initialize game pieces array
        char[][] gamePiecesArray = new char[numOfRows][numOfColumns];

        //print top border
        System.out.println("---------");

        //variable for counting gameBoard array index
        for (int r = 0; r < numOfRows; r++) {
            //print left sidebar
            String sidebarCharacter = "|";
            System.out.print(sidebarCharacter + " ");
            for (int c = 0; c < numOfColumns; c++) {
                gamePiecesArray[r][c] = array[r][c];
                System.out.print(gamePiecesArray[r][c] + " ");
            }
            //print right sidebar
            System.out.print(sidebarCharacter);
            //new line
            System.out.println();
        }

        //print bottom border
        System.out.println("---------");

        //analyze game state
        return analyzeGameState(gamePiecesArray, numOfRows, numOfColumns);
    }

}
