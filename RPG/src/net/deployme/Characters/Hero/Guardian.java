package net.deployme.Characters.Hero;

/**
 * Created by rpreda on 04/05/16.
 */
public class Guardian extends BaseHero {
    protected boolean canTakeArtifact(BaseHero.Artifact art) {
        switch (art) {
            case SHIELD: return true;
            case CURSEDARMOR: return true;
            case OVER9K: return true;
            case SWORD: return true;
            default: return false;
        }

    }
    public Guardian() {
        profession = HeroProfession.GUARDIAN;
        hitpoints = 140;
        maxHp = 140;
        armor = 25;
        baseDamage = 12;
        level = 1;
    }
}
