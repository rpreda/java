package net.deployme.Characters.Hero;

/**
 * Created by rpreda on 04/05/16.
 */
public class Ranger extends BaseHero {

    public Ranger(int level) {
        profession = HeroProfession.RANGER;
        hitpoints = 100;
        maxHp = 100;
        armor = 15;
        baseDamage = 11;
        this.level = level;

    }
}
