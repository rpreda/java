package net.deployme.GameComponents;
import java.util.ArrayList;
import java.util.List;

public class GameMap {//this should be restructured later
    private int mapSize;
    public WorldObject player;
    private List<WorldObject> enemies = new ArrayList<>();
    private List<WorldObject> items = new ArrayList<>();

    public GameMap(int mapSize, WorldObject player) {
        this.mapSize = mapSize;
        this.player = player;
    }

    public void printMap() {
        // * player
        // @ enemy
        // ^ item
        // 0 empty space
        char[][] buffer = new char[mapSize + 1][mapSize + 1];
        for (int i = 0; i < mapSize; i++)
            for (int j = 0; j < mapSize; j++)
                buffer[i][j] = '0';
        for(WorldObject obj : enemies)
            buffer[obj.posX][obj.posY] = '@';
        for(WorldObject obj : items)
            buffer[obj.posX][obj.posY] = '^';
        buffer[player.posX][player.posY] = '*';
    }

    public boolean addItem(WorldObject obj) {
        if (!items.contains(obj)) {
            items.add(obj);;
            return true;
        }
        return false;
    }

    public int enemyCount() {
        return enemies.size();
    }

    public boolean addEnemy(WorldObject obj) {
        if (!enemies.contains(obj)) {
            enemies.add(obj);
            return true;
        }
        return false;
    }

    public WorldObject getSquareContent(int x, int y) {
        for (WorldObject obj : enemies)
            if (obj.posX == x && obj.posY == y)
                return obj;
        for (WorldObject obj : items)
            if (obj.posX == x && obj.posY == y)
                return obj;
        return null;
    }

}
