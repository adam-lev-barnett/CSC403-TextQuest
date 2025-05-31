package com.textquest.Inventory_and_Items;

public class Item {
    // In later versions, names will be more specific such as "Candy Necklace (remnants)" or the use of symbols instead of "Candy String" - the name variable is used for output only
    // Using nickName will maintain easy user input while allowing more creativity and specificity upon actually printing the item
    String nickName; 
    public String name;
    String desc;

    public Item(String nickName, String name, String desc) {
        if (nickName == null || name == null || desc == null) throw new NullPointerException("Item must have string nickName key and string name value."); 
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

    // Equals and hash are case insensitive to make user input more straightforward so they don't have to care about case 
    // Had to update hash function with equals when ignoring case, but there's no method for str.equalsIgnoreCase() that isn't a boolean. Decided on using to-lower -- It works!

    @Override 
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
