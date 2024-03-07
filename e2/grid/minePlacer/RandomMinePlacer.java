package e2.grid.minePlacer;

import e2.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMinePlacer extends BaseMinePlacer {

    private final Random random = new Random();
    @Override
    public List<Pair<Integer, Integer>> generateMinePositions(int mineToPlace, int gridSize) throws IllegalArgumentException {
        this.checkArgument(mineToPlace,gridSize);
        List<Pair<Integer, Integer>> minePositions = new ArrayList<>();
        while(minePositions.size() != mineToPlace){
            Pair<Integer, Integer> newMinePosition = this.generatePosition(gridSize);
            if(!minePositions.contains(newMinePosition)) {
                minePositions.add(newMinePosition);
            }
        }
        return minePositions;
    }


    private Pair<Integer, Integer> generatePosition(int gridSize) {
        return new Pair<>(this.random.nextInt(gridSize), this.random.nextInt(gridSize));
    }
}
