package e1Version2.piece;

import e1Version2.piece.movement.Movement;
import e1Version2.utils.Pair;

public interface MovablePiece extends Piece {
    void setMovement(Movement movement);
    boolean hasMovement();
    void moveTo(Pair<Integer,Integer> destination) throws IllegalArgumentException, IllegalStateException;
}
