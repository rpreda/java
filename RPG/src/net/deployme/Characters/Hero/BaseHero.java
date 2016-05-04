package net.deployme.Characters.Hero;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseHero {

    public enum Artifact {
        SHIELD, GREATSWORD, STAFF, BOW, SWORD, CURSEDARMOR, OVER9K //also artifacts heal you to max hp
        //over 9k instant 9001 damage
        //shield - 20% damage taken
        //greatsword + 30% damage dealt
        //staff + 25% damage dealt + 20 ability power
        //bow + 25% damage dealt + 40 agility
        //sword +20% damage
        //cursedarmor -50% damage taken BEFORE everything else
    }

    public enum HeroProfession {
        RANGER, ELEMENTALIST, WARRIOR, GUARDIAN
    }

    //Fields have to be initialised by hero type
    protected int hitpoints;
    protected int maxHp;
    protected int baseDamage;
    protected int level = 1;
    protected int armor; //1 point of armor reduces 0.2 damage ( /5 when computing)

    protected HeroProfession profession;
    private List<Artifact> ownedArtifacts = new ArrayList<>();

    public String toString() {
        String artifacts = "";
        for (Artifact art : ownedArtifacts)
            artifacts += art.toString() + " ";
        if (ownedArtifacts.isEmpty())
            artifacts = "none";
        return profession.toString() + " HP: " + hitpoints + " LEVEL: " +
                level + " ARTIFACTS: " + artifacts + " ARMOR: " + armor +
                " BASEDMG: " + baseDamage;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    protected abstract boolean canTakeArtifact(Artifact art);

    public int dealDamage() {
        int retVal = baseDamage;
        retVal += retVal * 0.5 * level;
        if (ownedArtifacts.contains(Artifact.OVER9K))
            return 9001;
        if (ownedArtifacts.contains(Artifact.GREATSWORD))
            retVal += 0.3 * retVal;
        if (ownedArtifacts.contains(Artifact.BOW))
            retVal += 0.25 * retVal;
        if (ownedArtifacts.contains(Artifact.SWORD))
            retVal += 0.2 * retVal;
        if (ownedArtifacts.contains(Artifact.STAFF))
            retVal += 0.25 * retVal;

        return retVal;
    }

    public  void levelDown() {
        if (level > 1) {
            level--;
            maxHp = level * 100;
            baseDamage -= 10;
            if (hitpoints > maxHp)
                hitpoints = maxHp;
        }
    }

    public void levelUp() {
        level++;
        maxHp = level * 100;
        baseDamage += 10;
    }

    public boolean isDead() {
        if (hitpoints <= 0)
            return true;
        return false;
    }

    public boolean getArtifact(Artifact art) {
        if (canTakeArtifact(art) && !ownedArtifacts.contains(art)) {
            ownedArtifacts.add(art);
            hitpoints = maxHp;
            return true;
        }
        else return false;
    }

    public boolean loseArtifact(Artifact art) {
       return ownedArtifacts.remove(art);
    }

    private int computeDefense(int trueDamage) {
        int initial = trueDamage;
        if (ownedArtifacts.contains(Artifact.CURSEDARMOR))
            trueDamage /= 2;
        if (ownedArtifacts.contains(Artifact.SHIELD))
            trueDamage -= trueDamage * 0.2;
        trueDamage -= armor / 5;
        if (trueDamage < initial / 10)
            return initial / 10;
        return trueDamage;
    }

    public boolean takeDamage(int trueDamage) {//returns true if still alive or false if dead
        hitpoints -= computeDefense(trueDamage);
        if (hitpoints <= 0) {
            hitpoints = 0;
            return false;
        }
        return true;
    }

}
