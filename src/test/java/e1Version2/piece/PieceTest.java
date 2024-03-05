package e1Version2.piece;


import e1Version2.utils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    protected Piece piece;
    @BeforeEach
    void init(){
        piece = new PieceImpl();
    }
    @Test
    void isInitiallyEmpty(){
        assertTrue(piece.getPiece().isEmpty());
    }

    @Test
    void setPiece(){
        int pieceX = 0;
        int pieceY = 0;
        piece.setPiece(pieceX,pieceY);
        assertAll(
                () -> assertTrue(piece.getPiece().isPresent()),
                () -> Assertions.assertEquals(new Pair<>(pieceX,pieceY),piece.getPiece().orElseThrow())
        );
    }


}
