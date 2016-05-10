package net.deployme.Program.GameLogic;

import net.deployme.Characters.Hero.BaseHero;
import net.deployme.Program.MainWindow;
import net.deployme.Program.UIPanels.CreateHero;


public class MainLogic {
    private BaseHero player;
    public BaseHero getHero() {
        return player;
    }

    public void newGame() {
        MainWindow.getInstance().changePanel(new CreateHero());
    }

    public void showGameMenu() {
        MainWindow.getInstance().notifyUser("Game started!");
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

    public boolean initHero(String name, String type) {
        if (name.length() < 20 && name.length() > 0) {
            player = BaseHero.HeroFactory(type, 1, name);
            if (player == null)
                MainWindow.getInstance().notifyUser("Error in generating hero for type: " + type + " and name " + name);
            return true;
        }
        return false;
    }

}
