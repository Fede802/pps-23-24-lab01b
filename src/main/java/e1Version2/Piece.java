package e1Version2;

import java.util.Optional;

public interface Piece {
    Optional<Pair<Integer,Integer>> getPiece();
    void setPiece(int pieceX, int pieceY);

}
