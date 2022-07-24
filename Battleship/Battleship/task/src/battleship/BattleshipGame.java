package battleship;

public class BattleshipGame {

    public BattleshipGame() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.printGameBoard();
        gameBoard.getCoordinates();
    }

}
