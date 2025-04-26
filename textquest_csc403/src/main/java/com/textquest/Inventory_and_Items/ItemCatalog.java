package com.textquest.Inventory_and_Items;

import java.util.HashSet;

public class ItemCatalog {
    public HashSet<Item> masterInventory = new HashSet<>();
    public Item stick = new Item("Stick", "A basic stick, probably from a tree"); 
    public Item marshmallow = new Item("Marshmallow", "A squishy marshmallow; easily poked");
    public Item burntMarshmallow = new Item("Burnt Marshmallow", "Very gooey. Your fingers might stick together if you're not careful!");

    public void populateItemList() {
        masterInventory.add(stick);
        masterInventory.add(marshmallow);
        masterInventory.add(burntMarshmallow);

    }
}
