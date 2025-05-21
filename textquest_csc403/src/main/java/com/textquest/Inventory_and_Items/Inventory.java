package com.textquest.Inventory_and_Items;
import java.util.HashMap;
import java.lang.StringBuilder;

public class Inventory extends HashMap<String, Item> {
    
    public void printInventory() {
        for (Item item : values()) System.out.println(item);
    }

    public String printItemNicknames(){
        return this.keySet().toString();
    }

    public void addItem(Item item) {
        this.put(item.getNickName().toLowerCase(), item);
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
