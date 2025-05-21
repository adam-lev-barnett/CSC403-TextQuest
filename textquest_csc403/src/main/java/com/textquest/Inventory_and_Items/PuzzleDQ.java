package com.textquest.Inventory_and_Items;

import java.util.ArrayDeque;
import com.textquest.Utilities.*;
import com.textquest.Rooms.*;
import com.textquest.InputOutput.*;
import com.textquest.Characters.*;

/* 
 * Items can be added to or removed from the deque at any time, even after leaving an area. When the player indicates they have solved the puzzle
 * the items are dequed and compared with the order in which they were supposed to be added
 * Deque is choden over an array due to item insertion and removal needing to be in constant time
*/

public class PuzzleDQ extends ArrayDeque<Item>{

    public int getSize() {
        return this.size();
    }

    public PuzzleDQ clone(PuzzleDQ toBeCloned) {
        this.addAll(toBeCloned);
        return this;
    }

    
}
