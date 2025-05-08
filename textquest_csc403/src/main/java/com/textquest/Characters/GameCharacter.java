package com.textquest.Characters;
import com.textquest.Inventory_and_Items.*;
import com.textquest.Rooms.*;
import com.textquest.InputOutput.*;

public class GameCharacter {
    String name;
    String desc;
    int health;
    Room room;
    public Inventory inventory;

    public GameCharacter(String name, String desc, int health, Room room) {
        this.name = name;
        this.desc = desc;
        this.health = health;
        this.room = room;
        inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public void addInventory(String itemName, Item item) {
        inventory.put(itemName, item);
    }

    public void removeFromInventory(String itemName) {
        inventory.remove(itemName);
    }

    public void setRoom(Room newRoom) {
        this.room = newRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void speak(String words) {
        System.out.println(name + ": " + words);
    }

    public String speakResponse(String words) {
        return InputScanner.strIn(this.name + ": " + "\"" + words + "\"");
    }
    
}
