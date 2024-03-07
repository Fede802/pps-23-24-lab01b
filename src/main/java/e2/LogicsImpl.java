package e2;

import e2.grid.Grid;
import e2.grid.GridImpl;
import e2.grid.initializer.GameInitializer;

public class LogicsImpl implements Logics {

    private final Grid grid;
    public LogicsImpl(int size, int minesToPlace, GameInitializer gameInitializer) {
        this.grid = new GridImpl(size,gameInitializer,minesToPlace);
    }

//    @Override
//    public boolean hasMine(int gridX, int gridY) {
//        //todo add is validgridposition to grid
//        try{
//            return this.grid.hasMine(gridX,gridY);
//        }catch (IndexOutOfBoundsException ioobe){
//            return false;
//        }
//    }

//    @Override
//    public boolean hasMineAround(Pair<Integer, Integer> pos) {
//        for (int i = -1; i <= 1; i++) {
//            for (int j = -1; j <= 1; j++) {
//                if(i != 0 && j != 0 && this.hasMine(pos.getX()+i,pos.getY()+j)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    @Override
    public ClickResult clickCell(Pair<Integer, Integer> cellPosition) {
        return null;
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> cellPosition) {

    }

    @Override
    public boolean isMineCell(Pair<Integer, Integer> cellPosition) {
        return false;
    }

    @Override
    public boolean isCellClicked(Pair<Integer, Integer> cellPosition) {
        return false;
    }

    @Override
    public char[] minesAround(Pair<Integer, Integer> cellPosition) {
        return new char[0];
    }

    @Override
    public boolean isCellFlagged(Pair<Integer, Integer> cellPosition) {
        return false;
    }

    @Override
    public boolean hasMine(Pair<Integer, Integer> cellPosition) {
        return false;
    }
}
