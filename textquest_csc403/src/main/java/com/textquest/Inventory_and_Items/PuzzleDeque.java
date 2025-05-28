package com.textquest.Inventory_and_Items;
import java.util.ArrayDeque;
import java.util.Collections;


/* 
 * Items can be added to or removed from the deque at any time, even after leaving an area. When the player indicates they have solved the puzzle
 * the items are dequed and compared with the order in which they were supposed to be added
 * Deque is chosen over an array due to item insertion and removal needing to be in constant time
*/

//! Deque is wrapped in PuzzleDeque so only certain methods are accessible

public class PuzzleDeque {
    private final ArrayDeque<Item> puzzleDeque;
    
    public PuzzleDeque (){
        this.puzzleDeque = new ArrayDeque<>();
    }

    public void add(Item item) {
        this.puzzleDeque.add(item);
    }

    public Item poll() {
        return this.puzzleDeque.poll();
    }

    public Item pop() {
        return this.puzzleDeque.pop();
    }

    public Item pollLast() {
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

    @Override
    public String toString() {
        return puzzleDeque.toString();
    }












    
}
