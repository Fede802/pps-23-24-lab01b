package e1Version2;

public interface MovablePiece extends Piece{
    void setMovement(Movement movement);
    boolean hasMovement();
    void moveTo(Pair<Integer,Integer> destination) throws IllegalArgumentException, IllegalStateException;
}
