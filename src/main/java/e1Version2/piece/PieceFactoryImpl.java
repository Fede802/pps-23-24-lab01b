package e1Version2.piece;

import e1Version2.piece.movement.KnightMovement;

public class PieceFactoryImpl implements PieceFactory{
    @Override
    public Piece createKnight() {
        return new MovablePieceImpl(new KnightMovement());
    }

    @Override
    public Piece createPawn() {
        return new MovablePieceImpl();
    }
}
