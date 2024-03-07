package e2.cell;

public interface GameEntity {
    Entity getEntityType();

    void setType(Entity entity);

    enum Entity{
        MINE,
        FREE
    }

}
