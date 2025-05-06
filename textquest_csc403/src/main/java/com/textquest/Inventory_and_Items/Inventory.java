package com.textquest.Inventory_and_Items;
import java.util.HashMap;

public class Inventory extends HashMap<String, Item> {
    
    public void printInventory() {
        for (Item item : values()) System.out.println(item);
    }
}
