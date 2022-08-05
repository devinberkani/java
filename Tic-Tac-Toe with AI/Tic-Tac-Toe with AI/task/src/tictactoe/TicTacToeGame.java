package tictactoe;

public class TicTacToeGame {

    public TicTacToeGame() {

        final Menu menu = new Menu();
        String userCommand = menu.getUserCommand();

        while (!userCommand.equalsIgnoreCase("exit")) {

            Player player1 = menu.getPlayer1();
            Player player2 = menu.getPlayer2();
            final GameBoard gameBoard = new GameBoard(player1, player2);

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

}
