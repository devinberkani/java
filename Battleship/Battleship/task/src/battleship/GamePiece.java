package battleship;

public class GamePiece {

    // pieces will extend this class (all pieces have coordinates)
    // validatePlacement() method with arraylist of all coordinates added to and validated as player updates coordinates

    public GamePiece(int[] gamePieceCoordinates) {
    }

    public String[][] setGamePiece(String[][] gameBoard, int[] coordinates) {

        int x1 = coordinates[0];
        int x2 = coordinates[1];

        int y1 = coordinates[2];
        int y2 = coordinates[3];

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (x1 == y1 && i == x1) { // x is equal
                    if (x2 < y2) { // if y2 is greater...
                        if (j >= x2 && j <= y2) { // j must be less than y2
                            gameBoard[i][j] = "0";
                        }
                    } else {
                        if (j <= x2 && j >= y2) {
                            gameBoard[i][j] = "0";
                        }
                    }
                } else if (x2 == y2 && j == x2) { // y is equal
                    if (x1 > y1) { // if x is greater...
                        if (i <= x1 && i >= y1) { // i must be less than x1
                            gameBoard[i][j] = "0";
                        }
                    } else {
                        if (i >= x1 && i <= y1) {
                            gameBoard[i][j] = "0";
                        }
                    }
                }
            }
        }
        return gameBoard;
    }
}
