package net.deployme.Program.GameLogic;

import net.deployme.Characters.Hero.BaseHero;
import net.deployme.Program.MainWindow;

/**
 * Created by rpreda on 10/05/16.
 */
public class UIController {
    private BaseHero player;
    public BaseHero getHero() {
        return player;
    }

    private void changeToGame() {
        MainWindow.getInstance().changePanel(null);
    }

    public void loadFromFile(String path) {
        try {
            player = BaseHero.constructFromFile(path);
            changeToGame();
        }
        catch (Exception e)
        {
            MainWindow.getInstance().notifyUSer(e.getMessage());
        }
    }

    public void initHero(String name, String type) {
        if (name.length() < 20)
            player = BaseHero.HeroFactory(type, 1, name);
    }

}
