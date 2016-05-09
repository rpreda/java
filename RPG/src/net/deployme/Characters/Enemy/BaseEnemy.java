package net.deployme.Characters.Enemy;

public abstract class BaseEnemy {

    public enum EnemyProfession {
        BANDIT, ROGUE, WARLOCK, MONSTER
    }

    protected int hitpoints;
    protected int baseDamage;
    protected static int idIndex = 1;
    protected int id;
    protected int damageReduction;//between 1 to 100
    protected EnemyProfession profession;

    public static BaseEnemy enemyFactory(String type, int dmg, int hp, int armor) {
        switch (type) {
            case "Bandit": return new Bandit(dmg, hp, armor);
            case "Monster": return new Monster(dmg, hp, armor);
            case "Rogue": return new Rogue(dmg, hp, armor);
            case "Warlock": return new Warlock(dmg, hp, armor);
            default: return null;
        }
    }

    public BaseEnemy(int damage, int hitpoints, int damageReduction) {
        this.baseDamage = damage;
        this.hitpoints = hitpoints;
        this.damageReduction = damageReduction;
        id = idIndex++;
    }

    public int getId() {
        return id;
    }
    public String toString() {
        return "HP: " + hitpoints + " BaseDamage: " + baseDamage + " DamageReduction: " + damageReduction;
    }

    public boolean isDead() {
        if (hitpoints <= 0)
            return true;
        return false;
    }

    public boolean takeDamage(int trueDamage) {//returns true if still alive and false when dead
        trueDamage -= trueDamage * baseDamage / 100;
        if (trueDamage < 0)
            trueDamage = 0;
        hitpoints -= trueDamage;
        if (hitpoints <= 0)
            return false;
        else
            return true;
    }

    public int dealDamage() {
        return baseDamage;
    }
}
