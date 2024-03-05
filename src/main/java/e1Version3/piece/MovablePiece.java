package e1Version3.piece;

import e1Version3.piece.movement.Movement;
import e1Version3.utils.Pair;

public interface MovablePiece extends Piece{

    boolean hasMovement();
    void setMovement(Movement movement);
    void moveTo(Pair<Integer, Integer> destination) throws IllegalArgumentException, IllegalStateException;
}
