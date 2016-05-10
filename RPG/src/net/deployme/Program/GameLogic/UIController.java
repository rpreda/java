package net.deployme.Program.GameLogic;

import net.deployme.Characters.Hero.BaseHero;
import net.deployme.Program.MainWindow;
import net.deployme.Program.UIPanels.CreateHero;


public class UIController {
    private BaseHero player;
    public BaseHero getHero() {
        return player;
    }

    public void newGame() {
        MainWindow.getInstance().changePanel(new CreateHero());
    }

    public void initGame() {

    }

    public void loadGame(String path) {
        try {
            player = BaseHero.constructFromFile(path);
            initGame();
            //TODO load the ui element for playing the game
        }
        catch (Exception e)
        {
            MainWindow.getInstance().notifyUSer(e.getMessage());
        }
    }

    public boolean initHero(String name, String type) {
        if (name.length() < 20 && name.length() > 0) {
            player = BaseHero.HeroFactory(type, 1, name);
            if (player == null)
                MainWindow.getInstance().notifyUSer("Error in generating hero for type: " + type + " and name " + name);
            return true;
        }
        return false;
    }

}
