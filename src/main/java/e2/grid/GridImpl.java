package e2.grid;

import e2.cell.GameCell;
import e2.cell.GameEntity;
import e2.grid.initializer.GameInitializer;
import e2.grid.initializer.GameInitializerImpl;

import java.util.ArrayList;
import java.util.List;

public class GridImpl implements Grid {

    private final int boardSize;

    private GameInitializer gameInitializer;
    private final List<List<GameCell>> grid = new ArrayList<>();
    public GridImpl(int boardSize) {
        this(boardSize, new GameInitializerImpl(),0);
    }

    public GridImpl(int boardSize, GameInitializer gameInitializer, int minesToPlace) {
        this.boardSize = boardSize;
        this.gameInitializer = gameInitializer;
        gameInitializer.initializeGridWithMines(this.grid,minesToPlace,this.boardSize);
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

    @Override
    public void setGameInitializer(GameInitializer gameInitializer) {
        this.gameInitializer = gameInitializer;
    }

    @Override
    public GameInitializer getGameInitializer() {
        return this.gameInitializer;
    }

    @Override
    public boolean hasMine(int gridX, int gridY) {
        return this.grid.get(gridX).get(gridY).getEntityType() == GameEntity.Entity.MINE;
    }
}
