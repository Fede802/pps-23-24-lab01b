package e1;

public class BoardImpl implements Board {
    public BoardImpl() {
    }
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
