package e1.piece;

import e1.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    protected Piece piece;
    @BeforeEach
    void initPiece(){
        this.piece = new PieceImpl();
    }
    @Test
    void isPieceInitiallyUnset(){
        assertTrue(this.piece.getPieceCoordinate().isEmpty());
    }

    @Test
    void setPieceCoordinate(){
        Pair<Integer,Integer> coordinate = new Pair<>(10,10);
        piece.setPieceCoordinate(coordinate);
        assertAll(
                () -> assertTrue(this.piece.getPieceCoordinate().isPresent()),
                () -> assertEquals(coordinate,this.piece.getPieceCoordinate().orElseThrow())
        );
    }
}
