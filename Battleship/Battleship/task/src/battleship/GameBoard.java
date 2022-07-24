package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    private final String[] rowNumbers = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private final String[] columnLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private String[][] gameBoard = new String[10][10];

    private GamePiece aircraftCarrier;

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
                System.out.print(gameBoard[i][j]);
                if (j != getGameBoard()[i].length - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    // ***** AIRCRAFT CARRIER *****
    public GamePiece getAircraftCarrier() {
        return aircraftCarrier;
    }

    public void setAircraftCarrier(GamePiece aircraftCarrier) {
        this.aircraftCarrier = aircraftCarrier;
    }

    // ***** GET COORDINATES *****

    public void getCoordinates() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");

        String[] aircraftCarrierStart = scanner.next().split("");
        String[] aircraftCarrierEnd = scanner.next().split("");

        scanner.close();

        // translate the coordinates into indices
        int letterCount = 0;
        for (String letter : columnLetters) {
            if (aircraftCarrierStart[0].equalsIgnoreCase(letter)) {
                aircraftCarrierStart[0] = String.valueOf(letterCount);
            }
            if (aircraftCarrierEnd[0].equalsIgnoreCase(letter)) {
                aircraftCarrierEnd[0] = String.valueOf(letterCount);
            }
            letterCount++;
        }

        // change from strings to integers
        int[] aircraftCarrierCoordinates = new int[4];

        aircraftCarrierCoordinates[0] = Integer.parseInt(aircraftCarrierStart[0]);
        aircraftCarrierCoordinates[1] = Integer.parseInt(aircraftCarrierStart[1]);
        aircraftCarrierCoordinates[2] = Integer.parseInt(aircraftCarrierEnd[0]);
        aircraftCarrierCoordinates[3] = Integer.parseInt(aircraftCarrierEnd[1]);

        for (int coordinate : aircraftCarrierCoordinates) {
            System.out.println(coordinate);
        }

        this.aircraftCarrier = new GamePiece(aircraftCarrierCoordinates);

        setAircraftCarrier(this.aircraftCarrier);
    }
}
