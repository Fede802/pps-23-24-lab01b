package e2;



import e2.cell.EntityType;
import e2.cell.GameCell;
import e2.grid.Grid;
import e2.grid.GridFactoryImpl;
import e2.utils.Pair;

import java.util.Set;

public class LogicsImpl implements Logics {

    private final Grid grid;
    private boolean gameLost;
    public LogicsImpl(int gridSize, int minesToPlace) {
        this.grid = new GridFactoryImpl().createGridWithRandomMines(gridSize,minesToPlace);
    }

    public LogicsImpl(int gridSize, Set<Pair<Integer, Integer>> presetMinePosition) {
        this.grid = new GridFactoryImpl().createGridWithPresetMinePositions(gridSize,presetMinePosition);
    }

    @Override
    public ClickResult clickCell(Pair<Integer, Integer> cellPosition) {
        if(!gameLost) {
            GameCell gameCell = this.grid.getCell(cellPosition.getX(), cellPosition.getY());
            if (!gameCell.isSelected() && !gameCell.isFlagged()) {
                gameCell.select();
                if (gameCell.getEntityType() == EntityType.MINE) {
                    this.gameLost = true;
                    return ClickResult.LOSE;
                } else if (this.numberOfMinesAround(cellPosition) == 0) {
                    for (GameCell cell :
                            this.grid.getNeighbours(cellPosition.getX(), cellPosition.getY())) {
                        this.clickCell(cell.getCellPosition());
                    }
                }
                if (this.allEmptyCellClicked()) {
                    return ClickResult.WIN;
                }
            }
        }
        return ClickResult.EMPTY;
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> cellPosition) {
        GameCell gameCell = this.grid.getCell(cellPosition.getX(), cellPosition.getY());
        if(!this.gameLost && !gameCell.isSelected()){
            gameCell.toggleFlag();
        }
    }

    @Override
    public boolean isMineCell(Pair<Integer, Integer> cellPosition) {
        return this.grid.getCell(cellPosition.getX(), cellPosition.getY()).getEntityType() == EntityType.MINE;
    }

    @Override
    public boolean isCellClicked(Pair<Integer, Integer> cellPosition) {
        return this.grid.getCell(cellPosition.getX(), cellPosition.getY()).isSelected();
    }

    @Override
    public int numberOfMinesAround(Pair<Integer, Integer> cellPosition) {
        return (int) this.grid.getNeighbours(cellPosition.getX(), cellPosition.getY()).stream().filter((cell) -> cell.getEntityType() == EntityType.MINE).count();
    }

    @Override
    public boolean isCellFlagged(Pair<Integer, Integer> cellPosition) {
        return this.grid.getCell(cellPosition.getX(), cellPosition.getY()).isFlagged();
    }

    private boolean allEmptyCellClicked() {
        for (int i = 0; i < this.grid.getSize(); i++) {
            for (int j = 0; j < this.grid.getSize(); j++) {
                GameCell gameCell = this.grid.getCell(i,j);
                if(gameCell.getEntityType() == EntityType.EMPTY && !gameCell.isSelected()){
                    return false;
                }
            }
        }
        return true;
    }

}
