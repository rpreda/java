package net.deployme.Program;
import net.deployme.Characters.Hero.*;

/**
 * Created by rpreda on 04/05/16.
 */
public class Program {
    public static void main(String args[]) {
        Elementalist ele = new Elementalist();
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
        System.out.println(warr + " " + warr.dealDamage());
    }
}
