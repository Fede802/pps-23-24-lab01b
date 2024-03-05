package e1.board;

import e1.utils.RandomPositionGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardInitializerTest {

    private final static int BOARD_SIZE = 5;
    private Board board;
    @BeforeEach
    void initBoardInitializer(){
        BoardInitializer boardInitializer = new BoardInitializerImpl();
        this.board = new BoardImpl(BOARD_SIZE);
        boardInitializer.initialize(this.board, new RandomPositionGenerator());
    }

    @Test
    void isKnightPlaced(){
        assertTrue(this.board.getKnightPosition().isPresent());
    }

    @Test
    void isPawnPlaced(){
        assertTrue(this.board.getPawnPosition().isPresent());
    }

}
