package e2.grid;

import e2.cell.GameCell;

import java.util.ArrayList;
import java.util.List;

public class GridImpl implements Grid {

    private final int boardSize;
    private List<List<GameCell>> grid = new ArrayList<>();
    public GridImpl(int boardSize) {
        this.boardSize = boardSize;
        new EmptyGridInitializer().initializeGrid(this.grid,this.boardSize);
    }

    @Override
    public int getSize() {
        return this.boardSize;
    }

    @Override
    public boolean isCellPressed(int cellX, int cellY) {
        return this.grid.get(cellX).get(cellY).isSelected();
    }

    @Override
    public void pressCell(int cellX, int cellY) {
        this.grid.get(cellX).get(cellY).click();
    }
}
