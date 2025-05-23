package com.textquest.Inventory_and_Items;

public class Item {
    String nickName; // Maintains easy user input while allowing more creativity and specificity upon printing the item
    public String name;
    String desc;

    public Item(String nickName, String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String toString() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    //^ Had to update hash function with equals when ignoring case. Decided on to-lower

    @Override //& Equals is case insensitive to make user input more straightforward
    public boolean equals(Object o) { // Item retrieval is not case-sensitive
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Item other = (Item)o;
        return name.equalsIgnoreCase(other.name) && desc.equalsIgnoreCase(other.desc) && nickName.equalsIgnoreCase(other.nickName);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (name == null) {
            hash = hash * 37;
        }
        else {
            hash = hash * 37 + name.toLowerCase().hashCode();
        }
        if (desc == null) {
            hash = hash * 37;
        }
        else {
            hash = hash * 37 + desc.toLowerCase().hashCode();
        }
        if (nickName == null) {
            hash = hash * 37;
        }
        else {
            hash = hash * 37 + nickName.toLowerCase().hashCode();
        }
        return hash;
    }

    /* public static void main(String args[]) {
        Item test1 = new Item("test1", "a Test");
        Item test2 = new Item("Test1", "a test");
        System.out.println(test2.equals(test2));

    } */

}
