package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameBoard {
    private final static Scanner input = new Scanner(System.in);

    private boolean isGameOver = false;
    private String[][] gameBoard = new String[3][3];

    private String[][] testGameBoard = new String[3][3];
    private int[] validUserCoordinates = new int[2];

    private final String[] gamePieces = {"X", "O"};
    private int currentGamePieceIndex = 0; //USE ENUM FOR THIS?

    public GameBoard() {
        getUserCells();
        getUserCoordinates();
        printGameBoard();
        switchGamePieceIndex();
    }

    // ***** GAME BOARD *****

    public void printGameBoard() {

        // print top row
        String topBottomBorder = "---------";
        System.out.println(topBottomBorder);

        // print game board
        for (int i = 0; i < getGameBoard().length; i++) {
            // print left border character
            String leftRightBorderCharacter = "|";
            System.out.print(leftRightBorderCharacter + " ");
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                System.out.print(getGameBoard()[i][j] + " ");
            }
            // print right border character
            System.out.println(leftRightBorderCharacter);
        }

        // print bottom row
        System.out.println(topBottomBorder);
    }

    public String[][] cloneGameBoard() {

        String[][] newGameBoard = new String[3][3];

        for (int i = 0; i < getGameBoard().length; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                newGameBoard[i][j] = getGameBoard()[i][j];
            }
        }

        return newGameBoard;
    }

    // ***** SWITCH GAME PIECE ON EVERY TURN *****

    public void switchGamePieceIndex() {

        if (getCurrentGamePieceIndex() == 0) {
            setCurrentGamePieceIndex(1);
        }
        if (getCurrentGamePieceIndex() == 1) {
            setCurrentGamePieceIndex(0);
        }

    }

    // ***** GET AND VALIDATE USER COORDINATES *****

    public void getUserCoordinates() {

        boolean isValid = false;

        while(!isValid) {

            System.out.print("Enter the coordinates: ");

            // validate user coordinates

            isValid = isValidInput();

        }

    }

    public boolean isValidInput() {

        // YOU ARE HERE
        try {
            for (int i = 0; i < getValidUserCoordinates().length; i++) {
                getValidUserCoordinates()[i] = input.nextInt() - 1;
            }

            setTestGameBoard(testCoordinates(getValidUserCoordinates()));

            String coordinate = getGameBoard()[getValidUserCoordinates()[0]][getValidUserCoordinates()[1]];

            if (coordinate.equals("X") || coordinate.equals("O")) {
                throw new CellOccupiedException("This cell is occupied! Choose another one!");
            } else {
                setGameBoard(getTestGameBoard());
                return true;
            }

        } catch (CellOccupiedException cellOccupiedException) {
            System.out.println(cellOccupiedException.getMessage());
        // check that coordinates are numbers
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("You should enter numbers!");
            input.nextLine(); // consume input
        // check that coordinates are within correct range
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("Coordinates should be from 1 to 3!");
        }
        return false;
    }

    public String[][] testCoordinates(int[] validUserCoordinates) {

        setTestGameBoard(cloneGameBoard());

        getTestGameBoard()[validUserCoordinates[0]][validUserCoordinates[1]] = gamePieces[getCurrentGamePieceIndex()];

        return getTestGameBoard();

    }

    // ***** GET USER CELLS AND ADD THEM TO GAME BOARD *****

    public void getUserCells() {

        System.out.print("Enter the cells: ");

        // get all cells and split them into an array
        String[] userCells = input.nextLine().split("");

        // add to the game board
        setGameBoard(translateUserInput(userCells));

        // print game board
        printGameBoard();
    }

    public String[][] translateUserInput(String[] userInput) {

        // add user input to test game board

        int index = 0;
        for (int i = 0; i < getTestGameBoard().length; i++) {
            for (int j = 0; j < getTestGameBoard()[i].length; j++) {
                // if one of the cells is "_" it should be printed as an empty space
                if (userInput[index].equals("_")) {
                    getTestGameBoard()[i][j] = " ";
                } else {
                    getTestGameBoard()[i][j] = userInput[index];
                }
                index++;
            }
        }

        return getTestGameBoard();
    }

    // ***** GETTERS AND SETTERS *****

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String[][] getTestGameBoard() {
        return testGameBoard;
    }

    public void setTestGameBoard(String[][] testGameBoard) {
        this.testGameBoard = testGameBoard;
    }

    public int[] getValidUserCoordinates() {
        return validUserCoordinates;
    }

    public void setValidUserCoordinates(int[] validUserCoordinates) {
        this.validUserCoordinates = validUserCoordinates;
    }

    public int getCurrentGamePieceIndex() {
        return currentGamePieceIndex;
    }

    public void setCurrentGamePieceIndex(int currentGamePieceIndex) {
        this.currentGamePieceIndex = currentGamePieceIndex;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public String[] getGamePieces() {
        return gamePieces;
    }
}
