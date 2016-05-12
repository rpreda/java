package net.deployme.GameComponents;

public class WorldObject {


    public int posX, posY;
    private static int idIndex = 1;
    private int id;
    private Object entity;

    public Object getEntity() {
        return entity;
    }

    public int hashCode() {
        int hash = posX + posY;
        hash =  entity == null ? hash + entity.hashCode() :  hash;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof WorldObject &&
                ((WorldObject) obj).posY == this.posY &&
                ((WorldObject) obj).posX == this.posX &&
                entity != null &&
                entity.equals(((WorldObject) obj).getEntity()))
            return true;
        return false;
    }

    public WorldObject(int x, int y, Object entity) {
        this.entity = entity;
        posX = x;
        posY = y;
        id = idIndex++;
    }
}
