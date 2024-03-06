package e2.cell;

import e2.Pair;

public class ClickableCell implements Cell, Clickable {
    private final Cell cell;
    private boolean isSelected;
    public ClickableCell(int cellX, int cellY) {
        this.cell = new CellImpl(cellX,cellY);
    }
    @Override
    public Pair<Integer, Integer> getCellPosition() {
        return cell.getCellPosition();
    }
    @Override
    public void moveCellTo(int newCellX, int newCellY) {
        cell.moveCellTo(newCellX, newCellY);
    }
    @Override
    public boolean isAdjacentTo(Pair<Integer, Integer> adjacentCellPosition) {
        return cell.isAdjacentTo(adjacentCellPosition);
    }

    @Override
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override
    public void click() {
        this.isSelected = !this.isSelected;
    }
}
