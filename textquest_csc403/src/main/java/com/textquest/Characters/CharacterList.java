package com.textquest.Characters;

import com.textquest.Inventory_and_Items.ItemCatalog;
import com.textquest.Rooms.GameMap;

// Creates unmodifiable, static instances of GameCharacter for easy organization of NPCs and access to them without creating new instances of them or this class
// Use this class to instantiate all NPCs and populate their inventories

public class CharacterList {

    public static final GameCharacter duckHead = new GameCharacter
        ("Duckhead", 
        "A disembodied, floating head. Part of a large duck mascot costume. It has bloodshot eyes and a bit of dried blood around its mouth.", 
        GameMap.entrance);

        static {
            duckHead.addToInventory(ItemCatalog.duckShirt);
        }
    
    private CharacterList() {}

    }
