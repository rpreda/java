package net.deployme.Characters.Hero;

/**
 * Created by rpreda on 04/05/16.
 */
public class Guardian extends BaseHero {

    public Guardian() {
        profession = HeroProfession.GUARDIAN;
        hitpoints = 140;
        maxHp = 140;
        armor = 25;
        baseDamage = 12;
        level = 1;
    }
}
