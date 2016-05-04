package net.deployme.Characters.Hero;
//Kinda overpowered :)
/**
 * Created by rpreda on 04/05/16.
 */
public class Elementalist extends BaseHero {
    protected boolean canTakeArtifact(BaseHero.Artifact art) {
        switch (art) {
            case STAFF: return true;
            case CURSEDARMOR: return true;
            case OVER9K: return true;
            case GREATSWORD: return true;
            default: return false;
        }
    }

    public Elementalist() {
        profession = HeroProfession.ELEMENTALIST;
        hitpoints = 110;
        maxHp = 110;
        armor = 12;
        baseDamage = 30;
        level = 1;
    }
}
