package e2.grid.minePlacer;

public abstract class BaseMinePlacer implements MinePlacer {
    protected void checkArgument(int mineToPlace, int gridSize) throws IllegalArgumentException {
        if (mineToPlace < 0 || mineToPlace > gridSize * gridSize) {
            throw new IllegalArgumentException();
        }
    }
}
