package net.deployme.Program;
import net.deployme.Characters.Enemy.Bandit;
import net.deployme.Characters.Hero.*;
import net.deployme.Items.Armor.AdeptChest;
import net.deployme.Items.Armor.AdeptHelm;
import net.deployme.Items.Weapons.Sword;

public class Program {
    public static void main(String args[]) {
        Sword swordTest = new Sword();
        Bandit testBandit = new Bandit();
        AdeptHelm helm = new AdeptHelm();
        AdeptChest chest = new AdeptChest();

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
