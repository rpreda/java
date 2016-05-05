package net.deployme.Items.Weapons;
import net.deployme.Items.BaseItem;
import java.util.Random;

public abstract class BaseWeapon extends BaseItem {
    public enum WeaponType {
        SWORD, BOW, STAFF, MACE
    }

    protected int damageIncrease;
    protected int randomBonusCap;
    protected WeaponType type;

    public BaseWeapon(String name, int minimumLevel, int damageIncrease, int randomBonusCap, WeaponType type) {
        super(name, minimumLevel);
        this.randomBonusCap = randomBonusCap;
        this.damageIncrease = damageIncrease;
        this.type = type;
    }

    public WeaponType getType() {
        return type;
    }

    public int computeDamageIncrease(int baseDamage) {
        Random rand = new Random();
        if (baseDamage < 0)
            baseDamage = 0;
        baseDamage += damageIncrease;
        baseDamage += rand.nextInt(randomBonusCap);
        return baseDamage;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return obj instanceof BaseWeapon &&
                ((BaseWeapon) obj).damageIncrease == this.damageIncrease &&
                ((BaseWeapon) obj).randomBonusCap == this.randomBonusCap;
    }

    public int hashCode() {
        int ret_val = damageIncrease + randomBonusCap;
        char[] array = name.toCharArray();
        for (Character c : array)
            ret_val += c;
        return ret_val;
    }
}
