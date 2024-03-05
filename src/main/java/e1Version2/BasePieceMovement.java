package e1Version2;

public abstract class BasePieceMovement implements Movement{



    @Override
    public void makeMovement(Piece piece, Pair<Integer, Integer> move) throws IllegalArgumentException {
        if (!isValidMovement(move) || piece.getPiece().isEmpty()){
            throw new IllegalArgumentException();
        }
        int newPieceX = piece.getPiece().get().getX() + move.getX();
        int newPieceY = piece.getPiece().get().getY() + move.getY();
        piece.setPiece(newPieceX, newPieceY);
    }
}
