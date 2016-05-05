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

    public BaseEnemy() {
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
