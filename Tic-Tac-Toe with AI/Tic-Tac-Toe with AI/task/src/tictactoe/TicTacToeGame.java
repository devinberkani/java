package tictactoe;

public class TicTacToeGame {

    public TicTacToeGame() {

        final GameBoard gameBoard = new GameBoard();

        gameBoard.initializeGameBoard();

        while(!gameBoard.isGameOver()) {

            gameBoard.printGameBoard();
            gameBoard.chooseGamePiece();
            gameBoard.getUserCoordinates();
            gameBoard.setGameOver(gameBoard.checkForWinner());

        }

    }

}
