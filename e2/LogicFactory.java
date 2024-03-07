package e2;

import e2.Logics;

public interface LogicFactory {
    Logics createGameLogic(int size, int minesToPlace);
    Logics createPresetGameLogic(int size, int minesToPlace);
}
