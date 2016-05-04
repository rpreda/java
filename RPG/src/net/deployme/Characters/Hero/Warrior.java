package net.deployme.Characters.Hero;

/**
 * Created by rpreda on 04/05/16.
 */
public class Warrior extends BaseHero {
    protected boolean canTakeArtifact(BaseHero.Artifact art) {
        switch (art) {
            case SHIELD: return true;
            case CURSEDARMOR: return true;
            case OVER9K: return true;
            case GREATSWORD: return true;
            default: return false;
        }
    }

    public Warrior() {
        profession = HeroProfession.WARRIOR;
        hitpoints = 130;
        maxHp = 130;
        armor = 20;
        baseDamage = 15;
        level = 1;
    }
}
