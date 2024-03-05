package e1Version2;


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
                () -> assertEquals(new Pair<>(pieceX,pieceY),piece.getPiece().orElseThrow())
        );
    }


}
