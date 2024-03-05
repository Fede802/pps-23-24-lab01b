package e1Version2.piece.movement;

import e1Version2.piece.Piece;
import e1Version2.utils.Pair;

public abstract class BasePieceMovement implements Movement{
    @Override
    public void makeMovement(Piece piece, Pair<Integer, Integer> move) {
        if(!isValidMovement(move)){
            throw new IllegalArgumentException();
        }
        piece.setPiece(piece.getPiece().get().getX()+move.getX(),piece.getPiece().get().getY()+move.getY());
    }
}
