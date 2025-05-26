package com.textquest.Inventory_and_Items;
import java.util.HashMap;
import java.lang.StringBuilder;

//! Need to junit test for item equals and hashcode

public class Inventory extends HashMap<String, Item> {
    
    public void printInventory() {
        for (Item item : values()) System.out.println(item);
    }

    public String printItemNicknames(){
        return this.keySet().toString();
    }

    public void addItem(Item item) {
        if (item == null) throw new NullPointerException("Cannot add null item to inventory.");
        else this.put(item.getNickName().toLowerCase(), item);
    }

    @Override
    public String toString() {
        StringBuilder items = new StringBuilder("Current inventory: ");
        for (Item item : this.values()) {
            items.append(item.getName() + ", ");
        }
        return items.toString();
    }
    
}
