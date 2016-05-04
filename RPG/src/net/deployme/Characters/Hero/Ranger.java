package net.deployme.Characters.Hero;

/**
 * Created by rpreda on 04/05/16.
 */
public class Ranger extends BaseHero {

    protected boolean canTakeArtifact(BaseHero.Artifact art) {
        switch (art) {
            case BOW: return true;
            case CURSEDARMOR: return true;
            case OVER9K: return true;
            case SWORD: return true;
            default: return false;
        }
    }

    public Ranger() {
        profession = HeroProfession.RANGER;
        hitpoints = 100;
        maxHp = 100;
        armor = 15;
        baseDamage = 11;
        level = 1;

    }
}
