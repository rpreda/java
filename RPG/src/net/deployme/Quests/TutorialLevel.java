package net.deployme.Quests;


import net.deployme.Characters.Enemy.Bandit;
import net.deployme.Characters.Hero.BaseHero;
import net.deployme.GameComponents.GameMap;
import net.deployme.GameComponents.WorldObject;

import java.util.Scanner;

public class TutorialLevel {
    WorldObject player;
    GameMap map;
    private final int mapSize = 4;
    public TutorialLevel(BaseHero player) {
        this.player = new WorldObject(0, 0, player);
        map = new GameMap(mapSize, this.player);
        map.addEnemy(new WorldObject(0, 1, new Bandit()));
    }

    public void startMission() {
        map.printMap();
    }
}
