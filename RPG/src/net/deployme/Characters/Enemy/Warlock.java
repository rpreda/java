package net.deployme.Characters.Enemy;

import java.util.Random;

/**
 * Created by rpreda on 04/05/16.
 */
public class Warlock extends BaseEnemy{
    private final int max_hp = 100;

    public Warlock(int damage, int hp, int armor) {
        super(damage, hp, armor);
        profession = EnemyProfession.WARLOCK;
    }

    public boolean takeDamage(int trueDamage) {//returns true if still alive and false when dead
        Random RNGesus = new Random();
        int ouch = RNGesus.nextInt(100);
        if (ouch > 15 && ouch < 20) {
            hitpoints = max_hp;
            return false;
        }
        else
            return super.takeDamage(trueDamage);
    }
}
