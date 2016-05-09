package net.deployme.Characters.Enemy;

/**
 * Created by rpreda on 04/05/16.
 */
public class Monster extends BaseEnemy {
    public Monster(int damage, int hp, int armor) {
        super(damage, hp, armor);
        profession = EnemyProfession.MONSTER;
    }
}
