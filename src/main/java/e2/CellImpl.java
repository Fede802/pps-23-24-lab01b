package e2;

public class CellImpl implements Cell {
    Pair<Integer, Integer> cellPosition;
    public CellImpl(int cellStartX, int cellStartY) {
        this.cellPosition = new Pair<>(cellStartX,cellStartY);
    }

    @Override
    public Pair<Integer, Integer> getCellPosition() {
        return this.cellPosition;
    }

    @Override
    public void moveCellTo(int newCellX, int newCellY) {
        cellPosition = new Pair<>(newCellX,newCellY);
    }

    @Override
    public boolean isAdjacentTo(Pair<Integer, Integer> adjacentCellPosition) {
        return Math.abs(adjacentCellPosition.getX()-this.cellPosition.getX()) <= 1
                && Math.abs(adjacentCellPosition.getY()-this.cellPosition.getY()) <= 1
                && !adjacentCellPosition.equals(this.cellPosition);
    }


}
