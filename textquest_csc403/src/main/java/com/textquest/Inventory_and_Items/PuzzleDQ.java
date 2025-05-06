package com.textquest.Inventory_and_Items;

import java.util.ArrayDeque;

/* 
 * Items can be added to or removed from the deque at any time, even after leaving an area. When the player indicates they have solved the puzzle
 * the items are dequed and compared with the order in which they were supposed to be added
*/

public class PuzzleDQ extends ArrayDeque<Item>{
    ArrayDeque<Item> itemOrder = new ArrayDeque<>();
}
