package e1.piece.movement;

import e1.piece.Piece;
import e1.utils.Pair;

public interface Movement {
    boolean isValidMovement(Pair<Integer, Integer> move);
    void makeMovement(Piece piece, Pair<Integer, Integer> move) throws IllegalArgumentException;
}
