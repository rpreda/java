package net.deployme.Program;
import net.deployme.Characters.Hero.*;
import net.deployme.Items.Armor.AdeptChest;
import net.deployme.Items.Weapons.Sword;

public class Program {
    public static void main(String args[]) {
        Sword swordTest = new Sword();
        AdeptChest chest = new AdeptChest();

        System.out.println("10 " + swordTest.computeDamageIncrease(10));
        System.out.println("10 " + chest.computeReduction(10));
        Guardian guard = new Guardian();


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
