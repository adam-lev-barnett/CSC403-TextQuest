package com.textquest.Inventory_and_Items;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

// Inventory is similar to PuzzleDeque in form; almost the same as a HashMap, but with restricted use of HashMap methods as well as custom methods
// Uses String keys and Item values for easier user input parsing
// GameCharacters, Players, and Rooms are all instantiated with their own inventories

public class Inventory{
    private final HashMap<String, Item> items = new HashMap<>();
    
    // Printing full sets takes O(N)
    
    public String toString() {
        StringBuilder items = new StringBuilder("");
        if (this.items.isEmpty()) return "Currently, there are no items.";
        for (Item item : this.items.values()) {
            if (this.items.values().size() == 1) items.append(item.getName());
            else items.append(item.getName() + "; ");
        }
        return items.toString();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public Map<String, Item> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public void printInventory() {
        for (Item item : this.items.values()) System.out.println(item);
    }

    // Prints list of usable string keys to remind user what items they can use
    public void printItemNicknames(){
        System.out.println(this.items.keySet().toString());
    }

    public boolean hasItem(String itemNickname) {
        return this.items.containsKey(itemNickname);
    }

    public Item getItem(String itemNickname) {
        return this.items.get(itemNickname);
    }

    // addItem modifies HashMap's put() by only allowing one Item argument. The value assigned is a pre-assigned String "nickname" so that key assignments are controlled and consistent
    //! Can only add items from ItemCatalog class to any inventory, or it throws an error
    public void addItem(Item item) {
        if (item == null) throw new NullPointerException("Cannot add null item to inventory.");
        if (!(ItemCatalog.masterInventory.contains(item))) throw new IllegalArgumentException("Item must already exist in master item catalog to add to inventories");
        this.items.put(item.getNickName(), item);
    }

    // Search for nickName String key instead of Item value because containsValue() would degrade the method to O(N)
    public void removeItem(String itemNickname) {
        if (this.items.containsKey(itemNickname)) {
            this.items.remove(itemNickname);
        }
        else System.out.println(itemNickname + " is not in your inventory!");
    }



 
    
}
