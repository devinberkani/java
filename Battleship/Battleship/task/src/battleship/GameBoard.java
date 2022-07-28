package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    static Scanner scanner = new Scanner(System.in);
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
        boolean exceptionThrown = false;

        while (!allCoordinatesReceived) {

            if (!exceptionThrown) {
                System.out.printf("Enter the coordinates of the %s %s:", gamePieceChoices[currentGamePieceIndex], gamePieceChoicesLengths[currentGamePieceIndex]);
                System.out.println();
            }

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

            String[][] updatedGameBoard;

            if (currentGamePieceIndex == 0) {
                try {
                    setAircraftCarrier(new GamePiece(getGameBoard(), gamePieceCoordinates, currentGamePieceIndex));
                    updatedGameBoard = getAircraftCarrier().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    printGameBoard();
                    exceptionThrown = false;
                    currentGamePieceIndex++;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
            } else if (currentGamePieceIndex == 1) {
                try {
                    setBattleship(new GamePiece(getGameBoard(), gamePieceCoordinates, currentGamePieceIndex));
                    updatedGameBoard = getBattleship().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    printGameBoard();
                    exceptionThrown = false;
                    currentGamePieceIndex++;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
            } else if (currentGamePieceIndex == 2) {
                try {
                    setSubmarine(new GamePiece(getGameBoard(), gamePieceCoordinates, currentGamePieceIndex));
                    updatedGameBoard = getSubmarine().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    printGameBoard();
                    exceptionThrown = false;
                    currentGamePieceIndex++;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
            } else if (currentGamePieceIndex == 3) {
                try {
                    setCruiser(new GamePiece(getGameBoard(), gamePieceCoordinates, currentGamePieceIndex));
                    updatedGameBoard = getCruiser().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    printGameBoard();
                    exceptionThrown = false;
                    currentGamePieceIndex++;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
            } else {
                try {
                    setDestroyer(new GamePiece(getGameBoard(), gamePieceCoordinates, currentGamePieceIndex));
                    updatedGameBoard = getDestroyer().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    printGameBoard();
                    exceptionThrown = false;
                    allCoordinatesReceived = true;
                    System.out.println("The game starts!");
                    printGameBoard();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
            }
        }

    }

    // ***** TAKE SHOT *****
    public void takeShot() {

        String hit = "X";
        String miss = "M";
        String result = "~";

        System.out.println("Take a shot!");

        boolean correctShotCoordinates = false;

        while (!correctShotCoordinates) {

            String[] shotCoordinatesString = scanner.next().split("");

            if (correctShotCoordinates(shotCoordinatesString)) {

                correctShotCoordinates = true;

                int[] shotCoordinatesIndices = translateShotCoordinates(shotCoordinatesString);

                String shotLocation = getGameBoard()[shotCoordinatesIndices[0]][shotCoordinatesIndices[1]];

                if (shotLocation.equals("~")) {
                    result = miss;
                } else if (shotLocation.equals("O")) {
                    result = hit;
                }

                String[][] updatedGameboard = new String[10][10];

                for(int i = 0; i < getGameBoard().length; i++) {
                    for (int j = 0; j < getGameBoard()[i].length; j++) {
                        if (i == shotCoordinatesIndices[0] && j == shotCoordinatesIndices[1]) {
                            updatedGameboard[i][j] = result;
                        } else {
                            updatedGameboard[i][j] = getGameBoard()[i][j];
                        }
                    }
                }

                setGameBoard(updatedGameboard);
                printGameBoard();

                if (result.equals(miss)) {
                    System.out.println("You missed!");
                } else if (result.equals(hit)) {
                    System.out.println("You hit a ship!");
                }

            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }
    }

    public boolean correctShotCoordinates (String[] shotCoordinates) {

//        System.out.println("length of these coordinates is " + shotCoordinates.length);

        // if length of given coordinates is greater than 3
        if (shotCoordinates.length < 2 || shotCoordinates.length > 3) {
//            System.out.println("length ok");
            return false;
        }

        // if first index isn't a letter
        boolean letterFound = false;
        for (String letter : columnLetters) {
            if (shotCoordinates[0].equalsIgnoreCase(letter)) {
//                System.out.println("letter ok");
                letterFound = true;
                break;
            }
        }

        if (!letterFound) {
            return false;
        }

        // if second index is less than 1 or greater than 10
        String numberCoordinateString;
        if (shotCoordinates.length == 2) {
            numberCoordinateString = shotCoordinates[1];
//            System.out.println("string number assigned");
        } else {
            numberCoordinateString = shotCoordinates[1] + shotCoordinates[2];
        }

        int numberCoordinate = Integer.parseInt(numberCoordinateString);

//        System.out.println("number coordinate is " + numberCoordinate);

        if (numberCoordinate < 1 || numberCoordinate > 10) {
            return false;
        }

        return true;
    }

    public int[] translateShotCoordinates(String[] shotCoordinates) {

        int[] shotCoordinatesIndices = new int[2];

        // translate the coordinates into indices
        int letterCount = 0;
        for (String letter : columnLetters) {
            if (shotCoordinates[0].equalsIgnoreCase(letter)) {
                shotCoordinates[0] = String.valueOf(letterCount);
            }
            letterCount++;
        }

        // handle 3 digit coordinate lengths

        if (shotCoordinates.length > 2) {
            String number = shotCoordinates[1] + shotCoordinates[2];
            shotCoordinates[1] = number;
        }

        shotCoordinatesIndices[0] = Integer.parseInt(shotCoordinates[0]);
        shotCoordinatesIndices[1] = Integer.parseInt(shotCoordinates[1]) - 1;

        return shotCoordinatesIndices;
    }
}
