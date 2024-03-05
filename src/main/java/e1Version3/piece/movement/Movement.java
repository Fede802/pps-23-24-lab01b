package e1Version3.piece.movement;

import e1Version3.piece.Piece;
import e1Version3.utils.Pair;

public interface Movement {
    boolean isValidMovement(Pair<Integer, Integer> move);
    void makeMovement(Piece piece, Pair<Integer, Integer> move) throws IllegalArgumentException;
}
