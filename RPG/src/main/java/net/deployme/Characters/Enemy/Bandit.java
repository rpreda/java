package net.deployme.Characters.Enemy;

/**
 * Created by rpreda on 04/05/16.
 */
public class Bandit extends BaseEnemy {
    public Bandit(int damage, int hp, int armor) {
        super(damage, hp, armor);
        profession = EnemyProfession.BANDIT;
    }
}
