package battleship;

public class GamePiece {

    private final String[] gamePieceChoices = {"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
    private final int[] gamePieceLengths = {5, 4, 3, 3, 2};
    private String[][] gameBoard;
    private int[] gamePieceCoordinates;

    public GamePiece(String[][] gameBoard, int[] gamePieceCoordinates, int gamePieceIndex) throws Exception {
        int x1 = gamePieceCoordinates[0];
        int x2 = gamePieceCoordinates[1];
        int y1 = gamePieceCoordinates[2];
        int y2 = gamePieceCoordinates[3];

        // catch wrong game piece location
        if (x1 != y1 && x2 != y2) {
            throw new Exception("Error! Wrong ship location! Try again:");
        // catch wrong length of game piece
        } else if ((Math.abs(x1 - y1) + 1) != gamePieceLengths[gamePieceIndex] && (Math.abs(x2 - y2) + 1) != gamePieceLengths[gamePieceIndex]) {
            throw new Exception("Error! Wrong length of the " + gamePieceChoices[gamePieceIndex] + "! Try again:"); // need to fix this
        // catch game piece being too close to another
        } else if (isTooClose(gameBoard, gamePieceCoordinates, gamePieceIndex)) {
            throw new Exception("Error! You placed it too close to another one. Try again:");
        } else {
            this.gameBoard = gameBoard;
            this.gamePieceCoordinates = gamePieceCoordinates;
        }
    }

    private boolean isTooClose(String[][] gameBoard, int[] gamePieceCoordinates, int gamePieceIndex) {
        // catch game piece being too close to another - length is good and is entered correctly

        int x1 = gamePieceCoordinates[0];
        int x2 = gamePieceCoordinates[1];
        int y1 = gamePieceCoordinates[2];
        int y2 = gamePieceCoordinates[3];

        int[][] coordinateList = new int[gamePieceLengths[gamePieceIndex]][2];

        int indexCount = 0;
        int secondIndexCount = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (x1 == y1 && i == x1) { // x is equal
                    if (x2 < y2) { // if y2 is greater...
                        if (j >= x2 && j <= y2) { // j must be less than y2
                            coordinateList[indexCount][secondIndexCount] = i;
                            secondIndexCount++;
                            coordinateList[indexCount][secondIndexCount] = j;
                            indexCount++;
                            secondIndexCount--;
                        }
                    } else {
                        if (j <= x2 && j >= y2) {
                            coordinateList[indexCount][secondIndexCount] = i;
                            secondIndexCount++;
                            coordinateList[indexCount][secondIndexCount] = j;
                            indexCount++;
                            secondIndexCount--;
                        }
                    }
                } else if (x2 == y2 && j == x2) { // y is equal
                    if (x1 > y1) { // if x is greater...
                        if (i <= x1 && i >= y1) { // i must be less than x1
                            coordinateList[indexCount][secondIndexCount] = i;
                            secondIndexCount++;
                            coordinateList[indexCount][secondIndexCount] = j;
                            indexCount++;
                            secondIndexCount--;
                        }
                    } else {
                        if (i >= x1 && i <= y1) {
                            coordinateList[indexCount][secondIndexCount] = i;
                            secondIndexCount++;
                            coordinateList[indexCount][secondIndexCount] = j;
                            indexCount++;
                            secondIndexCount--;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < coordinateList.length; i++) {
            int currentX = coordinateList[i][0];
            int currentY = coordinateList[i][1];
            // already contains a game piece
            if (gameBoard[currentX][currentY].equals("O")) {
                return true;
                // check above
            }
            if ((currentX - 1) >= 0) {
                if (gameBoard[currentX - 1][currentY].equals("O")) {
                    return true;
                }
                // check below
            }
            if ((currentX + 1) < gameBoard.length) {
                if (gameBoard[currentX + 1][currentY].equals("O")) {
                    return true;
                }
                // check left
            }
            if ((currentY - 1) >= 0) {
                if (gameBoard[currentX][currentY - 1].equals("O")) {
                    return true;
                }
            }
            if ((currentY + 1) < gameBoard[0].length) {
                if (gameBoard[currentX][currentY + 1].equals("O")) {
                    return true;
                }
            }
        }
        return false;
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int[] getGamePieceCoordinates() {
        return gamePieceCoordinates;
    }

    public void setGamePieceCoordinates(int[] gamePieceCoordinates) {
        this.gamePieceCoordinates = gamePieceCoordinates;
    }

    public String[][] setGamePiece() {

        int x1 = getGamePieceCoordinates()[0];
        int x2 = getGamePieceCoordinates()[1];
        int y1 = getGamePieceCoordinates()[2];
        int y2 = getGamePieceCoordinates()[3];

        for (int i = 0; i < this.getGameBoard().length; i++) {
            for (int j = 0; j < getGameBoard()[i].length; j++) {
                if (x1 == y1 && i == x1) { // x is equal
                    if (x2 < y2) { // if y2 is greater...
                        if (j >= x2 && j <= y2) { // j must be less than y2
                            getGameBoard()[i][j] = "O";
                        }
                    } else {
                        if (j <= x2 && j >= y2) {
                            getGameBoard()[i][j] = "O";
                        }
                    }
                } else if (x2 == y2 && j == x2) { // y is equal
                    if (x1 > y1) { // if x is greater...
                        if (i <= x1 && i >= y1) { // i must be less than x1
                            getGameBoard()[i][j] = "O";
                        }
                    } else {
                        if (i >= x1 && i <= y1) {
                            getGameBoard()[i][j] = "O";
                        }
                    }
                }
            }
        }
        return getGameBoard();
    }
}
