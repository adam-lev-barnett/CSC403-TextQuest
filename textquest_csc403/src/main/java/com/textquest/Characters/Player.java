package com.textquest.Characters;

import com.textquest.Rooms.Room;
import com.textquest.Inventory_and_Items.*;
import com.textquest.*;
import com.textquest.InputOutput.*;
import java.util.Scanner;


public class Player extends GameCharacter {
    boolean duckShirt;

    public Player(String name, String desc, int health, Room room) {
        super(name, desc, health, room);
        boolean duckShirt = false;
    }
    
    public void traverse(String direction) {
        switch (direction) {
            case "North": 
                room = room.north;
                break;
            case "South":
                room = room.south;
                break;
            case "East":
                room = room.east;
                break;
            case "West":
                room = room.west;
                break;
            default:
                System.out.println("You cannot go this direction.");
        }
    }

    @Override
    public void addInventory(String itemName, Item item) {
        inventory.put(itemName, item);
        System.out.println(item + "was added to inventory.");
    }

    @Override
    public void removeFromInventory(String itemName) {
        inventory.remove(itemName);
        System.out.println(itemName + "was removed from inventory.");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void putOnDuckShirt() {
        duckShirt = true;
        desc += ("Clad in a brand new" + ItemCatalog.duckShirt);
    }



}
