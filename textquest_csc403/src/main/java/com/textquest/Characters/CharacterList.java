package com.textquest.Characters;
import java.util.HashSet;

import com.textquest.Rooms.GameMap;


public class CharacterList {

    public GameCharacter duckHead() {
        return new GameCharacter
        ("Duckhead", 
        "A disembodied, floating head. Part of a large duck mascot costume. It has bloodshot eyes and a bit of dried blood around its mouth.", 
        5, 
        GameMap.entrance);
    }
}
