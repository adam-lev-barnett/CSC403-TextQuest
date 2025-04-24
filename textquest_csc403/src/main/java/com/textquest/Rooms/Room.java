package com.textquest.Rooms;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.*;;

public class Room {
    String name;
    String desc;
    Room north;
    Room south;
    Room east;
    Room west;
    Inventory items;

    public Room(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.items = null;
    }
    
}
