package net.deployme.Characters.Enemy;

/**
 * Created by rpreda on 04/05/16.
 */
public class Bandit extends BaseEnemy {
    public Bandit() {
        hitpoints = 70;
        baseDamage = 10;
        damageReduction = 10;
        profession = EnemyProfession.BANDIT;
    }
}
