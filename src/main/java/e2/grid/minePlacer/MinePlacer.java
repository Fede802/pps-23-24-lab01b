package e2.grid.minePlacer;

import e2.Pair;

import java.util.List;

public interface MinePlacer {
    List<Pair<Integer, Integer>> generateMinePositions(int mineToPlace, int gridSize) throws IllegalArgumentException;

}
