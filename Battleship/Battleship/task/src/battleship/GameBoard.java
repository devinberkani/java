package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    private final String[] rowNumbers = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private final String[] columnLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private String[][] gameBoard = new String[10][10];
    private final String[] gamePieceChoices = {"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
    private final String[] gamePieceChoicesLengths = {"(5 cells)", "(4 cells)", "(3 cells)", "(3 cells)", "(2 cells)"};
    private GamePiece aircraftCarrier;
    private GamePiece battleship;
    private GamePiece submarine;
    private GamePiece cruiser;
    private GamePiece destroyer;

    public GameBoard() {
        // initialize empty game board
        for (String[] cell : gameBoard) {
            Arrays.fill(cell, "~");
        }
    }

    // ***** GAME BOARD *****

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void printGameBoard() {

        // print top row of game board
        for (int i = 0; i < rowNumbers.length; i++) {
            System.out.print(rowNumbers[i]);
            if (i != rowNumbers.length - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }

        // print the rest of the game board
        for (int i = 0; i < getGameBoard().length; i++) {
            System.out.print(columnLetters[i]);
            System.out.print(" ");
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                System.out.print(getGameBoard()[i][j]);
                if (j != getGameBoard()[i].length - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    // ***** GAME PIECES *****
    public GamePiece getAircraftCarrier() {
        return aircraftCarrier;
    }

    public void setAircraftCarrier(GamePiece aircraftCarrier) {
        this.aircraftCarrier = aircraftCarrier;
    }

    public GamePiece getBattleship() {
        return battleship;
    }

    public void setBattleship(GamePiece battleship) {
        this.battleship = battleship;
    }

    public GamePiece getSubmarine() {
        return submarine;
    }

    public void setSubmarine(GamePiece submarine) {
        this.submarine = submarine;
    }

    public GamePiece getCruiser() {
        return cruiser;
    }

    public void setCruiser(GamePiece cruiser) {
        this.cruiser = cruiser;
    }

    public GamePiece getDestroyer() {
        return destroyer;
    }

    public void setDestroyer(GamePiece destroyer) {
        this.destroyer = destroyer;
    }

    // ***** GET COORDINATES *****

    public void getCoordinates() {

        int currentGamePieceIndex = 0;
        boolean allCoordinatesReceived = false;

        while (!allCoordinatesReceived) {

            Scanner scanner = new Scanner(System.in);

            System.out.printf("Enter the coordinates of the %s %s:", gamePieceChoices[currentGamePieceIndex], gamePieceChoicesLengths[currentGamePieceIndex]);
            System.out.println();

            String[] coordinateStart = scanner.next().split("");
            String[] coordinateEnd = scanner.next().split("");

            // translate the coordinates into indices
            int letterCount = 0;
            for (String letter : columnLetters) {
                if (coordinateStart[0].equalsIgnoreCase(letter)) {
                    coordinateStart[0] = String.valueOf(letterCount);
                }
                if (coordinateEnd[0].equalsIgnoreCase(letter)) {
                    coordinateEnd[0] = String.valueOf(letterCount);
                }
                letterCount++;
            }

            // handle 3 digit coordinate lengths (the number 10)

            if (coordinateStart.length > 2) {
                coordinateStart[1] = "10";
            }
            if (coordinateEnd.length > 2) {
                coordinateEnd[1] = "10";

            }

            // change from strings to integers
            int[] gamePieceCoordinates = new int[4];

            gamePieceCoordinates[0] = Integer.parseInt(coordinateStart[0]);
            gamePieceCoordinates[1] = Integer.parseInt(coordinateStart[1]) - 1;
            gamePieceCoordinates[2] = Integer.parseInt(coordinateEnd[0]);
            gamePieceCoordinates[3] = Integer.parseInt(coordinateEnd[1]) - 1;

            // ********** VALIDATE GAME PIECES HERE **********

            String[][] updatedGameBoard;

            if (currentGamePieceIndex == 0) {
                setAircraftCarrier(new GamePiece(gamePieceCoordinates));
                updatedGameBoard = getAircraftCarrier().setGamePiece(getGameBoard(), gamePieceCoordinates);
                currentGamePieceIndex++;
            } else if (currentGamePieceIndex == 1) {
                setBattleship(new GamePiece(gamePieceCoordinates));
                updatedGameBoard = getBattleship().setGamePiece(getGameBoard(), gamePieceCoordinates);
                currentGamePieceIndex++;
            } else if (currentGamePieceIndex == 2) {
                setSubmarine(new GamePiece(gamePieceCoordinates));
                updatedGameBoard = getSubmarine().setGamePiece(getGameBoard(), gamePieceCoordinates);
                currentGamePieceIndex++;
            } else if (currentGamePieceIndex == 3) {
                setCruiser(new GamePiece(gamePieceCoordinates));
                updatedGameBoard = getCruiser().setGamePiece(getGameBoard(), gamePieceCoordinates);
                currentGamePieceIndex++;
            } else {
                setDestroyer(new GamePiece(gamePieceCoordinates));
                updatedGameBoard = getDestroyer().setGamePiece(getGameBoard(), gamePieceCoordinates);
                allCoordinatesReceived = true;
                scanner.close();
            }

            setGameBoard(updatedGameBoard);

            printGameBoard();
        }

    }
}
