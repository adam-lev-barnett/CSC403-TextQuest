package com.textquest.Characters;

import com.textquest.*;

public class Player extends GameCharacter {
    
    public Player(String name, String desc, int health, Room room, Inventory inventory) {
        super(name, desc, health, room, inventory);
    }
    
    public void traverse(String direction) {
        switch (direction) {
            case "North": 
                Player.room = room.north;
        }
    }
}
