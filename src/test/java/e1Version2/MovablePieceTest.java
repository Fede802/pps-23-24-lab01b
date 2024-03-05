package e1Version2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovablePieceTest extends PieceTest{

    private Movement movement;
    @BeforeEach
    void init(){
        movement = new KnightMovement();
        piece = new MovablePieceImpl();
    }

    @Test
    void isMovementInitiallyUnset(){
        assertFalse(((MovablePiece) piece).hasMovement());
    }

    @Test
    void setPieceMovement(){
        ((MovablePiece) piece).setMovement(movement);
        assertTrue(((MovablePiece) piece).hasMovement());
    }

    @Test
    void makeMovement(){
        ((MovablePiece) piece).setMovement(movement);
        int pieceX = 0;
        int pieceY = 0;
        piece.setPiece(pieceX,pieceY);
        int destinationX = pieceX + KnightMovement.VALID_MOVE.getX();
        int destinationY = pieceY + KnightMovement.VALID_MOVE.getY();
        Pair<Integer,Integer> move = new Pair<>(destinationX,destinationY);
        assertAll(
                () -> assertTrue(movement.isValidMovement(KnightMovement.VALID_MOVE)),
                () -> assertDoesNotThrow(() -> (MovablePiece) piece).moveTo(move)
        );
    }

    @Test
    void makeWrongMovement(){
        ((MovablePiece) piece).setMovement(movement);
        int pieceX = 0;
        int pieceY = 0;
        piece.setPiece(pieceX,pieceY);
        int destinationX = pieceX + KnightMovement.INVALID_MOVE.getX();
        int destinationY = pieceY + KnightMovement.INVALID_MOVE.getY();
        Pair<Integer,Integer> move = new Pair<>(destinationX,destinationY);
        assertAll(
                () -> assertFalse(movement.isValidMovement(KnightMovement.INVALID_MOVE)),
                () -> assertThrows(IllegalArgumentException.class,() -> ((MovablePiece) piece).moveTo(move))
        );

    }

    @Test
    void makeMovementWithoutPiece(){
        ((MovablePiece) piece).setMovement(movement);
        int pieceX = 0;
        int pieceY = 0;
        int destinationX = pieceX + KnightMovement.VALID_MOVE.getX();
        int destinationY = pieceY + KnightMovement.VALID_MOVE.getY();
        Pair<Integer,Integer> move = new Pair<>(destinationX,destinationY);
        assertThrows(IllegalStateException.class,() -> ((MovablePiece) piece).moveTo(move));

    }

    @Test
    void makeMovementWithoutMovement(){
        int pieceX = 0;
        int pieceY = 0;
        piece.setPiece(pieceX,pieceY);
        int destinationX = pieceX + KnightMovement.VALID_MOVE.getX();
        int destinationY = pieceY + KnightMovement.VALID_MOVE.getY();
        Pair<Integer,Integer> move = new Pair<>(destinationX,destinationY);
        assertThrows(IllegalStateException.class,() -> ((MovablePiece) piece).moveTo(move));
    }


}
