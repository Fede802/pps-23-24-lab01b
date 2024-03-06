package e2.grid;

public class EmptyGridInitializerTest extends GridInitializerTest{
    @Override
    protected GridInitializer createGridInitializer() {
        return new EmptyGridInitializer();
    }
}
