package net.deployme.Program.GameLogic;
import net.deployme.Characters.Enemy.BaseEnemy;
import net.deployme.Characters.Hero.BaseHero;
import net.deployme.Characters.Hero.Warrior;
import net.deployme.GameComponents.GameMap;
import net.deployme.GameComponents.WorldObject;
import net.deployme.Items.Weapons.Sword;
import net.deployme.Program.MainWindow;
import net.deployme.Program.UIPanels.CreateHero;
import net.deployme.Program.UIPanels.GameMenu;
import net.deployme.Program.UIPanels.GameplayWindow;
import sun.applet.Main;

import java.util.Random;

public class MainLogic {
    private BaseHero player;
    private GameMap currentLevel;
    private static MainLogic instance;

    private MainLogic() {
    }

    public static MainLogic getInstance() {
        if (instance == null) {
            instance = new MainLogic();
            return instance;
        }
        return instance;
    }

    public void win() {
        MainWindow.getInstance().notifyUser("YOU WON!");
        MainWindow.getInstance().changePanel(new GameMenu());
        this.currentLevel = null;
        player.levelUp();
    }

    public void movePlayer(int dir) {
        //1 up
        //2 down
        //3 left
        //4 right
        switch (dir) {
            case 1:  if(currentLevel.player.posX > 0)
                currentLevel.player.posX -= 1;
            else
                currentLevel.won = true;
                break;
            case 2:  if(currentLevel.player.posX < currentLevel.getMapSize() - 1)
                currentLevel.player.posX += 1;
            else
                currentLevel.won = true;
                break;
            case 3:  if(currentLevel.player.posY > 0)
                currentLevel.player.posY -= 1;
            else
                currentLevel.won = true;
                break;
            case 4:  if(currentLevel.player.posY < currentLevel.getMapSize() - 1)
                currentLevel.player.posY += 1;
            else
                currentLevel.won = true;
                break;
        }
        if (player.getHitpoints() < player.getMaxHitpoints())
                player.regenHp();
        WorldObject obj;
        if ((obj = currentLevel.getSquareContent(currentLevel.player.posX, currentLevel.player.posY)) != null) {
            if (obj.getEntity() instanceof BaseEnemy) {
                currentLevel.fighting = true;
                currentLevel.enemy = (BaseEnemy)obj.getEntity();
                currentLevel.enemyDamage = Integer.toString(((BaseEnemy) obj.getEntity()).dealDamage());
            }
        }
        currentLevel.notifyObservers();

    }

    public void fightEnemy() {
        while (!currentLevel.enemy.isDead() && !player.isDead()) {
            player.takeDamage(currentLevel.enemy.dealDamage());
            currentLevel.enemy.takeDamage(player.dealDamage());
        }
        if (currentLevel.enemy.isDead()) {
            currentLevel.enemy = null;
            currentLevel.fighting = false;
            currentLevel.canFlee = true;
            currentLevel.removeEnemy(currentLevel.getSquareContent(currentLevel.player.posX, currentLevel.player.posY));
            player.removeWeapon();
            player.obtainGear(new Sword());//always gets a sword when killing enemy
        }
        else if (player.isDead()) {
            currentLevel = null;
            MainWindow.getInstance().changePanel(new GameMenu());//TODO: here add a percentage chance for a drop from enemy
            return;
        }
        currentLevel.notifyObservers();
    }
    public void fleeEnemy() {
        Random rand = new Random();
        if (10 < rand.nextInt(100)) {//10 percent chance to not be able to flee
            currentLevel.fighting = false;
            currentLevel.player.posX = currentLevel.getMapSize() / 2;
            currentLevel.player.posY = currentLevel.getMapSize() / 2;
            currentLevel.notifyObservers();
        }
        else
            currentLevel.canFlee = false;
        currentLevel.notifyObservers();
    }

    public BaseHero getHero() {
        return player;
    }

    public void newGame() {
        MainWindow.getInstance().changePanel(new CreateHero());
    }

    public void notifyTest() {
        currentLevel.notifyObservers();
    }

    public void showGameMenu() {
        MainWindow.getInstance().changePanel(new GameMenu());
    }

    public void loadLevel(String mapPath) {
        try {
            GameplayWindow view = new GameplayWindow();
            currentLevel = new GameMap(new WorldObject(10, 10, player), mapPath);
            currentLevel.player.posY = currentLevel.getMapSize() / 2;
            currentLevel.player.posX = currentLevel.getMapSize() / 2;
            MainWindow.getInstance().changePanel(view);
            currentLevel.registerObserver(view);
            currentLevel.notifyObservers();
        }
        catch (Exception e) {
            MainWindow.getInstance().notifyUser(e.getMessage());
        }
    }

    public void loadGame(String path) {
        try {
            player = BaseHero.constructFromFile(path);
            showGameMenu();
        }
        catch (Exception e)
        {
            MainWindow.getInstance().notifyUser(e.getMessage());
        }
    }

    public void saveHero(String path) {
        try {
            player.saveToFile(path);
        }
        catch (Exception e) {
            e.printStackTrace();
            MainWindow.getInstance().notifyUser(e.getMessage());
        }
    }

    public boolean initHero(String name, String type) {
        if (name.length() < 20 && name.length() > 0) {
            player = BaseHero.HeroFactory(type, 1, name);
            if (player == null) {
                MainWindow.getInstance().notifyUser("Error in generating hero for type: " + type + " and name " + name);
                return false;
            }
            return true;
        }
        return false;
    }

}
