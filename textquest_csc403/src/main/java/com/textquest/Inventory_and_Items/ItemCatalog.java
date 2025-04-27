package com.textquest.Inventory_and_Items;

import java.util.HashSet;

public class ItemCatalog {
    public static HashSet<Item> masterInventory = new HashSet<>();
    public static Item stick = new Item("Stick", "A basic stick, probably from a tree"); 
    public static Item marshmallow = new Item("Marshmallow", "A squishy marshmallow; easily poked");
    public static Item burntMarshmallow = new Item("Burnt Marshmallow", "Very gooey. Your fingers might stick together if you're not careful!");
    public static Item spatula = new Item("Spatula", "A nice wooden spatula with no slats. Great for patty-flipping.");
    public static Item runeBurger1 = new Item("Runeburger (Triangle)", "A mysterious meat patty with a triangle underneath. See what happens if you flip it!");
    public static Item runeBurger2 = new Item("Runeburger (Circle)", "A mysterious meat patty with a circle underneath. See what happens if you flip it!");
    public static Item runeBurger3 = new Item("Runeburger (Square)", "A mysterious meat patty with a square underneath. See what happens if you flip it!");

    
    public void populateItemList() {
        masterInventory.add(stick);
        masterInventory.add(marshmallow);
        masterInventory.add(burntMarshmallow);

    }
}
