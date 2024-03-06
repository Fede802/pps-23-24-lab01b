package e2;

import e2.cell.ClickableCell;

import java.util.ArrayList;
import java.util.List;

public class GridImpl implements Grid {

    private final int boardSize;
    private List<List<ClickableCell>> grid = new ArrayList<>();
    public GridImpl(int boardSize) {
        this.boardSize = boardSize;
        new EmptyGridinitializer().initializeGrid(this.grid,this.boardSize);
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
