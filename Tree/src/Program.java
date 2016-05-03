/**
 * Created by rpreda on 03/05/16.
 */

public class Program {

    public static void main(String[] args)
    {
        Tree test = new Tree(10);
        test.add(1);
        test.add(2);
        test.add(13);
        test.add(8);
        test.printTree(test);
        System.out.println();
        test.remove(10);
        test.printTree(test);
    }
}
