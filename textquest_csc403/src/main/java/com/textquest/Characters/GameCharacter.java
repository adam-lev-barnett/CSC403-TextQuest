package com.textquest.Characters;
import com.textquest.Inventory_and_Items.*;
import com.textquest.Rooms.*;

public class GameCharacter {
    String name;
    String desc;
    int health;
    Room room;
    Inventory inventory = new Inventory();

    public GameCharacter(String name, String desc, int health, Room room) {
        this.name = name;
        this.desc = desc;
        this.health = health;
        this.room = room;
    }

    public void addToInventory(String itemName, Item item) {
        inventory.inventory.put(itemName, item);
    }

}
