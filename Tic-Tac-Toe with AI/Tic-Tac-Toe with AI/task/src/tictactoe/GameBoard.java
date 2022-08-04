package tictactoe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    private final static Scanner input = new Scanner(System.in);

    private boolean isGameOver = false;
    private String[][] gameBoard = new String[3][3];

    private String[][] testGameBoard = new String[3][3];
    private int[] validUserCoordinates = new int[2];
    private final String[] gamePieces = {GamePieces.X.getGamePiece(), GamePieces.O.getGamePiece()};
    private String currentGamePiece;
    private int gamePieceCount;

    public GameBoard() {

    }

    // ***** GAME BOARD *****

    protected void initializeGameBoard() {

        for (int i = 0; i < getGameBoard().length; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                getTestGameBoard()[i][j] = " ";
            }
        }

        setGameBoard(getTestGameBoard());
    }

    protected void printGameBoard() {

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

        // update number of game pieces on game board
        updateNumberOfPiecesOnBoard();

        // update current game piece
        chooseGamePiece();

    }

    private String[][] cloneGameBoard() {

        String[][] newGameBoard = new String[3][3];

        for (int i = 0; i < getGameBoard().length; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                newGameBoard[i][j] = getGameBoard()[i][j];
            }
        }

        return newGameBoard;
    }

    // ***** SWITCH GAME PIECE ON EVERY TURN *****

    private void chooseGamePiece() {

        // if there are an even number of game pieces already on the board, the game piece is "X", otherwise it's "O"

        if (getGamePieceCount() % 2 == 0) {
            setCurrentGamePiece(getGamePieces()[0]);
        } else {
            setCurrentGamePiece(getGamePieces()[1]);
        }

    }

    // keeps track of the number of pieces currently on the game board
    private void updateNumberOfPiecesOnBoard() {
        int gamePieceCount = 0;

        for (int i = 0; i < getGameBoard().length; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                for (String gamePiece : getGamePieces()) {
                    if (getGameBoard()[i][j].equals(gamePiece)) {
                        gamePieceCount++;
                    }
                }
            }
        }

        setGamePieceCount(gamePieceCount);
    }

    // ***** COMPUTER AI LOGIC *****

    protected void getComputerCoordinates() {

        boolean computerCoordinatesValid = false;

        System.out.print("Making move level \"easy\""); // levels will need to be turned into an array and called based on user selection
        System.out.println();

        while(!computerCoordinatesValid) {

            Random random = new Random();

            int computerCoordinate1 = random.nextInt(3);
            int computerCoordinate2 = random.nextInt(3);

            // validate user coordinates

            computerCoordinatesValid = isValidInput(computerCoordinate1, computerCoordinate2);

        }

    }

    // ***** GET USER COORDINATES *****

    protected void getUserCoordinates() {

        boolean userCoordinatesValid = false;

        while(!userCoordinatesValid) {

            System.out.print("Enter the coordinates: ");

            // empty coordinates in order to use validate input method
            int userCoordinate1 = 0;
            int userCoordinate2 = 0;

            // validate user coordinates

            userCoordinatesValid = isValidInput(userCoordinate1, userCoordinate2);

        }

    }

    // ***** VALIDATE COORDINATES AND ADD THEM TO GAME BOARD *****
    private boolean isValidInput(int coordinate1, int coordinate2) {

        boolean currentGamePieceIsX = getCurrentGamePiece().equals(getGamePieces()[0]);

        try {

            if (currentGamePieceIsX) {
                coordinate1 = input.nextInt() - 1;
                coordinate2 = input.nextInt() - 1;
            }

            int[] testCoordinates = {coordinate1, coordinate2};

            setValidUserCoordinates(testCoordinates);

            setTestGameBoard(checkForGamePieceInCoordinateLocation(getValidUserCoordinates()));

            String coordinate = getGameBoard()[getValidUserCoordinates()[0]][getValidUserCoordinates()[1]];

            if (coordinate.equals(getGamePieces()[0]) || coordinate.equals(getGamePieces()[1])) {
                throw new CellOccupiedException("This cell is occupied! Choose another one!");
            } else {
                setGameBoard(getTestGameBoard());
                return true;
            }

        } catch (CellOccupiedException cellOccupiedException) {
            if (currentGamePieceIsX) {
                System.out.println(cellOccupiedException.getMessage());
            }
        // check that coordinates are numbers
        } catch (InputMismatchException inputMismatchException) {
            if (currentGamePieceIsX) {
                System.out.println("You should enter numbers!");
                input.nextLine(); // consume input
            }
        // check that coordinates are within correct range
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            if (currentGamePieceIsX) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
        return false;
    }

    private String[][] checkForGamePieceInCoordinateLocation(int[] validUserCoordinates) {

        setTestGameBoard(cloneGameBoard());

        getTestGameBoard()[validUserCoordinates[0]][validUserCoordinates[1]] = getCurrentGamePiece();

        return getTestGameBoard();

    }

    // ***** GET AND TEST USER CELLS AND ADD THEM TO GAME BOARD *****

    protected void getUserCells() {

        System.out.print("Enter the cells: ");

        // get all cells and split them into an array
        String[] userCells = input.nextLine().split("");

        // add to the game board
        setGameBoard(translateUserInput(userCells));

        // print game board
        printGameBoard();
    }

    // translate the user input String into the test game board array
    private String[][] translateUserInput(String[] userInput) {

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

    // ***** DEFINE WINS AND CHECK FOR WINNER *****
    protected boolean checkForWinner() {

        printGameBoard(); // keeps game board in correct order for tests

        boolean gameWon = false;
        String winner;

        for (String gamePieceCheck : getGamePieces()) {
            for (int i = 0; i < getGameBoard().length; i++) {

                String gamePiece1 = "";
                String gamePiece2 = "";
                String gamePiece3 = "";

                for (int j = 0; j < getGameBoard()[i].length; j++) {

                    // check for left to right diagonal winner
                    if (i == 0 && j == 0) {
                        gamePiece1 = getGameBoard()[i][j];
                        gamePiece2 = getGameBoard()[i + 1][j + 1];
                        gamePiece3 = getGameBoard()[i + 2][j + 2];

                        if (isWinner(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3)) {
                            break;
                        }
                    }

                    // check for right to left diagonal winner
                    if (i == 0 && j == 2) {
                        gamePiece1 = getGameBoard()[i][j];
                        gamePiece2 = getGameBoard()[i + 1][j - 1];
                        gamePiece3 = getGameBoard()[i + 2][j - 2];

                        if (isWinner(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3)) {
                            break;
                        }
                    }

                    // check for horizontal winner
                    if (j == 0) {
                        gamePiece1 = getGameBoard()[i][j];
                        gamePiece2 = getGameBoard()[i][j + 1];
                        gamePiece3 = getGameBoard()[i][j + 2];

                        if (isWinner(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3)) {
                            break;
                        }
                    }

                    // check for vertical winner
                    if (i == 0) {
                        gamePiece1 = getGameBoard()[i][j];
                        gamePiece2 = getGameBoard()[i + 1][j];
                        gamePiece3 = getGameBoard()[i + 2][j];

                        if (isWinner(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3)) {
                            break;
                        }
                    }
                }

                // break loop if game won
                gameWon = isWinner(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3);
                if (gameWon) {
                    winner = gamePieceCheck;
                    System.out.println(winner + " wins");
                    return true;
                }
            }
        }

        if (getGamePieceCount() == 9) {
            System.out.println("Draw");
            return true;
        } else {
//            System.out.println("Game not finished");
            return false;
        }
    }

    private boolean isWinner(String gamePieceCheck, String gamePiece1, String gamePiece2, String gamePiece3) {

        return gamePieceCheck.equals(gamePiece1) && gamePieceCheck.equals(gamePiece2) && gamePieceCheck.equals(gamePiece3);

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

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public String getCurrentGamePiece() {
        return currentGamePiece;
    }

    public void setCurrentGamePiece(String currentGamePiece) {
        this.currentGamePiece = currentGamePiece;
    }

    public String[] getGamePieces() {
        return gamePieces;
    }

    public int getGamePieceCount() {
        return gamePieceCount;
    }

    public void setGamePieceCount(int gamePieceCount) {
        this.gamePieceCount = gamePieceCount;
    }
}
