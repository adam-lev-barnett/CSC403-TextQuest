package com.textquest.Inventory_and_Items;

import java.util.ArrayDeque;
import com.textquest.Utilities.*;
import com.textquest.Rooms.*;
import com.textquest.InputOutput.*;
import com.textquest.Characters.*;

/* 
 * Items can be added to or removed from the deque at any time, even after leaving an area. When the player indicates they have solved the puzzle
 * the items are dequed and compared with the order in which they were supposed to be added
*/

public class PuzzleDQ extends ArrayDeque<Item>{
    ArrayDeque<Item> puzzle = new ArrayDeque<>();
    public int items;

    public PuzzleDQ(Item... elements) {
        for (Item item : elements) {
            puzzle.add(item);
        }
        items = puzzle.size();
    }

    public boolean sizeCheck(PuzzleDQ other) {
        if (other.size() != items) {
            Words.narrate("You need to use more items.");
            return false;
        }
        return true;
    }

    public int getSize() {
        return items;
    }


}
