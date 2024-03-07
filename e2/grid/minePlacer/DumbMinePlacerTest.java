package e2.grid.minePlacer;

public class DumbMinePlacerTest extends MinePlacerTest{
    @Override
    protected MinePlacer createMinePlacer() {
        return new DumbMinePlacer();
    }
}
