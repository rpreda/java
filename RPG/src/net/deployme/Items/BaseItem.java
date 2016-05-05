package net.deployme.Items;

public abstract class BaseItem {
    protected int minimumLevel;
    public abstract boolean equals(Object obj);
    public abstract int hashCode();
}
