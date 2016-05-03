/**
 * Created by rpreda on 03/05/16.
 */
public class Tree {

    public int key;
    public Tree left, right;

    public Tree(int key)
    {
        this.key = key;
    }

    private void printKey()
    {
        System.out.println(key);
    }

    public void printTree(Tree root)
    {
        if (root == null)
            return;
        printTree(root.left);
        root.printKey();
        printTree(root.right);
    }

    private int min(Tree root)
    {
        if (root.left != null)
            return min(root.left);
        else
            return root.key;
    }

    public void remove(int key)
    {
        this.removeNode(key, this);
    }
    private boolean removeNode(int key, Tree parent)
    {
        if (key < this.key)
        {
            if (left != null)
                return left.removeNode(key, this);
            else
                return false;
        }
        else if (key > this.key)
        {
            if (right != null)
                return right.removeNode(key, this);
            else
                return false;
        }
        else
        {
            if (left != null && right != null)
            {
                this.key = right.min(right);
                right.removeNode(this.key, this);
            }
            else if (parent.left == this)
            {
                parent.left = (left != null) ? left : right;
            }
            else if (parent.right == this)
            {
                parent.right = (left != null) ? left : right;
            }
            return true;
        }
    }

    public boolean add(int key)
    {
        if (key == this.key)
            return false;
        if (key < this.key)
        {
            if (left == null) {
                System.out.println("LEFT " + key + " " + this.key);
                left = new Tree(key);
                return true;
            }
            else
                return left.add(key);
        }
        else
        {
            if (right == null)
            {
                right = new Tree(key);
                System.out.println("RIGHT " + key + " " + this.key);
                return true;
            }
            else
                return right.add(key);
        }
    }

}
