package com.textquest.Rooms;
import com.textquest.Characters.*;
import com.textquest.Inventory_and_Items.*;
import java.util.ArrayList;

public class Room {
    String name;
    String desc;
    public Room north;
    public Room south;
    public Room east;
    public Room west;
    public Inventory items;
    public PuzzleDQ puzzle;

    public Room(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.items = new Inventory();
        this.puzzle = new PuzzleDQ();
    }

    public String toString() {
        return name;
    }

    public void getAdjacentRooms() {
        System.out.println("North: " + north);
        System.out.println("South: " + south);
        System.out.println("East: " + east);
        System.out.println("West: " + west);
    }

    public PuzzleDQ getPuzzle() {
        return puzzle;
    }

    public Inventory getItems() {
        return items;
    }
    
}
