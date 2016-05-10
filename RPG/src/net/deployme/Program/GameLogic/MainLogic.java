package net.deployme.Program.GameLogic;
import net.deployme.Characters.Hero.BaseHero;
import net.deployme.Characters.Hero.Warrior;
import net.deployme.GameComponents.GameMap;
import net.deployme.GameComponents.WorldObject;
import net.deployme.Program.MainWindow;
import net.deployme.Program.UIPanels.CreateHero;
import net.deployme.Program.UIPanels.GameMenu;
import net.deployme.Program.UIPanels.GameplayWindow;

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
