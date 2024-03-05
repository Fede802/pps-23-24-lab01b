package e1.piece;

import e1.piece.movement.Movement;
import e1.utils.Pair;

public interface MovablePiece extends Piece{

    boolean hasMovement();
    void setMovement(Movement movement);
    void moveTo(Pair<Integer, Integer> destination) throws IllegalArgumentException, IllegalStateException;
}
