package tictactoe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    private final static Scanner input = new Scanner(System.in);
    private boolean isGameOver = false;

    private Player player1;
    private Player player2;

    private Player currentPlayer;
    private String[][] gameBoard = new String[3][3];

    private String[][] testGameBoard = new String[3][3];
    private int[] validUserCoordinates = new int[2];
    private final String[] gamePieceChoices = {"X", "O"};
    private int gamePieceCount;

    private boolean opponentHasTwoPiecesInRow;
    private boolean currentPlayerHasTwoPiecesInRow;
    private int[] mediumCoordinates = new int[2];

    public GameBoard(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard();
        printGameBoard();
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

        // update current player
        chooseCurrentPlayer();

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

    private void chooseCurrentPlayer() {

        // if there are an even number of game pieces already on the board, the current player is player 1, otherwise it's player 2

        if (getGamePieceCount() % 2 == 0) {
            setCurrentPlayer(getPlayer1());
        } else {
            setCurrentPlayer(getPlayer2());
        }
    }

    // keeps track of the number of pieces currently on the game board
    private void updateNumberOfPiecesOnBoard() {
        int gamePieceCount = 0;

        for (int i = 0; i < getGameBoard().length; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                for (String gamePiece : getGamePieceChoices()) {
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

        String difficultyLevel = getCurrentPlayer().getType();

        System.out.println("Making move level " + "\"" + difficultyLevel + "\"");

        boolean computerCoordinatesValid = false;

        while(!computerCoordinatesValid) {

            Random random = new Random();

            int[] computerCoordinates = new int[2];

            if (difficultyLevel.equalsIgnoreCase("easy")) {
                computerCoordinates = getEasyCoordinates();
            } if (difficultyLevel.equalsIgnoreCase("medium")) {
                computerCoordinates = getMediumCoordinates();
            }

            // validate user coordinates

            computerCoordinatesValid = isValidInput(computerCoordinates[0], computerCoordinates[1]);

        }

    }

    private int[] getEasyCoordinates() {

        Random random = new Random();

        int computerCoordinate1 = random.nextInt(3);
        int computerCoordinate2 = random.nextInt(3);

        return new int[]{computerCoordinate1, computerCoordinate2};
    }

    private int[] getMediumCoordinates() {

        // if computer is at risk of losing, use medium ai logic, else use easy logic to produce random coordinates

        if (isOpponentHasTwoPiecesInRow()) {
            return mediumCoordinates;
        } else {
            return getEasyCoordinates();
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

        boolean playerIsHuman = getCurrentPlayer().getType().equalsIgnoreCase("user");

        try {

            if (playerIsHuman) {
                coordinate1 = input.nextInt() - 1;
                coordinate2 = input.nextInt() - 1;
            }

            int[] testCoordinates = {coordinate1, coordinate2};

            setValidUserCoordinates(testCoordinates);

            setTestGameBoard(checkForGamePieceInCoordinateLocation(getValidUserCoordinates()));

            String coordinate = getGameBoard()[getValidUserCoordinates()[0]][getValidUserCoordinates()[1]];

            if (coordinate.equals(getGamePieceChoices()[0]) || coordinate.equals(getGamePieceChoices()[1])) {
                throw new CellOccupiedException("This cell is occupied! Choose another one!");
            } else {
                setGameBoard(getTestGameBoard());
                return true;
            }

        } catch (CellOccupiedException cellOccupiedException) {
            if (playerIsHuman) {
                System.out.println(cellOccupiedException.getMessage());
            }
        // check that coordinates are numbers
        } catch (InputMismatchException inputMismatchException) {
            if (playerIsHuman) {
                System.out.println("You should enter numbers!");
                input.nextLine(); // consume input
            }
        // check that coordinates are within correct range
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            if (playerIsHuman) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
        return false;
    }

    private String[][] checkForGamePieceInCoordinateLocation(int[] validUserCoordinates) {

        setTestGameBoard(cloneGameBoard());

        getTestGameBoard()[validUserCoordinates[0]][validUserCoordinates[1]] = getCurrentPlayer().getGamePiece();

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

    // ***** DEFINE WINS AND CHECKS GAME BOARD FOR GAME PIECES IN A ROW AND WINNER *****
    protected boolean checkGameBoard() {

        // reset medium ai opponent logic
//        System.out.println("current player is " + getCurrentPlayer().getGamePiece());
//        System.out.println("current player has two pieces in a row? " + isCurrentPlayerHasTwoPiecesInRow());
//        System.out.println("opponent has two pieces in a row? " + isOpponentHasTwoPiecesInRow());
        setCurrentPlayerHasTwoPiecesInRow(false);
        setOpponentHasTwoPiecesInRow(false);
        printGameBoard(); // keeps game board in correct order for tests

        boolean gameWon = false;
        String winner;

        for (String gamePieceCheck : getGamePieceChoices()) {
            for (int i = 0; i < getGameBoard().length; i++) {

                // IF 2/3 OF THESE SCENARIOS ARE TRUE, COMPUTER SHOULD BLOCK WITH NEXT MOVE ON MEDIUM LEVEL, OR TAKE THE WIN IF IN ITS FAVOR

                String gamePiece1 = "";
                String gamePiece2 = "";
                String gamePiece3 = "";

                int mediumCoordinate1 = 0;
                int mediumCoordinate2 = 0;

                for (int j = 0; j < getGameBoard()[i].length; j++) {

                    // check for left to right diagonal winner
                    if (i == 0 && j == 0) {
                        gamePiece1 = getGameBoard()[i][j];
                        gamePiece2 = getGameBoard()[i + 1][j + 1];
                        gamePiece3 = getGameBoard()[i + 2][j + 2];

                        if (gamePieceCheck.equals(gamePiece1) && gamePieceCheck.equals(gamePiece2) && gamePieceCheck.equals(gamePiece3)) {
                            break;
                        } else if (isTwoGamePiecesInRow(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3)) {
                            if (isCurrentPlayerHasTwoPiecesInRow()) {
                                if (gamePiece1.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece2.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 1;
                                    mediumCoordinate2 = j + 1;
                                } else if (gamePiece3.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 2;
                                    mediumCoordinate2 = j + 2;
                                }
                                setMediumCoordinates(new int[]{mediumCoordinate1, mediumCoordinate2});
                                break;
                            } else if (isOpponentHasTwoPiecesInRow()) {
                                if (gamePiece1.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece2.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 1;
                                    mediumCoordinate2 = j + 1;
                                } else if (gamePiece3.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 2;
                                    mediumCoordinate2 = j + 2;
                                }
                                setMediumCoordinates(new int[]{mediumCoordinate1, mediumCoordinate2});
                            }
                        }
                    }

                    // check for right to left diagonal winner
                    if (i == 0 && j == 2) {
                        gamePiece1 = getGameBoard()[i][j];
                        gamePiece2 = getGameBoard()[i + 1][j - 1];
                        gamePiece3 = getGameBoard()[i + 2][j - 2];

                        if (gamePieceCheck.equals(gamePiece1) && gamePieceCheck.equals(gamePiece2) && gamePieceCheck.equals(gamePiece3)) {
                            break;
                        } else if (isTwoGamePiecesInRow(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3)) {
                            if (isCurrentPlayerHasTwoPiecesInRow()) {
                                if (gamePiece1.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece2.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 1;
                                    mediumCoordinate2 = j - 1;
                                } else if (gamePiece3.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 2;
                                    mediumCoordinate2 = j - 2;
                                }
                                setMediumCoordinates(new int[]{mediumCoordinate1, mediumCoordinate2});
                                break;
                            } else if (isOpponentHasTwoPiecesInRow()) {
                                if (gamePiece1.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece2.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 1;
                                    mediumCoordinate2 = j - 1;
                                } else if (gamePiece3.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 2;
                                    mediumCoordinate2 = j - 2;
                                }
                                setMediumCoordinates(new int[]{mediumCoordinate1, mediumCoordinate2});
                            }
                        }
                    }

                    // check for horizontal winner
                    if (j == 0) {
                        gamePiece1 = getGameBoard()[i][j];
                        gamePiece2 = getGameBoard()[i][j + 1];
                        gamePiece3 = getGameBoard()[i][j + 2];

                        if (gamePieceCheck.equals(gamePiece1) && gamePieceCheck.equals(gamePiece2) && gamePieceCheck.equals(gamePiece3)) {
                            break;
                        } else if (isTwoGamePiecesInRow(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3)) {
                            if (isCurrentPlayerHasTwoPiecesInRow()) {
                                if (gamePiece1.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece2.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j + 1;
                                } else if (gamePiece3.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j + 2;
                                }
                                setMediumCoordinates(new int[]{mediumCoordinate1, mediumCoordinate2});
                                break;
                            } else if (isOpponentHasTwoPiecesInRow()) {
                                if (gamePiece1.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece2.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j + 1;
                                } else if (gamePiece3.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j + 2;
                                }
                                setMediumCoordinates(new int[]{mediumCoordinate1, mediumCoordinate2});
                            }
                        }
                    }

                    // check for vertical winner
                    if (i == 0) {
                        gamePiece1 = getGameBoard()[i][j];
                        gamePiece2 = getGameBoard()[i + 1][j];
                        gamePiece3 = getGameBoard()[i + 2][j];

                        if (gamePieceCheck.equals(gamePiece1) && gamePieceCheck.equals(gamePiece2) && gamePieceCheck.equals(gamePiece3)) {
                            break;
                        } else if (isTwoGamePiecesInRow(gamePieceCheck, gamePiece1, gamePiece2, gamePiece3)) {
                            if (isCurrentPlayerHasTwoPiecesInRow()) {
                                if (gamePiece1.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece2.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 1;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece3.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 2;
                                    mediumCoordinate2 = j;
                                }
                                setMediumCoordinates(new int[]{mediumCoordinate1, mediumCoordinate2});
                                break;
                            } else if (isOpponentHasTwoPiecesInRow()) {
                                if (gamePiece1.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece2.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 1;
                                    mediumCoordinate2 = j;
                                } else if (gamePiece3.equalsIgnoreCase(" ")) {
                                    mediumCoordinate1 = i + 2;
                                    mediumCoordinate2 = j;
                                }
                                setMediumCoordinates(new int[]{mediumCoordinate1, mediumCoordinate2});
                            }
                        }
                    }
                }

                // break loop if game won
                gameWon = gamePieceCheck.equals(gamePiece1) && gamePieceCheck.equals(gamePiece2) && gamePieceCheck.equals(gamePiece3);
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

    private boolean isTwoGamePiecesInRow(String gamePieceCheck, String gamePiece1, String gamePiece2, String gamePiece3) {

        ArrayList<String> gamePiecesChecked = new ArrayList<>();

        // logic for medium level ai

        gamePiecesChecked.add(gamePiece1);
        gamePiecesChecked.add(gamePiece2);
        gamePiecesChecked.add(gamePiece3);

        if (getCurrentPlayer().getGamePiece().equalsIgnoreCase(gamePieceCheck)) {
            // if the game piece matches the game piece being checked && it IS the current player's piece, remove it from the array
            gamePiecesChecked.removeIf(gamePiece -> gamePiece.equalsIgnoreCase(gamePieceCheck) && gamePiece.equalsIgnoreCase(getCurrentPlayer().getGamePiece()));
            // if there is only one left and it is blank, this is where the computer should try to go,
            if (gamePiecesChecked.size() == 1) {
                // make sure the space is blank
                setCurrentPlayerHasTwoPiecesInRow(gamePiecesChecked.get(0).equalsIgnoreCase(" "));
                return gamePiecesChecked.get(0).equalsIgnoreCase(" ");
            }
        } else {
            // if the game piece matches the game piece being checked && it is NOT the current player's piece, remove it from the array
            gamePiecesChecked.removeIf(gamePiece -> gamePiece.equalsIgnoreCase(gamePieceCheck) && !gamePiece.equalsIgnoreCase(getCurrentPlayer().getGamePiece()));
            // if there is only one left and it is blank, this is where the computer should try to go,
            if (gamePiecesChecked.size() == 1) {
                // make sure the space is blank
                setOpponentHasTwoPiecesInRow(gamePiecesChecked.get(0).equalsIgnoreCase(" "));
                return gamePiecesChecked.get(0).equalsIgnoreCase(" ");
            }
        }
        return false;
    }

    // ***** GETTERS AND SETTERS *****


    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

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

    public String[] getGamePieceChoices() {
        return gamePieceChoices;
    }

    public int getGamePieceCount() {
        return gamePieceCount;
    }

    public void setGamePieceCount(int gamePieceCount) {
        this.gamePieceCount = gamePieceCount;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setMediumCoordinates(int[] mediumCoordinates) {
        this.mediumCoordinates = mediumCoordinates;
    }

    public boolean isOpponentHasTwoPiecesInRow() {
        return opponentHasTwoPiecesInRow;
    }

    public void setOpponentHasTwoPiecesInRow(boolean opponentHasTwoPiecesInRow) {
        this.opponentHasTwoPiecesInRow = opponentHasTwoPiecesInRow;
    }

    public boolean isCurrentPlayerHasTwoPiecesInRow() {
        return currentPlayerHasTwoPiecesInRow;
    }

    public void setCurrentPlayerHasTwoPiecesInRow(boolean currentPlayerHasTwoPiecesInRow) {
        this.currentPlayerHasTwoPiecesInRow = currentPlayerHasTwoPiecesInRow;
    }
}
