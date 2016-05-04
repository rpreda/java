package net.deployme.Characters.Enemy;

/**
 * Created by rpreda on 04/05/16.
 */
public class Monster extends BaseEnemy {
    public Monster() {
        hitpoints = 200;
        baseDamage = 15;
        damageReduction = 40;
        profession = EnemyProfession.MONSTER;
    }
}
