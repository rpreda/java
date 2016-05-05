package net.deployme.Characters.Hero;
import net.deployme.Items.Armor.BaseArmor;
import net.deployme.Items.BaseItem;
import net.deployme.Items.Weapons.BaseWeapon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseHero {

    public enum HeroProfession {
        RANGER, ELEMENTALIST, WARRIOR, GUARDIAN
    }

    //Fields have to be initialised by hero type
    protected int hitpoints;
    protected int maxHp;
    protected int baseDamage;
    protected int level = 1;
    protected int armor; //1 point of armor reduces 0.2 damage ( /5 when computing)
    protected BaseWeapon weapon;
    protected List<BaseArmor> gear = new ArrayList<>();

    protected HeroProfession profession;

    //TODO: rewrite tostring and reimplement hashCode and equals
    //TODO: lose and get items
    //TODO: rewerite take damage
    //TODO: DEAL DAMAGE

    public boolean getItem(BaseItem item) {//true if item added false else
        if (item != null && item.getMinimumLevel() <= this.level) {
            if (item instanceof BaseWeapon) {
                weapon = (BaseWeapon)item;
                return true;
            } else if (item instanceof BaseArmor)
            {
                for (Iterator<BaseArmor> iterator = gear.iterator(); iterator.hasNext();) {//Safely remove element from collection while iterating through it
                    BaseArmor gearPiece = iterator.next();
                    if (gearPiece.getSlot() == ((BaseArmor) item).getSlot()) {
                        iterator.remove();
                        System.out.println("Duplicate found, removing it");
                    }
                }
                gear.add((BaseArmor)item);
                return true;
            }
        }
        return false;
    }

    public int getHitpoints() {
        return hitpoints;
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

    public boolean takeDamage(int trueDamage) {//returns true if still alive or false if dead
        hitpoints -= computeDefense(trueDamage);
        if (hitpoints <= 0) {
            hitpoints = 0;
            return false;
        }
        return true;
    }

}
