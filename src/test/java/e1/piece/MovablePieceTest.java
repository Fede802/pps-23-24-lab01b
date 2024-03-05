package e1.piece;

import e1.utils.Pair;
import e1.piece.movement.KnightMovement;
import e1.piece.movement.Movement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MovablePieceTest extends PieceTest{

    private Movement movement;
    @BeforeEach
    void initPiece(){
        this.piece = new MovablePieceImpl();
        this.movement = new KnightMovement();
    }

    @Test
    void movementIsInitiallyUnset(){
        assertFalse(((MovablePiece) this.piece).hasMovement());
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
        piece.setPieceCoordinate(new Pair<>(pieceX,pieceY));
        Pair<Integer,Integer> validMove = KnightMovement.VALID_MOVES.get(0);
        int destinationX = pieceX + validMove.getX();
        int destinationY = pieceY + validMove.getY();
        Pair<Integer,Integer> destination = new Pair<>(destinationX,destinationY);
        assertAll(
                () -> assertTrue(movement.isValidMovement(validMove)),
                () -> assertDoesNotThrow(() -> (MovablePiece) piece).moveTo(destination)
        );
    }

    @Test
    void makeWrongMovement(){
        ((MovablePiece) piece).setMovement(movement);
        int pieceX = 0;
        int pieceY = 0;
        piece.setPieceCoordinate(new Pair<>(pieceX,pieceY));
        Pair<Integer,Integer> invalidMove = KnightMovement.INVALID_MOVE;
        int destinationX = pieceX + invalidMove.getX();
        int destinationY = pieceY + invalidMove.getY();
        Pair<Integer,Integer> destination = new Pair<>(destinationX,destinationY);
        assertAll(
                () -> assertFalse(movement.isValidMovement(invalidMove)),
                () -> assertThrows(IllegalArgumentException.class,() -> ((MovablePiece) piece).moveTo(destination))
        );
    }

    @Test
    void makeMovementWithoutPiece(){
        ((MovablePiece) piece).setMovement(movement);
        assertThrows(IllegalStateException.class,() -> ((MovablePiece) piece).moveTo(KnightMovement.VALID_MOVES.get(0)));

    }

    @Test
    void makeMovementWithoutMovement(){
        int pieceX = 0;
        int pieceY = 0;
        piece.setPieceCoordinate(new Pair<>(pieceX,pieceY));
        Pair<Integer,Integer> validMove = KnightMovement.VALID_MOVES.get(0);
        int destinationX = pieceX + validMove.getX();
        int destinationY = pieceY + validMove.getY();
        Pair<Integer,Integer> destination = new Pair<>(destinationX,destinationY);
        assertThrows(IllegalStateException.class,() -> ((MovablePiece) piece).moveTo(destination));
    }

    @Test
    void buildPieceWithMovement(){
        this.piece = new MovablePieceImpl(this.movement);
        assertTrue(((MovablePiece) piece).hasMovement());
    }

}
