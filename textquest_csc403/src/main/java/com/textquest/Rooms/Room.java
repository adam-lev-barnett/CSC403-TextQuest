package com.textquest.Rooms;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.*;;

public class Room {
    String name;
    String desc;
    public Room north;
    public Room south;
    public Room east;
    public Room west;
    Inventory items;

    public Room(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.items = new Inventory();
    }
    
}
