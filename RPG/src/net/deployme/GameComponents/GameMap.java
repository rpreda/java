package net.deployme.GameComponents;
import net.deployme.Characters.Enemy.Bandit;
import net.deployme.Characters.Enemy.Monster;
import net.deployme.Characters.Enemy.Rogue;
import net.deployme.Characters.Enemy.Warlock;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class GameMap {//this should be restructured later
    private int mapSize;
    public WorldObject player;
    private List<WorldObject> enemies = new ArrayList<>();
    private List<WorldObject> items = new ArrayList<>();

    private WorldObject getEnemy(String[] line) {
        if (line.length == 3)
            switch (line[0]) {
                case "BANDIT": return new WorldObject(Integer.parseInt(line[1]), Integer.parseInt(line[2]), new Bandit());
                case "ROGUE": return new WorldObject(Integer.parseInt(line[1]), Integer.parseInt(line[2]), new Rogue());
                case "WARLOCK": return new WorldObject(Integer.parseInt(line[1]), Integer.parseInt(line[2]), new Warlock());
                case "MONSTER": return new WorldObject(Integer.parseInt(line[1]), Integer.parseInt(line[2]), new Monster(1));
            }
        return null;
    }

    private void loadFromFile(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String currentLine;
        currentLine = br.readLine();
        String[] lineData = currentLine.split("\\s+");
        this.mapSize = Integer.parseInt(lineData[1]);
        while ((currentLine = br.readLine()) != null) {//at the moment only enemies are loaded
            lineData = currentLine.split("\\s+");
            this.addEnemy(getEnemy(lineData));
        }
    }

    public GameMap(WorldObject player, String filePath) throws Exception {
        this.player = player;
        loadFromFile(filePath);
    }

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
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++)
                System.out.print(buffer[i][j]);
            System.out.println();
        }
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
        if (!enemies.contains(obj) && obj != null) {
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
