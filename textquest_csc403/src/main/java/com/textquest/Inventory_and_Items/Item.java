package com.textquest.Inventory_and_Items;

public class Item {
    public String name;
    String desc;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String toString() {
        return name + ": " + desc;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Item other = (Item)o;
        return name.equals(other.name) && desc.equals(other.desc);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 37 + name.hashCode();
        hash = hash * 37 + desc.hashCode();
        return hash;
    }

}
