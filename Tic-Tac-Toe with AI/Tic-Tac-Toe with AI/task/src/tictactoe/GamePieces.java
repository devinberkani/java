package tictactoe;

public enum GamePieces {
    X,
    O;

    String getGamePiece() {
        switch (this) {
            case X:
                return "X";

            case O:
                return "O";

            default:
                throw new AssertionError("Unknown game piece entered " + this);
        }
    }
}
