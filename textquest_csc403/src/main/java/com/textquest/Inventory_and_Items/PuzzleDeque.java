package com.textquest.Inventory_and_Items;
import java.util.ArrayDeque;
import java.lang.StringBuilder;


//! ArrayDeque is wrapped in PuzzleDeque so only certain ArrayDeque methods are accessible, similar to Inventory

/* 
Items can be added to or removed from the deque at any time, even after leaving an area until the player indicates they have solved the puzzle
For the puzzles (see puzzles) the items are dequeued and compared with the order in which they were supposed to be added
Uses ArrayDeque over Queue to undo item insertion (from user input) in constant time

Items are returned to player inventory and removed from the PuzzleDeque upon failure
Items removed from PuzzleDeque and don't go back to player inventory upon success
*/

// Reasons for ArrayDeque over ArrayList:
//& • Removal of items for comparisons is simpler and doesn't require keeping track of shifting indices
//& • Puzzles poll() items one at a time from submitted PuzzleDeque to avoid iterating through the entire PuzzleDeque and unnecessarily assigning everything to a variable if the puzzle is incorrect before reaching the last item
//& • PuzzleDQ pollLast() remaining items directly into the player's inventory with a while loop (takes O(N) based on what's left in the PuzzleDQ)

// See Puzzle class for full implementation with user input logic and inventory interaction

public class PuzzleDeque {
    private final ArrayDeque<Item> puzzleDeque;

    public PuzzleDeque (){
        this.puzzleDeque = new ArrayDeque<>();
    }

    public void add(Item item) {
        if (item == null) throw new NullPointerException("Cannot add null item to puzzle");
        if (!(ItemCatalog.masterInventory.contains(item))) throw new IllegalArgumentException("Item must already exist in master item catalog to add to inventories");
        this.puzzleDeque.add(item);
    }

    public Item poll() {
        return this.puzzleDeque.poll();
    }

    public Item undo() {
        return this.puzzleDeque.pollLast();
    }

    public int getSize() {
        return this.puzzleDeque.size();
    }

    public boolean isEmpty() {
        return this.puzzleDeque.isEmpty();
    }

    public boolean contains(Item item) {
        return this.puzzleDeque.contains(item);
    }

    public String toString() {
        if (this.puzzleDeque.isEmpty()) return "Puzzle is empty.";
        System.out.println("");
        StringBuilder sb = new StringBuilder("Current item order: ");
        for (Item item : puzzleDeque) sb.append(item + "; ");
        return sb.toString();
    }

    // equals only needed for testing, but Java's ArrayDeque uses ArrayLists for equality or does not compare order; created automated tests using ArrayLists for comparison
    // partially because items in the middle of the deque are incomparable unless removed, making it difficult to perform any actions on the now-empty deques

    /* @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(this.getClass() == o.getClass())) return false;
        PuzzleDeque other = (PuzzleDeque)o;
        if ((this.puzzleDeque == null) ^ (other.puzzleDeque == null)) return false;
        if (this.getSize() != other.getSize()) return false;
        return this.puzzleDeque.equals(other.puzzleDeque); 
        }
    
    @Override
    public int hashCode() {
        int hash = 17;
        if (this.puzzleDeque == null) hash = 37 * hash;
        for (Item item : this.puzzleDeque) { // unnecessary null check for each item because puzzleDQ throws an error when trying to add null items
            hash = 37 * hash + item.hashCode();
        }
        return hash;
    } */

}

