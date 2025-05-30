package com.textquest.Inventory_and_Items;
import java.util.ArrayDeque;
import java.lang.StringBuilder;


//! ArrayDeque is wrapped in PuzzleDeque so only certain ArrayDeque methods are accessible

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
        StringBuilder sb = new StringBuilder("Current item order: ");
        for (Item item : puzzleDeque) sb.append(item + "; ");
        return sb.toString();
    }

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

