package e2.grid;

import org.junit.jupiter.api.BeforeEach;

public class GameInitializerTest extends GridInitializerTest{



    @Override
    protected GridInitializer createGridInitializer() {
        return new GameInitializerImpl();
    }
}
