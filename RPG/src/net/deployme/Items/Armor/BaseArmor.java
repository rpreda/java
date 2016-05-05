package net.deployme.Items.Armor;
import net.deployme.Items.BaseItem;

public class BaseArmor extends BaseItem {

    private int defense;
    private String name;

    public int getDefense() {
        return defense;
    }
    public String getName() {
        return name;
    }
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return obj instanceof BaseArmor &&
                ((BaseArmor) obj).getDefense() == this.getDefense() &&
                ((BaseArmor) obj).getName().equals(this.name))
    }
}
