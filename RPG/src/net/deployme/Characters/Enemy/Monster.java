package net.deployme.Characters.Enemy;

/**
 * Created by rpreda on 04/05/16.
 */
public class Monster extends BaseEnemy {
    public Monster(int damage) {
        hitpoints = 200;
        baseDamage = damage;
        damageReduction = 40;
        profession = EnemyProfession.MONSTER;
    }
}
