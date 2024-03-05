package e1Version3.piece;

import e1Version3.piece.movement.Movement;
import e1Version3.utils.Pair;

import java.util.Optional;

public class MovablePieceImpl implements MovablePiece {

    private final Piece piece = new PieceImpl();
    private Movement movement;

    public MovablePieceImpl(Movement movement) {
        this.movement = movement;
    }

    public MovablePieceImpl() {

    }

    @Override
    public Optional<Pair<Integer, Integer>> getPieceCoordinate() {
        return piece.getPieceCoordinate();
    }

    @Override
    public void setPieceCoordinate(Pair<Integer, Integer> coordinate) {
        piece.setPieceCoordinate(coordinate);
    }
    @Override
    public boolean hasMovement() {
        return movement != null;
    }

    @Override
    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    @Override
    public void moveTo(Pair<Integer, Integer> destination) throws IllegalArgumentException, IllegalStateException{
        if(this.getPieceCoordinate().isEmpty() || !this.hasMovement())
            throw new IllegalStateException();
        int movementX = destination.getX() - this.getPieceCoordinate().get().getX();
        int movementY = destination.getY() - this.getPieceCoordinate().get().getY();
        movement.makeMovement(this, new Pair<>(movementX, movementY));
    }
}
