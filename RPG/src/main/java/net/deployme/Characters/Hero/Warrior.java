package net.deployme.Characters.Hero;

/**
 * Created by rpreda on 04/05/16.
 */
public class Warrior extends BaseHero {

    public Warrior(int level, String name) {
        super(level, name);
        profession = HeroProfession.WARRIOR;
        hitpoints = 130;
        maxHp = 130;
        armor = 20;
        baseDamage = 15;
        this.level = level;
    }
}
