package net.deployme.GameComponents;
import net.deployme.Characters.Enemy.*;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class GameMap extends net.deployme.GameComponents.Observable{//this should be restructured later
    private int mapSize;
    public boolean won = false;
    public boolean lost = false;
    public boolean fighting;
    public String enemyDamage;
    public WorldObject player;
    public BaseEnemy enemy;
    private List<WorldObject> enemies = new ArrayList<>();
    private List<WorldObject> items = new ArrayList<>();

    public int getMapSize() {
        return mapSize;
    }

    public void removeEnemy(WorldObject enemy) {
        enemies.remove(enemy);
    }

    private WorldObject getEnemy(String[] line) throws Exception{
        int x = Integer.parseInt(line[1]);
        int y = Integer.parseInt(line[2]);
        int damage = Integer.parseInt(line[3]);
        int hp = Integer.parseInt(line[4]);
        int armor = Integer.parseInt(line[5]);
        BaseEnemy enemy = BaseEnemy.enemyFactory(line[0], damage, hp, armor);
        if (enemy == null)
            throw new Exception("enemyFactory returned a null object, check your input file and the data in getEnemy!");
        return new WorldObject(x, y, enemy);
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

    public int[][] imageMap() {
        //0 empty
        //1 enemy
        //2 item
        //3 player
        int[][] buffer = new int[mapSize][mapSize ];
        for (int i = 0; i < mapSize; i++)
            for (int j = 0; j < mapSize; j++)
                buffer[i][j] = 0;
        for(WorldObject obj : enemies)
            buffer[obj.posX][obj.posY] = 1;
        for(WorldObject obj : items)
            buffer[obj.posX][obj.posY] = 2;
        buffer[player.posX][player.posY] = 3;
        /*for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++)
                System.out.print(buffer[i][j]);
            System.out.println();
        }*/
        return buffer;
    }

    public boolean addItem(WorldObject obj) {
        if (!items.contains(obj)) {
            items.add(obj);
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
