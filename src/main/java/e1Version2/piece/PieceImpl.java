package e1Version2.piece;

import e1Version2.utils.Pair;

import java.util.Optional;

public class PieceImpl implements Piece {

    private Pair<Integer,Integer> piece;
    @Override
    public Optional<Pair<Integer, Integer>> getPiece() {
        return piece!= null?Optional.of(piece):Optional.empty();
    }

    @Override
    public void setPiece(int pieceX, int pieceY) {
        this.piece = new Pair<>(pieceX,pieceY);
    }



}
