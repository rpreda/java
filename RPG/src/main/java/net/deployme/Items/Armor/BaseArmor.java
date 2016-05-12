package net.deployme.Items.Armor;
import net.deployme.Items.BaseItem;

public abstract class BaseArmor extends BaseItem {

    public enum Slot {
        HELM, SHOULDERS, CHEST, HANDS, LEGS
    }

    protected int defense;
    protected Slot slot;

    public BaseArmor(String name, int minimumLevel, Slot slot, int defense) {
        super(name, minimumLevel);
        this.slot = slot;
        this.defense = defense;
    }

    public int computeReduction(int trueDamage) {
        trueDamage -= defense;
        if (trueDamage <= 0)
            return 1;
        return trueDamage;
    }

    public Slot getSlot() {
        return slot;
    }

    public int getDefense() {
        return defense;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return obj instanceof BaseArmor &&
                ((BaseArmor) obj).getDefense() == this.getDefense() &&
                ((BaseArmor) obj).getName().equals(this.name);
    }

    public int hashCode() {
        int ret_val = defense;
        char[] array = name.toCharArray();
        for (Character c:array)
            ret_val += c;
        return ret_val;
    }

}
