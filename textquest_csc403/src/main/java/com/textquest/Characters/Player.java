package com.textquest.Characters;

import com.textquest.Rooms.Room;
import com.textquest.Utilities.Words;
import com.textquest.Inventory_and_Items.*;
import java.lang.NullPointerException;


public class Player extends GameCharacter {
    
    boolean duckShirt; 

    //& Player 
    public Player(String name, String desc,Room room) {
        super(name, desc, room);
        if (room == null || name == null || desc == null) throw new NullPointerException("Player fields"); 
        this.duckShirt = false;
    }
    
    // Commenting out future features 
    /* 
    public void traverse(String direction) {
        switch (direction) {
            case "north": 
                if (room.north == null) System.out.println("There's nothing that way.");
                else room = room.north;
                break;
            case "south":
                if (room.south == null) System.out.println("There's nothing that way.");
                else room = room.south;
                break;
            case "east":
                if (room.east == null) System.out.println("There's nothing that way.");
                else room = room.east;
                break;
            case "west":
                if (room.east == null) System.out.println("There's nothing that way.");
                else room = room.west;
                break;
            default:
                System.out.println("You cannot go this direction.");
        }
    } */

    public void putOnDuckShirt() {
        duckShirt = true;
        // desc += (". You're wearing a brand new " + ItemCatalog.duckShirt);
        Words.narrate("Your character description has changed.");
    }

    public Inventory getInventory() {
        return inventory;
    }


    public void printInventory() {
        System.out.println("Your inventory: " + getInventory());
        System.out.println("");
    }
    
    //& Use the following when you need to print what was added/removed to player inventory
    public void addToInventory(Item item) {
        inventory.addItem(item);
        System.out.println(item + "was added to inventory.");
        printInventory();
    }

    public void removeFromInventory(String itemName) {
        this.inventory.removeItem(itemName);
        System.out.println(itemName + "was removed from inventory.");
    }







}
