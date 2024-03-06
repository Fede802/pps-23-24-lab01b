package e2.grid.minePlacer;

import e2.Pair;

import java.util.ArrayList;
import java.util.List;

public class DumbMinePlacer extends BaseMinePlacer {
    @Override
    public List<Pair<Integer, Integer>> generateMinePositions(int mineToPlace, int gridSize) throws IllegalArgumentException{
        this.checkArgument(mineToPlace,gridSize);
        List<Pair<Integer, Integer>> minePositions = new ArrayList<>();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if(mineToPlace != minePositions.size()){
                    minePositions.add(new Pair<>(i,j));
                }
            }
        }
        return minePositions;
    }
}
