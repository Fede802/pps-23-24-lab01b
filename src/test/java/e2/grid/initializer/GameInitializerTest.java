package e2.grid.initializer;

import e2.cell.GameEntity;
import e2.grid.minePlacer.DumbMinePlacer;
import e2.grid.minePlacer.MinePlacer;
import e2.grid.minePlacer.RandomMinePlacer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameInitializerTest extends GridInitializerTest{



    @Override
    protected GridInitializer createGridInitializer() {
        return new GameInitializerImpl();
    }

    @Test
    void placeMines(){
        int minesToPlace = 10;
        ((GameInitializer)this.gridInitializer).initializeGridWithMines(this.grid, minesToPlace,GRID_SIZE);
        int minesPlaced = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if(this.grid.get(i).get(j).getEntityType() == GameEntity.Entity.MINE){
                    minesPlaced = minesPlaced + 1;
                }
            }
        }
        assertEquals(minesToPlace,minesPlaced);
    }

    @Test
    void placeTooManyMines(){
        int minesToPlace = GRID_SIZE * GRID_SIZE + 1;
        assertThrows(IllegalArgumentException.class, () -> ((GameInitializer)this.gridInitializer).initializeGridWithMines(this.grid, minesToPlace,GRID_SIZE));
    }

    @Test
    void placeNegativeMines(){
        int minesToPlace = -1;
        assertThrows(IllegalArgumentException.class, () -> ((GameInitializer)this.gridInitializer).initializeGridWithMines(this.grid, minesToPlace,GRID_SIZE));
    }

    @Test
    void setMinePlacer(){
        MinePlacer minePlacer = new RandomMinePlacer();
        ((GameInitializer)this.gridInitializer).setMinePlacer(minePlacer);
        assertEquals(minePlacer, ((GameInitializer)this.gridInitializer).getMinePlacer());
    }
    @Test
    void changeMinePlacer(){
        MinePlacer minePlacer = new DumbMinePlacer();
        ((GameInitializer)this.gridInitializer).setMinePlacer(minePlacer);
        minePlacer = new RandomMinePlacer();
        ((GameInitializer)this.gridInitializer).setMinePlacer(minePlacer);
        assertEquals(minePlacer, ((GameInitializer)this.gridInitializer).getMinePlacer());
    }

    @Test
    void buildInitializerWithMinePlacer(){
        MinePlacer minePlacer = new RandomMinePlacer();
        this.gridInitializer = new GameInitializerImpl(minePlacer);
        assertEquals(minePlacer, ((GameInitializer)this.gridInitializer).getMinePlacer());
    }
}
