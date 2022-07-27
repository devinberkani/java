package battleship;

public class Player {

    public Player () {
        GameBoard gameBoard = new GameBoard();
        gameBoard.printGameBoard();
        gameBoard.getCoordinates();
        gameBoard.takeShot();
    }

}
