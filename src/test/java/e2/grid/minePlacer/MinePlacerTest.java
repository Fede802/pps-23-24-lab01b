package e2.grid.minePlacer;

import e2.Pair;
import e2.grid.minePlacer.MinePlacer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class MinePlacerTest {

    protected MinePlacer minePlacer;
    @BeforeEach
    void initMinePlacer(){
        this.minePlacer = this.createMinePlacer();
    }

    @Test
    void placeMinesCorrectly(){
        int mineToPlace = 10;
        int gridSize = 10;
        List<Pair<Integer,Integer>> minesPositions = this.minePlacer.generateMinePositions(mineToPlace,gridSize);

        assertAll(
                () -> assertEquals(mineToPlace,minesPositions.stream().distinct().count()),
                () -> assertEquals(mineToPlace,minesPositions.stream().filter((minePosition)->positionInRange(minePosition,gridSize)).count())
        );
    }

    private boolean positionInRange(Pair<Integer, Integer> minePosition, int gridSize) {
        int mineX = minePosition.getX();
        int mineY = minePosition.getY();
        return mineX >= 0 && mineY >= 0 && mineX < gridSize && mineY < gridSize;
    }

    @Test
    void placeTooManyMines(){
        int mineToPlace = 10;
        int gridSize = 2;
        assertThrows(IllegalArgumentException.class, () -> this.minePlacer.generateMinePositions(mineToPlace,gridSize));
    }

    @Test
    void placeNegativeMines(){
        int mineToPlace = -1;
        int gridSize = 2;
        assertThrows(IllegalArgumentException.class, () -> this.minePlacer.generateMinePositions(mineToPlace,gridSize));
    }


    protected abstract MinePlacer createMinePlacer();
}
