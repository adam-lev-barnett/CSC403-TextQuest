package com.textquest.Rooms;
import com.textquest.Inventory_and_Items.*;

//! Need to override hashcode

public class Room {
    String name;
    String desc;
    public Room north; 
    public Room south;
    public Room east;
    public Room west;
    public Inventory items;
    public final PuzzleDQ puzzle;
    public boolean solvedPuzzle;

    public Room(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.items = new Inventory();
        this.puzzle = new PuzzleDQ();
        this.solvedPuzzle = false;
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

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Room)) return false;
        Room other = (Room)o;
        if (this.items.size() != other.items.size()) return false;
        if (this.puzzle.size() != other.puzzle.size()) return false;
        for (String itemName : this.items.keySet()) {
            if (!other.items.containsKey(itemName) || (!(other.items.get(itemName)).equals(this.items.get(itemName)))) return false;
        }
        if (!(this.puzzle.containsAll(other.puzzle))) return false;
        return name.equals(other.name) && desc.equals(other.desc) && this.items.equals(other.items) && this.puzzle.equals(other.puzzle);
    }

    public void solvePuzzle() {
        this.solvedPuzzle = true;
    }

    /* Equals accounting for adjacent rooms?
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Room)) return false;
        Room other = (Room)o;
        if (this.items.size() != other.items.size()) return false;
        if (this.puzzle.size() != other.puzzle.size()) return false;
        for (String itemName : this.items.keySet()) {
            if (!other.items.containsKey(itemName) || (!(other.items.get(itemName)).equals(this.items.get(itemName)))) return false;
        }
        if (!(this.puzzle.containsAll(other.puzzle))) return false;
        return name.equals(other.name) && desc.equals(other.desc) && this.north.equals(other.north) && this.south.equals(other.south) && this.east.equals(other.east) &&
        this.west.equals(other.west) && this.items.equals(other.items) && this.puzzle.equals(other.puzzle);
    } */
    
}
