package net.deployme.Characters.Enemy;
import java.util.Random;
/**
 * Created by rpreda on 04/05/16.
 */
public class Rogue extends BaseEnemy {
    public Rogue(int damage, int hp, int armor) {
        super(damage, hp, armor);
        profession = EnemyProfession.ROGUE;
    }

    public int dealDamage() {//can critically strike
        Random rand = new Random();
        int chance = rand.nextInt(10);
        if (chance < 3)
            return baseDamage * 2;
        return baseDamage;
    }

}
