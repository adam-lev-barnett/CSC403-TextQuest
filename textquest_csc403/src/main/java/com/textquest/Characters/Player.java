package com.textquest.Characters;

import com.textquest.Rooms.Room;
import com.textquest.Inventory_and_Items.*;
import java.lang.NullPointerException;


public class Player extends GameCharacter {
    boolean duckShirt;

    public Player(String name, String desc, int health, Room room) {
        super(name, desc, health, room);
        if (room == null) throw new NullPointerException("Player room cannot be null"); 
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
        desc += (". You're wearing a brand new " + ItemCatalog.duckShirt);
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

    @Override
    public void removeFromInventory(String itemName) {
        this.inventory.removeItem(itemName);
        System.out.println(itemName + "was removed from inventory.");
    }







}
