package net.deployme.Program;
import net.deployme.Characters.Enemy.Bandit;
import net.deployme.Characters.Hero.*;
import net.deployme.GameComponents.GameMap;
import net.deployme.GameComponents.WorldObject;
import net.deployme.Items.Armor.AdeptChest;
import net.deployme.Items.Armor.AdeptHelm;
import net.deployme.Items.Weapons.Sword;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Program {
    public static void main(String args[]) {
        Sword swordTest = new Sword();
        Bandit testBandit = new Bandit(10, 100, 10);
        AdeptHelm helm = new AdeptHelm();
        AdeptChest chest = new AdeptChest();
        Elementalist elem = new Elementalist(1);
        //TutorialLevel tut = new TutorialLevel(elem);
        //tut.startMission();
        elem.obtainGear(helm);
        elem.levelUp();
        elem.levelUp();
        GameMap testMap = null;
        try {
            testMap = new GameMap(new WorldObject(1, 1, elem), "/Users/rpreda/testMapt.map");
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
            return;
        }
        testMap.printMap();
        /** BaseHero deserialized = null; //Serialization test for the hero objects

        elem.obtainGear(chest);
        FileOutputStream fileOut;
        try {
            elem.saveToFile("/Users/rpreda/heroSave.ser");
        }
        catch (Exception e) {}

        try {
            deserialized = BaseHero.constructFromFile("/Users/rpreda/heroSave.ser");

        } catch (Exception e) {System.out.println(e.getMessage());}
        System.out.println(elem);
        if (deserialized != null)
            System.out.println(deserialized); **/
        /*
        System.out.println("10 " + swordTest.computeDamageIncrease(10));
        System.out.println("10 " + chest.computeReduction(10));
        Guardian guard = new Guardian();
        Guardian guard2 = new Guardian();
        guard.getItem(chest);
        //guard.getItem(helm);
        System.out.println(guard);
        System.out.println(guard2);
        guard.takeDamage(testBandit.dealDamage());
        guard2.takeDamage(testBandit.dealDamage());
        System.out.println(guard);
        System.out.println(guard2);
        */
       /* Guardian guard2 = new Guardian();
        System.out.println(guard.toString());
        guard.getItem(swordTest);
        guard.getItem(chest);
        guard.getItem(chest);
        guard.getItem(helm);
        System.out.println(guard.toString());
        guard.loseItem(swordTest.getId());
        System.out.println(guard.toString());
        guard.loseGear(BaseArmor.Slot.CHEST);
        System.out.println(guard.toString());
        guard.loseItem(helm.getId());
        System.out.println(guard.toString());*/


        /*Elementalist ele = new Elementalist();
        Guardian guard = new Guardian();
        Ranger rang = new Ranger();
        Warrior warr = new Warrior();

        System.out.println(ele + " " + ele.dealDamage());
        System.out.println(guard + " " + guard.dealDamage());
        System.out.println(rang + " " + rang.dealDamage());
        System.out.println(warr + " " + warr.dealDamage());
        warr.getArtifact(BaseHero.Artifact.GREATSWORD);
        System.out.println(warr + " " + warr.dealDamage());
        warr.levelUp();
        warr.levelUp();
        System.out.println(warr + " " + warr.dealDamage());
        warr.loseArtifact(BaseHero.Artifact.GREATSWORD);
        warr.getArtifact(BaseHero.Artifact.SHIELD);
        warr.takeDamage(100);
        System.out.println(warr + " " + warr.dealDamage());
        warr.takeDamage(100);
        System.out.println(warr + " " + warr.dealDamage());*/
    }
}
