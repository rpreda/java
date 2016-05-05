package net.deployme.Items;

public abstract class BaseItem {

    private static int idIndex = 1;
    private int minimumLevel;
    private int id;
    protected String name;

    protected BaseItem(String name, int minumLevel) {
        this.name = name;
        this.minimumLevel = minumLevel;
        this.id = idIndex;
        BaseItem.idIndex++;
    }
    public int getId() {
        return id;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getMinimumLevel(){
        return minimumLevel;
    }
    public abstract boolean equals(Object obj);
    public abstract int hashCode();
}
