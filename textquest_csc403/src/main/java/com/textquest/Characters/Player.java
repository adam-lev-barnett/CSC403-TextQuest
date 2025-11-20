package com.textquest.Characters;

import com.textquest.Rooms.Room;
import com.textquest.Utilities.Words;
import com.textquest.Inventory_and_Items.*;
import java.lang.NullPointerException;


public class Player extends GameCharacter {
    
    private boolean duckShirt; 

    
    public Player(String name, String desc,Room room) {
        super(name, desc, room);
        this.duckShirt = false;
    }

    public void putOnDuckShirt() {
        this.duckShirt = true;
        this.desc += (". You're wearing a brand new " + ItemCatalog.duckShirt);
        Words.narrate("Your character description has changed.");
    }

    public void takeOffDuckShirt() {
        this.duckShirt = false;
        this.desc = this.desc.replace(". You're wearing a brand new " + ItemCatalog.duckShirt, "");
        CharacterList.duckHead.speak("You're a QUACK-ING idiot! Pick that back up!");
        Words.narrate("Your character description has changed.");
    }

    public boolean duckShirtStatus() {
        return this.duckShirt;
    }

    // public Inventory getInventory() {
    //     return inventory;
    // }

    public void printInventory() {
        System.out.println("Your inventory: " + getInventory());
        System.out.println();
    }
    
    //& Use the following when you need to print what was added/removed to player inventory
    public void addToInventory(Item item) {
        this.inventory.addItem(item);
        System.out.println(item + " was added to inventory.");
        if (item.equals(ItemCatalog.duckShirt)) this.putOnDuckShirt();
    }

    public void removeFromInventory(String itemName) {
        this.inventory.removeItem(itemName);
        if (itemName.equals(ItemCatalog.duckShirt.getNickName())) this.takeOffDuckShirt();
        // System.out.println(itemName + "was removed from inventory.");
    }








}
