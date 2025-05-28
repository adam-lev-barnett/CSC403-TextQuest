package com.textquest.Characters;
import com.textquest.Inventory_and_Items.*;
import com.textquest.Rooms.*;
import com.textquest.InputOutput.*;
import com.textquest.Utilities.*;

public class GameCharacter {
    private final String name;
    String desc;
    // private final int health; // Health will be used in later versions
    private Room room;
    final Inventory inventory;

    public GameCharacter(String name, String desc,Room room) {
        if (room == null || name == null || desc == null) throw new NullPointerException("Character fields"); 
        this.name = name;
        this.desc = desc;
        // this.health = health;
        this.room = room;
        inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    // Traversal will be available in later versions
    /* public void setRoom(Room newRoom) {
        this.room = newRoom;
    } */

    public Room getRoom() {
        return room;
    }

    //^ Speaking methods just add the character's name before the output
    public void speak(String words) {
        System.out.println(name + ": " + words);
        OutputPause.pause();

    }

    public String speakResponse(String words) {
        return InputScanner.strIn(this.name + ": " + "\"" + words + "\"");
    }

    public String getDesc() {
        return desc;
    }


    //^ Inventory methods
    public Inventory getInventory() {
        return inventory;
    }

    public void addToInventory(Item item) {
        inventory.addItem(item);
    }

    public void removeFromInventory(String itemName) {
        inventory.removeItem(itemName);
    }

    //& Specialized inventory exchange to remove item from character inventory and place into player inventory
    public void giveItem(Item item, Player player) {
        if (this.inventory.hasItem(item.getNickName())) {
            if (player.getInventory().hasItem(item.getNickName())) this.speak("You already have this item, apparently!");
            else if (!this.inventory.hasItem(item.getNickName())) this.speak("Whoops! Looks like I don't have this item to give!");
            else {
                inventory.removeItem(item.getNickName());
                player.getInventory().addItem(item);
            }
        }
    }

    
}
