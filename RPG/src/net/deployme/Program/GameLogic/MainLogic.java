package net.deployme.Program.GameLogic;
import net.deployme.Characters.Hero.BaseHero;
import net.deployme.Characters.Hero.Warrior;
import net.deployme.Program.MainWindow;
import net.deployme.Program.UIPanels.CreateHero;
import net.deployme.Program.UIPanels.GameMenu;


public class MainLogic {
    private BaseHero player;
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

    public BaseHero getHero() {
        return player;
    }

    public void newGame() {
        MainWindow.getInstance().changePanel(new CreateHero());
    }

    public void showGameMenu() {
        MainWindow.getInstance().changePanel(new GameMenu());
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
