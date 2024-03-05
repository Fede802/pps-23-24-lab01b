package e1Version3.piece.movement;


import e1Version3.utils.Pair;
import e1Version3.piece.Piece;

public abstract class BasePieceMovement implements Movement {
    @Override
    public void makeMovement(Piece piece, Pair<Integer, Integer> move) throws IllegalArgumentException{
        if(!isValidMovement(move) || piece.getPieceCoordinate().isEmpty()){
            throw new IllegalArgumentException();
        }
        int newPieceX = piece.getPieceCoordinate().get().getX()+move.getX();
        int newPieceY = piece.getPieceCoordinate().get().getY()+move.getY();
        piece.setPieceCoordinate(new Pair<>(newPieceX,newPieceY));
    }
}
