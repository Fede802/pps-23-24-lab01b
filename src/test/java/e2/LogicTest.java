package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicTest {

    private final static int GRID_SIZE = 7;
    private final static int MINES_TO_PLACE = 7;

    private Logics logics;

    @BeforeEach
    void initLogics(){
        this.logics = new LogicsImpl(GRID_SIZE, MINES_TO_PLACE);
    }

    @Test
    void minesPlaceCorrectly(){
        int minePlaced = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if(this.logics.hasMine(i,j)){
                    minePlaced = minePlaced + 1;
                }
            }
        }
        assertEquals(MINES_TO_PLACE,minePlaced);
    }

    //todo hasMine withWrongIdices
}
