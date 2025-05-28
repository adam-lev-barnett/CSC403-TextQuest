package com.textquest.Characters;

import com.textquest.Inventory_and_Items.ItemCatalog;
import com.textquest.Rooms.GameMap;


public class CharacterList {

    public static final GameCharacter duckHead = new GameCharacter
        ("Duckhead", 
        "A disembodied, floating head. Part of a large duck mascot costume. It has bloodshot eyes and a bit of dried blood around its mouth.", 
        GameMap.entrance);

        static {
            duckHead.getInventory().addItem(ItemCatalog.duckShirt);
        }
    
    private CharacterList() {}

    }
