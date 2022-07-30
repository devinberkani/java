package battleship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GameBoard {

    private boolean gameWon = false;
    private int shipCount = 5;
    static int currentGamePieceIndex = 0;
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

    private ArrayList<ArrayList<Integer>> aircraftCarrierCoordinates = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> battleshipCoordinates = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> submarineCoordinates = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> cruiserCoordinates = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> destroyerCoordinates = new ArrayList<>();

    private ArrayList<ArrayList<ArrayList<Integer>>> allShipCoordinates = new ArrayList<>();

    public GameBoard() {
        // initialize empty game board
        for (String[] cell : gameBoard) {
            Arrays.fill(cell, "~");
        }
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    public int getShipCount() {
        return shipCount;
    }

    public void setShipCount(int shipCount) {
        this.shipCount = shipCount;
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

        // list to hold all coordinates for each ship
        ArrayList<int[]> coordinatesHolder = new ArrayList<>();

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

    public void printFogGameBoard() {

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
                if (getGameBoard()[i][j].equalsIgnoreCase("X") || getGameBoard()[i][j].equalsIgnoreCase("M")) {
                    System.out.print(getGameBoard()[i][j]);
                } else {
                    System.out.print("~");
                }
                if (j != getGameBoard()[i].length - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }

    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getAllShipCoordinates() {
        return allShipCoordinates;
    }

    public void setAllShipCoordinates(ArrayList<ArrayList<ArrayList<Integer>>> allShipCoordinates) {
        this.allShipCoordinates = allShipCoordinates;
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

            String[][] previousGameBoard;
            String[][] updatedGameBoard;

            if (currentGamePieceIndex == 0) {
                try {
                    setAircraftCarrier(new GamePiece(getGameBoard(), gamePieceCoordinates, currentGamePieceIndex));
                    previousGameBoard = cloneCurrentGameBoard();
                    updatedGameBoard = getAircraftCarrier().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    compareGameBoards(previousGameBoard);
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
                    previousGameBoard = cloneCurrentGameBoard();
                    updatedGameBoard = getBattleship().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    compareGameBoards(previousGameBoard);
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
                    previousGameBoard = cloneCurrentGameBoard();
                    updatedGameBoard = getSubmarine().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    compareGameBoards(previousGameBoard);
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
                    previousGameBoard = cloneCurrentGameBoard();
                    updatedGameBoard = getCruiser().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    compareGameBoards(previousGameBoard);
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
                    previousGameBoard = cloneCurrentGameBoard();
                    updatedGameBoard = getDestroyer().setGamePiece();
                    setGameBoard(updatedGameBoard);
                    compareGameBoards(previousGameBoard);
                    currentGamePieceIndex = 0;
                    printGameBoard();
                    exceptionThrown = false;
                    allCoordinatesReceived = true;
                    promptEnterKey();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    exceptionThrown = true;
                }
            }
        }

    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[][] cloneCurrentGameBoard() {

        String[][] previousGameBoard = new String[10][10];

        for (int i = 0; i < getGameBoard().length; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                previousGameBoard[i][j] = getGameBoard()[i][j];
            }
        }

        return previousGameBoard;

    }

    public void compareGameBoards(String[][] previousGameBoard) {

        for (int i = 0; i < previousGameBoard.length; i++) {
            for (int j = 0; j < previousGameBoard[i].length; j++) {
                if (!Objects.equals(previousGameBoard[i][j], getGameBoard()[i][j])) {
                    ArrayList<Integer> temporaryGamePieceCoordinates = new ArrayList<>();
                    temporaryGamePieceCoordinates.add(i);
                    temporaryGamePieceCoordinates.add(j);

                    if (currentGamePieceIndex == 0) {
                        aircraftCarrierCoordinates.add(temporaryGamePieceCoordinates);
                    } else if (currentGamePieceIndex == 1) {
                        battleshipCoordinates.add(temporaryGamePieceCoordinates);
                    } else if (currentGamePieceIndex == 2) {
                        submarineCoordinates.add(temporaryGamePieceCoordinates);
                    } else if (currentGamePieceIndex == 3) {
                        cruiserCoordinates.add(temporaryGamePieceCoordinates);
                    } else if (currentGamePieceIndex == 4) {
                        destroyerCoordinates.add(temporaryGamePieceCoordinates);
                    }

                }
            }
        }

        if (currentGamePieceIndex == 0) {
            getAllShipCoordinates().add(aircraftCarrierCoordinates);
        } else if (currentGamePieceIndex == 1) {
            getAllShipCoordinates().add(battleshipCoordinates);
        } else if (currentGamePieceIndex == 2) {
            getAllShipCoordinates().add(submarineCoordinates);
        } else if (currentGamePieceIndex == 3) {
            getAllShipCoordinates().add(cruiserCoordinates);
        } else if (currentGamePieceIndex == 4) {
            getAllShipCoordinates().add(destroyerCoordinates);
        }

    }

    // ***** TAKE SHOT *****
    public void takeShot() {

        String hit = "X";
        String miss = "M";
        String result = "~";

        boolean correctShotCoordinates = false;

        while (!correctShotCoordinates) {

            String[] shotCoordinatesString = scanner.next().split("");

            if (correctShotCoordinates(shotCoordinatesString)) {

                correctShotCoordinates = true;

                int[] shotCoordinatesIndices = translateShotCoordinates(shotCoordinatesString);

                String shotLocation = getGameBoard()[shotCoordinatesIndices[0]][shotCoordinatesIndices[1]];

                if (shotLocation.equals("~") || shotLocation.equals("M")) {
                    result = miss;
                } else if (shotLocation.equals("O") || shotLocation.equals("X")) {
                    result = hit;
                }

                String[][] updatedGameBoard = new String[10][10];

                for(int i = 0; i < getGameBoard().length; i++) {
                    for (int j = 0; j < getGameBoard()[i].length; j++) {
                        if (i == shotCoordinatesIndices[0] && j == shotCoordinatesIndices[1]) {
                            updatedGameBoard[i][j] = result;
                        } else {
                            updatedGameBoard[i][j] = getGameBoard()[i][j];
                        }
                    }
                }

                setGameBoard(updatedGameBoard);

                if (result.equals(miss)) {
                    System.out.println("You missed!");
                    promptEnterKey();
                } else if (result.equals(hit)) {
                    if (shipSank()) {
                        setShipCount(getShipCount() - 1);
                        if (getShipCount() == 0) {
                            setGameWon(true);
                            System.out.println("You sank the last ship. You won. Congratulations!");
                        } else {
                            System.out.println("You sank a ship!");
                            promptEnterKey();
                        }
                    } else {
                        System.out.println("You hit a ship!");
                        promptEnterKey();
                    }
                }

            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }
    }

    public boolean shipSank() {

        for (ArrayList<ArrayList<Integer>> ship : getAllShipCoordinates()) {
            int hitCount = 0;
            for (ArrayList<Integer> coordinate : ship) {
                int x = coordinate.get(0);
                int y = coordinate.get(1);
                if (getGameBoard()[x][y].equalsIgnoreCase("X")) {
                    hitCount++;
                    if (hitCount == ship.size()) {
                        getAllShipCoordinates().remove(ship);
                        return true;
                    }
                }
            }
        }
        return false;
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
