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
    private BaseWeapon weapon;
    private List<BaseArmor> gear = new ArrayList<>();

    protected HeroProfession profession;

    //TODO: and reimplement hashCode and equals
    //TODO: rewerite take damage and the defense function
    //TODO: DEAL DAMAGE
    //TODO: implement id and implement that one to villans too

    public String toString() {
        String items = "";
        String wp = weapon == null ? "none" : weapon.toString();
        for (BaseItem item : gear)
            items += item.toString() + " ";
        if (gear.isEmpty())
            items = "none";
        return profession.toString() + " HP: " + hitpoints + " LEVEL: " +
                level + " ITEMS: " + items + " WEAPON: " + wp +  " ARMOR: " + armor +
                " BASEDMG: " + baseDamage;
    }

    public boolean loseItem(int id) {//lose by item id returns false if item not found
        if (weapon != null && weapon.getId() == id) {
            weapon = null;
            return true;
        } else {
            for (Iterator<BaseArmor> iterator = gear.iterator(); iterator.hasNext();) {//Safely remove element from collection while iterating through it
                BaseArmor gearPiece = iterator.next();
                if (gearPiece.getId() == id) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public void removeWeapon() {//removes the weapon
        weapon = null;
    }

    public boolean loseGear(BaseArmor.Slot slot) {//lose gear by slot type
        for (Iterator<BaseArmor> iterator = gear.iterator(); iterator.hasNext();) {//Safely remove element from collection while iterating through it
            BaseArmor gearPiece = iterator.next();
            if (gearPiece.getSlot() == slot) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

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
                        //System.out.println("Duplicate found, removing it");
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
        //hitpoints -= computeDefense(trueDamage);
        if (hitpoints <= 0) {
            hitpoints = 0;
            return false;
        }
        return true;
    }

}
