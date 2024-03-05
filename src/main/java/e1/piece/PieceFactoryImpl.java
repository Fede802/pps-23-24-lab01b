package e1.piece;


import e1.piece.movement.KnightMovement;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public MovablePiece createKnight() {
        return new MovablePieceImpl(new KnightMovement());
    }

    @Override
    public MovablePiece createPawn() {
        return new MovablePieceImpl();
    }
}
