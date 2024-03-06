package e2.grid.initializer;

public class EmptyGridInitializerTest extends GridInitializerTest{
    @Override
    protected GridInitializer createGridInitializer() {
        return new EmptyGridInitializer();
    }
}
