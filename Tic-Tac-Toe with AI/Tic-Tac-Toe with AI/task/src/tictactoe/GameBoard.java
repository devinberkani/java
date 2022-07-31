package tictactoe;

import java.util.Scanner;

public class GameBoard {

    private final static Scanner input = new Scanner(System.in);
    private String[][] gameBoard = new String[3][3];

    private String[][] testGameBoard = new String[3][3];

    private int[] validUserCoordinates = new int[2];

    public GameBoard() {
        getUserCells();
    }

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

    // ***** GET USER COORDINATES *****

    public void getUserCoordinates() {

        boolean isValid = false;

        while(!isValid) {

            System.out.print("Enter the coordinates: ");

            // validate user coordinates
            isValid = isValidInput();

        }

    }

    public boolean isValidInput() throws Exception {

        // YOU ARE HERE

        try {
            for (int coordinate : getValidUserCoordinates()) {
                // check that the coordinate is a number
                coordinate = input.nextInt();
                // check that the coordinate is from 1 to 3
                if (coordinate < 1 || coordinate > 3) {
                    throw new Exception("");
                }
            }
        } catch (Exception e) {
            
        }

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
}
