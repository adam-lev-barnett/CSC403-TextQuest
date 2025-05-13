package com.textquest.Inventory_and_Items;

public class Item {
    public String name;
    String desc;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    //^ Had to update hash function with equals when ignoring case. Decided on to-lower

    @Override
    public boolean equals(Object o) { // Item retrieval is not case-sensitive
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Item other = (Item)o;
        return name.equalsIgnoreCase(other.name) && desc.equalsIgnoreCase(other.desc);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 37 + name.toLowerCase().hashCode();
        hash = hash * 37 + desc.toLowerCase().hashCode();
        return hash;
    }

    /* public static void main(String args[]) {
        Item test1 = new Item("test1", "a Test");
        Item test2 = new Item("Test1", "a test");
        System.out.println(test2.equals(test2));

    } */

}
