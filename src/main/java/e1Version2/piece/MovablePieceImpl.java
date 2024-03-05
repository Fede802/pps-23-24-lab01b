package e1Version2.piece;

import e1Version2.utils.Pair;
import e1Version2.piece.movement.Movement;

import java.util.Optional;

public class MovablePieceImpl implements MovablePiece {

    public MovablePieceImpl(Movement movement) {
        this.movement = movement;
    }

    public MovablePieceImpl() {}

    @Override
    public Optional<Pair<Integer, Integer>> getPiece() {
        return this.piece.getPiece();
    }

    @Override
    public void setPiece(int pieceX, int pieceY) {
        this.piece.setPiece(pieceX, pieceY);
    }

    private final Piece piece = new PieceImpl();
    private Movement movement;
    @Override
    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    @Override
    public boolean hasMovement() {
        return this.movement != null;
    }

    @Override
    public void moveTo(Pair<Integer, Integer> destination) throws IllegalArgumentException, IllegalStateException {

        if(this.getPiece().isEmpty() || !this.hasMovement())
            throw new IllegalStateException();
        int movementX = destination.getX() - this.getPiece().get().getX();
        int movementY = destination.getY() - this.getPiece().get().getY();
        this.movement.makeMovement(this, new Pair<>(movementX, movementY));
    }

//    @Override
//    public boolean canMoveTo(Pair<Integer, Integer> destination) {
//        if(this.getPiece().isEmpty() || !this.hasMovement())
//            throw new IllegalStateException();
//        System.out.println("MovablePieceImpl destX"+destination.getX());
//        System.out.println("MovablePieceImpl destY"+destination.getY());
//        System.out.println("MovablePieceImpl currKniX"+this.getPiece().get().getX());
//        System.out.println("MovablePieceImpl currKniY"+this.getPiece().get().getY());
//
//        System.out.println("MovablePieceImpl"+movementX);
//        System.out.println("MovablePieceImpl"+movementY);
//        return movement.isValidMovement(new Pair<>(movementX,movementY));
//
//
//    }


}
