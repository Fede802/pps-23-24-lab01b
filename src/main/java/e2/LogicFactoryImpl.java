package e2;

import e2.grid.initializer.GameInitializerImpl;
import e2.grid.minePlacer.DumbMinePlacer;
import e2.grid.minePlacer.RandomMinePlacer;

public class LogicFactoryImpl implements LogicFactory{
    @Override
    public Logics createGameLogic(int size, int minesToPlace) {
        return new LogicsImpl(size,minesToPlace,new GameInitializerImpl(new RandomMinePlacer()));
    }

    @Override
    public Logics createPresetGameLogic(int size, int minesToPlace) {
        return new LogicsImpl(size,minesToPlace,new GameInitializerImpl(new DumbMinePlacer()));
    }
}
