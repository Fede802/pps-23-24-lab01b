package e2.cell;

import e2.Pair;

public class GameCell implements Cell, Clickable, GameEntity{
    private final ClickableCell clickableCell;

    private Entity entity;
    public GameCell(int cellX, int cellY) {
        this(Entity.FREE,cellX,cellY);
    }

    public GameCell(Entity entity, int cellX, int cellY) {
        this.clickableCell = new ClickableCell(cellX,cellY);
        this.entity = entity;
    }

    @Override
    public Pair<Integer, Integer> getCellPosition() {
        return clickableCell.getCellPosition();
    }

    @Override
    public void moveCellTo(int newCellX, int newCellY) {
        clickableCell.moveCellTo(newCellX, newCellY);
    }

    @Override
    public boolean isAdjacentTo(Pair<Integer, Integer> adjacentCellPosition) {
        return clickableCell.isAdjacentTo(adjacentCellPosition);
    }

    @Override
    public boolean isSelected() {
        return clickableCell.isSelected();
    }

    @Override
    public void click() {
        clickableCell.click();
    }

    @Override
    public Entity getEntityType() {
        return this.entity;
    }

    @Override
    public void setType(Entity entity) {
        this.entity = entity;
    }
}
