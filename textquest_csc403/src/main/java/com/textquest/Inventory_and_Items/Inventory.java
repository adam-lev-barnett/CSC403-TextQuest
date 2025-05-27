package com.textquest.Inventory_and_Items;
import java.util.HashMap;
import java.lang.StringBuilder;

//! Need to junit test for item equals and hashcode

public class Inventory extends HashMap<String, Item> {
    
    // Printing full sets takes O(N)
    
    @Override
    public String toString() {
        StringBuilder items = new StringBuilder("Current inventory: ");
        for (Item item : this.values()) {
            items.append(item.getName() + ", ");
        }
        return items.toString();
    }

    public void printInventory() {
        for (Item item : values()) System.out.println(item);
    }

    // Prints list of usable string keys for easier user input
    public String printItemNicknames(){
        return this.keySet().toString();
    }

    public void addItem(Item item) {
        if (item == null) throw new NullPointerException("Cannot add null item to inventory.");
        if (!(ItemCatalog.masterInventory.contains(item))) throw new IllegalArgumentException("Item must already exist in master item catalog to add to inventories");
        if (this.containsKey(item.getNickName())) throw new IllegalArgumentException("Cannot add duplicate items or overwrite inventory values");
        else this.put(item.getNickName().toLowerCase(), item);
    }

    public void removeItem(Item item) {
        if (this.containsKey(item.getNickName())) this.remove(item.getNickName());
        else System.out.println(item + " is not in your inventory!");
    }

 
    
}
