package e2.grid.initializer;

import e2.Pair;
import e2.cell.GameCell;
import e2.cell.GameEntity;
import e2.grid.minePlacer.DumbMinePlacer;
import e2.grid.minePlacer.MinePlacer;

import java.util.List;

public class GameInitializerImpl implements GameInitializer{
    private final GridInitializer gridInitializer = new EmptyGridInitializer();
    private MinePlacer minePlacer;

    public GameInitializerImpl(MinePlacer minePlacer) {
        this.minePlacer = minePlacer;
    }

    public GameInitializerImpl() {
        this(new DumbMinePlacer());
    }

    @Override
    public void initializeGrid(List<List<GameCell>> grid, int gridSize) {
        gridInitializer.initializeGrid(grid, gridSize);
    }

    @Override
    public void initializeGridWithMines(List<List<GameCell>> grid, int minesToPlace, int gridSize) throws IllegalArgumentException{
        this.initializeGrid(grid,gridSize);
        List<Pair<Integer,Integer>> minesPositions = this.minePlacer.generateMinePositions(minesToPlace,gridSize);
        minesPositions.forEach((minePosition) -> grid.get(minePosition.getX()).get(minePosition.getY()).setType(GameEntity.Entity.MINE));
    }

    @Override
    public void setMinePlacer(MinePlacer minePlacer) {
        this.minePlacer = minePlacer;
    }

    @Override
    public MinePlacer getMinePlacer() {
        return this.minePlacer;
    }
}
