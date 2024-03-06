package e2;

import e2.grid.Grid;
import e2.grid.GridImpl;
import e2.grid.initializer.GameInitializerImpl;
import e2.grid.minePlacer.RandomMinePlacer;

public class LogicsImpl implements Logics {

    private final Grid grid;
    public LogicsImpl(int size, int minesToPlace) {
        this.grid = new GridImpl(size,new GameInitializerImpl(new RandomMinePlacer()),minesToPlace);
    }

    @Override
    public boolean hasMine(int gridX, int gridY) {
        return this.grid.hasMine(gridX,gridY);
    }
}
