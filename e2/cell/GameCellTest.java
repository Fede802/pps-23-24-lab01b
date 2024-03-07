package e2.cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameCellTest {

    private final static int CELL_X = 5;
    private final static int CELL_Y = 5;
    private GameEntity gameEntity;

    @BeforeEach
    void initGameCell(){

        this.gameEntity = new GameCell(CELL_X,CELL_Y);
    }

    @Test
    void entityIsInitialUnset(){
        assertEquals(GameEntity.Entity.FREE, this.gameEntity.getEntityType());
    }

    @Test
    void setEntity(){
        this.gameEntity.setType(GameEntity.Entity.MINE);
        assertEquals(GameEntity.Entity.MINE, this.gameEntity.getEntityType());
    }

    @Test
    void setEntityOnCreation(){
        this.gameEntity = new GameCell(GameEntity.Entity.MINE,CELL_X,CELL_Y);
        assertEquals(GameEntity.Entity.MINE, this.gameEntity.getEntityType());
    }

}
