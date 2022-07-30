package battleship;

public class Player {

    private final String name;
    private final GameBoard gameBoard = new GameBoard();
    private GameBoard enemyGameBoard = new GameBoard();

    public Player (String name) {
        this.name = name;
        greetPlayer();
    }

    public String getName() {
        return name;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public GameBoard getEnemyGameBoard() {
        return enemyGameBoard;
    }

    public void setEnemyGameBoard(GameBoard enemyGameBoard) {
        this.enemyGameBoard = enemyGameBoard;
    }

    public void greetPlayer() {
        System.out.println(getName() + ", place your ships to the game field");
    }

}
