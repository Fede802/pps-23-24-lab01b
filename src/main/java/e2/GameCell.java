package e2;

public class GameCell implements Cell, Clickable {
    private final Cell cell;
    private boolean isSelected;
    public GameCell(int cellX, int cellY) {
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
