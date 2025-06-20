package com.textquest.Rooms;
import com.textquest.Inventory_and_Items.*;

public class Room {
    String name;
    String desc;
    // Traversal will be available in later versions
    /* public Room north; 
    public Room south;
    public Room east;
    public Room west; */
    protected final Inventory inventory;
    private final PuzzleDeque puzzle;
    public boolean solvedPuzzle;

    public Room(String name, String desc) {
        if (name == null || desc == null) throw new NullPointerException("Room fields can't be null");
        this.name = name;
        this.desc = desc;
        this.inventory = new Inventory();
        this.puzzle = new PuzzleDeque();
        this.solvedPuzzle = false;
    }

    public String toString() {
        return name;
    }

    /* 
    public void getAdjacentRooms() {
        System.out.println("North: " + north);
        System.out.println("South: " + south);
        System.out.println("East: " + east);
        System.out.println("West: " + west);
    } */

    public PuzzleDeque getPuzzle() {
        return puzzle;
    }

    public Inventory getRoomInventory() {
        return inventory;
    }

    public boolean getSolvedPuzzle() {
        return this.solvedPuzzle;
    }

    public void solvePuzzle() {
        this.solvedPuzzle = true;
    }

    @Override
// Inventory items, puzzleDQ puzzle, and solvedPuzzle boolean not included. The room is still the same room regardless of the state of the inventory, puzzle, and if the puzzle is solved or not
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Room)) return false;
        Room other = (Room)o;
        return name.equals(other.name) && desc.equals(other.desc);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (name == null) hash = 37 * hash;
        else hash = 37 * hash + name.hashCode();
        if (desc == null) hash = 37 * hash;
        else hash = 37 * hash + desc.hashCode();
        return hash;
    }



    /* Equals accounting for adjacent rooms? -- ignore for now; only one room is available
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
