package e1Version2.piece.movement;

import e1Version2.utils.Pair;
import e1Version2.piece.Piece;

public interface Movement {
    boolean isValidMovement(Pair<Integer, Integer> move);
    void makeMovement(Piece piece, Pair<Integer, Integer> move);
}
