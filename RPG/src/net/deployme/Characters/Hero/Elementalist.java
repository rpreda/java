package net.deployme.Characters.Hero;
//Kinda overpowered :)
/**
 * Created by rpreda on 04/05/16.
 */
public class Elementalist extends BaseHero {

    public Elementalist(int level) {
        profession = HeroProfession.ELEMENTALIST;
        hitpoints = 110;
        maxHp = 110;
        armor = 12;
        baseDamage = 30;
        this.level = level;
    }
}
