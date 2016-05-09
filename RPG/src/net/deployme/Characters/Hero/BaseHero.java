package net.deployme.Characters.Hero;
import com.sun.xml.internal.rngom.parse.host.Base;
import net.deployme.Items.Armor.BaseArmor;
import net.deployme.Items.BaseItem;
import net.deployme.Items.Weapons.BaseWeapon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseHero implements java.io.Serializable{

    private class InvetoryFullException extends Exception {
        @Override
        public String getMessage(){
            return "Failed to add item to inventory because it is already full";
        }
    }

    private class WrongItemLevelException extends Exception {
        @Override
        public String getMessage(){
            return "Failed to add item to inventory because it's level is too big";
        }
    }

    public enum HeroProfession {
        RANGER, ELEMENTALIST, WARRIOR, GUARDIAN
    }

    //Fields have to be initialised by hero type
    protected int hitpoints;
    protected static int idIndex = 1;
    protected transient int id;
    protected int maxHp;
    protected int baseDamage;
    protected int level = 1;
    protected int armor; //1 point of armor reduces 0.2 damage ( /5 when computing)
    private BaseWeapon weapon;
    private List<BaseArmor> gear = new ArrayList<>();

    private int invetoryLimit = 10;
    private List<BaseItem> inventory = new ArrayList<>();

    protected HeroProfession profession;

    BaseHero() {
        id = idIndex++;
    }

    /** GET: **/
    public int getHitpoints() {
        return hitpoints;
    }
    public int getId() {
        return id;
    }
    public int getMaxHitpoints() { return maxHp; }
    public int getBaseDamage() { return baseDamage; }
    public int getLevel() { return level; }
    public int getArmor() { return armor; }
    /** ENDGET **/

    public static BaseHero HeroFactory(String heroType, int level) {//reflection not really worth it here?
        switch (heroType) {
            case "Elementalist": return new Elementalist(level);
            case "Guardian": return new Guardian(level);
            case "Ranger": return new Ranger(level);
            case "Warrior": return new Warrior(level);
            default: return null;
        }
    }

    public static BaseHero constructFromFile(String path) throws Exception {
        BaseHero deserialized;
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        (deserialized = (BaseHero)in.readObject()).fixId();
        return deserialized;
    }

    public void saveToFile(String path) throws Exception{
        FileOutputStream fileOut = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }

    public void fixId() {
        id = idIndex++;
    }

    public boolean removeInventoryItem(BaseItem item) {
        return inventory.remove(item);
    }

    public void addInventoryItem(BaseItem item) throws WrongItemLevelException, InvetoryFullException{
        if (item.getMinimumLevel() > level)
            throw new WrongItemLevelException();
        if (!(inventory.size() < invetoryLimit))
            throw new InvetoryFullException();
        inventory.add(item);
    }

    public int hashCode() {
        return this.id + this.hitpoints;
    }

    public boolean equals (Object obj) {
        if (obj == null)
            return false;
        return obj instanceof BaseHero && ((BaseHero) obj).getId() == this.id;
    }

    public String toString() {
        String items = "";
        String wp = weapon == null ? "none" : weapon.toString();
        for (BaseItem item : gear)
            items += item.toString() + " ";
        if (gear.isEmpty())
            items = "none";
        return "ID: " + id + " PROFESSION: " + profession.toString() + " HP: " + hitpoints + " LEVEL: " +
                level + " ITEMS: " + items + " WEAPON: " + wp +  " ARMOR: " + armor +
                " BASEDMG: " + baseDamage;
    }

    public int dealDamage() {
        int damageDealt = baseDamage;
        if (weapon != null)
            damageDealt = weapon.computeDamageIncrease(baseDamage);
        return damageDealt;
    }

    public boolean loseGear(int id) {//lose by item id returns false if item not found
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

    public boolean obtainGear(BaseItem item) {//true if item added false else
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
                    }
                }
                gear.add((BaseArmor)item);
                return true;
            }
        }
        return false;
    }

    public  void levelDown() {
        if (level > 1) {
            invetoryLimit -= 2;
            armor -= 10;
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
        invetoryLimit += 2;
        armor += 10;
    }

    public boolean isDead() {
        if (hitpoints <= 0)
            return true;
        return false;
    }

    public boolean takeDamage(int trueDamage) {//returns true if still alive or false if dead
        for (BaseArmor gearPiece : gear) {
            trueDamage = gearPiece.computeReduction(trueDamage);
        }
        if (trueDamage <= 2)
            trueDamage = 2;
        hitpoints -= trueDamage;
        if (hitpoints <= 0) {
            hitpoints = 0;
            return false;
        }
        return true;
    }

}
