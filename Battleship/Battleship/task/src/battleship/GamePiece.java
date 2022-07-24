package battleship;

import java.util.ArrayList;
import java.util.List;

public class GamePiece {

    // pieces will extend this class (all pieces have coordinates)
    // validatePlacement() method with arraylist of all coordinates added to and validated as player updates coordinates

    private final List<Integer> translatedCoordinates = new ArrayList<>();
    private final int[] gamePieceCoordinates;


    public GamePiece(int[] gamePieceCoordinates) {
        this.gamePieceCoordinates = gamePieceCoordinates;
    }
}
