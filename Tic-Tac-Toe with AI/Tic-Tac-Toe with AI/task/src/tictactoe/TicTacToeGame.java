package tictactoe;

public class TicTacToeGame {

    public TicTacToeGame() {

        final GameBoard gameBoard = new GameBoard();

        gameBoard.initializeGameBoard();
        gameBoard.printGameBoard();

        while(!gameBoard.isGameOver()) {

            gameBoard.getUserCoordinates();
            gameBoard.setGameOver(gameBoard.checkForWinner());

            if (!gameBoard.isGameOver()) {
                gameBoard.getComputerCoordinates();
                gameBoard.setGameOver(gameBoard.checkForWinner());
            }

        }

    }

}
