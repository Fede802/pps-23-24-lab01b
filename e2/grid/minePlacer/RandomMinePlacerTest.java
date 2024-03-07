package e2.grid.minePlacer;

public class RandomMinePlacerTest extends MinePlacerTest{

    @Override
    protected MinePlacer createMinePlacer() {
        return new RandomMinePlacer();
    }
}
