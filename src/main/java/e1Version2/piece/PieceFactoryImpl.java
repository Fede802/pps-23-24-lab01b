package e1Version2.piece;

import e1Version2.piece.movement.KnightMovement;

public class PieceFactoryImpl implements PieceFactory{
    @Override
    public MovablePiece createKnight() {
        return new MovablePieceImpl(new KnightMovement());
    }

    @Override
    public MovablePiece createPawn() {
        return new MovablePieceImpl();
    }
}
