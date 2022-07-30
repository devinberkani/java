package battleship;

public class BattleshipGame {
    public BattleshipGame() {

        Player playerOne = new Player("Player 1");

        playerOne.getGameBoard().printGameBoard();
        playerOne.getGameBoard().getCoordinates();

        Player playerTwo = new Player("Player 2");

        playerTwo.getGameBoard().printGameBoard();
        playerTwo.getGameBoard().getCoordinates();

        boolean playerOneWins = playerOne.getGameBoard().isGameWon();
        boolean playerTwoWins = playerTwo.getGameBoard().isGameWon();

        while (!playerOneWins && !playerTwoWins) {

            playerOne.setEnemyGameBoard(playerTwo.getGameBoard());
            playerTwo.setEnemyGameBoard(playerOne.getGameBoard());

            printPlayerBoards(playerOne);

            System.out.println(playerOne.getName() + ", it's your turn:");
            playerOne.getEnemyGameBoard().takeShot();

            playerOneWins = playerOne.getEnemyGameBoard().isGameWon();

            if (!playerOneWins) {
                printPlayerBoards(playerTwo);
                System.out.println(playerTwo.getName() + ", it's your turn:");
                playerTwo.getEnemyGameBoard().takeShot();
                playerTwoWins = playerTwo.getEnemyGameBoard().isGameWon();
            }

        }

        if (playerOneWins) {
            System.out.println(playerOne.getName() + " wins!");
        } else {
            System.out.println(playerTwo.getName() + " wins!");
        }

    }

    public void printPlayerBoards(Player player) {
        player.getEnemyGameBoard().printFogGameBoard();
        System.out.println("---------------------");
        player.getGameBoard().printGameBoard();
    }

}
